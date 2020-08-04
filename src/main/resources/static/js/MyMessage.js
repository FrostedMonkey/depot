var opt = {};
opt.alertMessage = function () {
    var goeasy = new GoEasy({
        appkey: 'BC-362e5ffae184440b9043fa653d633f62',
    });
    goeasy.subscribe({
        channel: 'SysMessage',
        onMessage: function (result) {
            if (result != null && one != null) {
                localStorage.setItem("mes", result);
                alert("你有一个新消息: " + result.content);
            }
        }
    });
    goeasy.subscribe({
        channel: 'TwoMessage',
        onMessage: function (result) {
            if (result != null && two != null) {
                localStorage.setItem("mes", result);
                alert("你有一个新消息: " + result.content);
            }
        }
    });
    goeasy.subscribe({
        channel: 'ThreeMessage',
        onMessage: function (result) {
            if (result != null && three != null) {
                localStorage.setItem("mes", result);
                alert("你有一个新消息: " + result.content);
            }
        }
    });

}


