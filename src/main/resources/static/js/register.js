function register() {
    //验证通过则回调此方法
    $("#registerForm").validate({
        submitHandler:function (form) {
            doRegister();
        }
    });
}

//展示loading
function g_showLoading(){
    var idx = layer.msg('处理中...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000}) ;
    return idx;
}

function doRegister() {
    //文本框：加载中
    g_showLoading();

    var acct = $("#acct").val();
    var password = $("#password").val();
    var username = $("#username").val();
    var email = $("#email").val();

    $.ajax({
        url: "/do_register",
        type: "POST",
        data:{
            acct:$("#acct").val(),
            password:$("#password").val(),
            username:$("#username").val(),
            email:$("#email").val()
        },
        //回调
        success:function(data){
            if(data){
                layer.msg("注册成功，正在为您前往登陆页面");
                //成功则跳转
                window.location.href="/index";
            }else{
                layer.msg("该账号也被注册，请重新输入");
            }
        },
        //回调，无论成功失败，文本框都要关掉
        error:function(){
            layer.msg("该账号也被注册，请重新输入");
        }
    });

}