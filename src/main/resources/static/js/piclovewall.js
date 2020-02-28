$(function(){
    $(".heartPic li").hover(function(){
        $(this).addClass("on");
        $(this).find("img").animate({"width":"200px","height":"200px"});
        $(this).find("div").animate({"width":"200px","height":"200px"});
        $(this).find(".pTxt").animate({"width":"200px","height":"20px"});
        $(this).find("p").addClass("showDiv");
    },function(){
        $(this).animate({height:"100px"},100).removeClass("on");
        $(this).find("img").stop(true,true).animate({"width":"100px","height":"100px"});
        $(this).find("div").stop(true,true).animate({"width":"100px","height":"100px"});
        $(this).find(".pTxt").stop(true,true).animate({"width":"0px","height":"0px"});
    });
})