var opc = {};
var one = null;
var two = null;
var three = null;
opc.getRole = function (message) {
    for (var i = 0; i < message.length; i++) {
        if (message[i].roleName == '系统管理员') {
            one = 'sysMessage';
        }
        if (message[i].roleName == '仓库主管') {
            two = 'twoMessage';
        }
        if (message[i].roleName == '仓库管理员') {
            three = 'threeMessage';
        }
    }
}