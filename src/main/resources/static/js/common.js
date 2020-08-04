var opr = {};

opr.ajaxWithConfirm = function (options) {

    var _this = this;

    var warnTitle = options.title ? options.title : '';
    var warnText = options.text ? options.text : '';


    swal({
        title: warnTitle,
        text: warnText,
        icon: "warning",
        buttons: ["取消", '确定'],
        dangerMode: true,
    })
        .then((ok) => {

        if(ok) {
            _this.ajax(options);
        }


    }
)
.
    catch(err => {
        console.log(err);
    if (err) {
        swal("操作失败!", "请于管理员联系。", "error");
    }
})
    ;
};

opr.ajax = function (options) {

    var _this = this;

    var ajaxUrl = options.url ? options.url : '';
    var ajaxMethod = options.method ? options.method : 'GET';
    var ajaxData = options.data ? options.data : undefined;
    var ajaxContentType = "application/json;charset=utf-8";

    var layer = options.layer ? options.layer : undefined;
    var layuiTable = options.layuiTable ? options.layuiTable : undefined;
    var layuiTableIns = options.layuiTableIns ? options.layuiTableIns : undefined;

    //成功返回json后的回调，若回调返回true继续执行后续默认行为，否则不在执行后续默认行为
    this.responseOkHandler = options.responseOkHandler ? options.responseOkHandler : undefined;
    var index = layer.load(); // 加载层

    $.ajax({
        url: ajaxUrl,
        data: ajaxData,
        method: ajaxMethod,
        contentType: ajaxContentType,
        dataType: 'json',
    }).done(function (result) {

        layer.close(index);

        if (_this.responseOkHandler) {
            if (!_this.responseOkHandler(result)) {
                return;
            }
        }

        console.log(result.message);
        if (result.success) {

            swal({
                text: result.message,
                icon: "success",
                buttons: false,
                timer: 1500
            });
            if (layuiTableIns) layuiTableIns.reload();

        } else {
            swal({
                title: result.message,
                icon: "error",
                button: "确定"
            });
        }

    }).fail(function (xhr) {
        layer.close(index);
        swal({
            title: xhr.status,
            icon: "error",
            button: "确定"
        });
    });
};