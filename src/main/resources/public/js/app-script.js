/**
 * Created by nicolas on 21.04.17.
 */
$(function(){
    $('#messages li').click(function(){
        $(this).fadeOut();
    });
    setTimeout(function(){
        $('#messages li.info').fadeOut();
    }, 3000);
});
