var pic_arr = [
    {   src: "images/pic1.jpg",
        alt: ""  },
    {   src: "images/pic2.jpg",
        alt: "" },
    {   src: "images/pic3.jpg",
        alt: "" },
    {   src: "images/pic4.jpg",
        alt: "" }
];
$(document).ready(function(){
    var $pics = $('#slideshow > .pics li');
    var $points = $('#slideshow > .points li');
    var current = 0;
    var timer = null;

    $("#slideshow > .points li").click(function(){
        $("#slideshow > .pics li").eq(current).removeClass('active');
        $("#slideshow > .points li").eq(current).removeClass('active');
        current = $(this).index();
        $(this).addClass('active');
        $("#slideshow > .pics li").eq(current).addClass('active');

    });
    $("#slideshow > .next").click(function () {
        showNext();
    });
    $("#slideshow > .pre").click(function () {
        showPre();
    })

    function showNext(){
        $("#slideshow > .pics li").eq(current).removeClass('active');
        $("#slideshow > .points li").eq(current).removeClass('active');
        current = (current+1)% ($pics.length);
        $("#slideshow > .pics li").eq(current).addClass('active');
        $("#slideshow > .points li").eq(current).addClass('active');
    }
    function showPre(){
        $("#slideshow > .pics li").eq(current).removeClass('active');
        $("#slideshow > .points li").eq(current).removeClass('active');
        current = (current-1)% ($pics.length);
        $("#slideshow > .pics li").eq(current).addClass('active');
        $("#slideshow > .points li").eq(current).addClass('active');
    }

    timer = setInterval(showNext,4000);

//第一张的前面加上最后一张的
    // $pics.append('<li><img src="'+ pic_arr[pic_arr.length-1].src + '" alt="'+ pic_arr[pic_arr.length-1].alt+ '"></li>');
    // for(var i=0; i<pic_arr.length;i++){
    //     // console.log(i);
    //
    //     $pics.append('<li><img src="'+ pic_arr[i].src + '" alt="'+ pic_arr[i].alt+ '"></li>');
    //
    //     var $point = $('<li></li>')//创建子元素
    //     $point.addClass('point');
    //     $points.append($point);
    // }
    //最后的前面加上第一一张的
    // $pics.append('<li><img src="'+ pic_arr[0].src + '" alt="'+ pic_arr[0].alt+ '"></li>');

    // $('#slideshow > .pics li').addClass('active');
    // $('#slideshow > .points li')[1].addClass('active')
});