$(function() {
    // 页面加载初始化, 默认是风景先显示
    $("#pType>option[value='风景']").attr("selected", true);

    //对分类进行选择
    $("#typeToType> option").hide();//先全部隐藏
    var selectWord = "#typeToType> option[pType = '" + "风景" + "']";//进行选择的语句,太长了, 就在外面进行拼接了
    $(selectWord).show();//选择属性pType为风景的那一部分显示,其他的由于前面hide()不会显示
    $(selectWord).eq(0).attr("selected", true);


    //这个是最主要的事件, 当选择的分类发生改变的时候, 对分类的类型进行判断选择
    $("#pType").change(function() {

        //获取当前选中的分类名称
        var pType = $("#pType").val();

        //先将所有类型进行隐藏并设置为未选中
        $("#typeToType > option").attr("selected", false).hide();
        // 条件选择选择
        var selectWord = "#typeToType> option[pType = '" + pType + "']";
        // 将pType属性为选中的类型的option设置为显示, 并且排在第一个的标签设置为选中(不设置选中可能会出现bug,可以试一试删除.eq(0).attr("selected", true))
        $(selectWord).show().eq(0).attr("selected", true);//部分显示
    });
})



