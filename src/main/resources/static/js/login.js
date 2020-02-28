function login(){
    //验证通过则回调此方法
    $("#loginForm").validate({
        submitHandler:function (form) {
            doLogin();
        }
    });
}

//展示loading
function g_showLoading(){
    var idx = layer.msg('处理中...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000}) ;
    return idx;
}


function doLogin(){
    //文本框：加载中
    g_showLoading();
    //拿到明文密码
    var inputPass = $("#password").val();
    //用salt拼接明文密码
    var salt = "a9s9j9c9t";
    var str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
    //加密str
    var password = md5(str);
    //异步提交
    $.ajax({
        url: "/do_login",
        type: "POST",
        data:{
            //账号
            acct:$("#acct").val(),
            //密码：MD5计算出来的密码
            password: password
        },
        //回调
        success:function(data){
            layer.closeAll();
            if(data.code == 0){
                layer.msg("登录成功！");
                //成功则跳转
                window.location.href="/home/to_home";
            }else{
                layer.msg(data.msg);
            }
        },
        //回调，无论成功失败，文本框都要关掉
        error:function(){
            layer.msg("请重新核对你的账号和密码！");
        }
    });
}


// 获取url参数
function g_getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null) return unescape(r[2]);
    return null;
};
//设定时间格式化函数，使用new Date().format("yyyyMMddhhmmss");
Date.prototype.format = function (format) {
    var args = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
    };
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var i in args) {
        var n = args[i];
        if (new RegExp("(" + i + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? n : ("00" + n).substr(("" + n).length));
    }
    return format;
};

