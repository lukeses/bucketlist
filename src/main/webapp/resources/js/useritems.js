function increaseProgress(id) {
    var progressbar = "progress-bar-" + id;
    var value = $('#' + progressbar).attr('aria-valuenow');
    value = parseInt(value) + 10;
    if(value <= 100)
        $('#progress-bar-' + id).css('width', value+'%').attr('aria-valuenow', value).text(value+'%');    
}

function decreaseProgress(id) {
    var progressbar = "progress-bar-" + id;
    var value = $('#' + progressbar).attr('aria-valuenow');
    value = parseInt(value) - 10;
    if(value >= 0)
    $('#progress-bar-' + id).css('width', value+'%').attr('aria-valuenow', value).text(value+'%');    
}

$(document).ready(function() {
    $(".fancybox")
        .fancybox({
            padding: 0,
            cyclic: true,
            showNavArrows: true
        });
});