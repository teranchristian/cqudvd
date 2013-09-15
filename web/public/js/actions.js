//end table    
$(document).ready(function() {  
    
    $('#del').live('click', function(e) {          
        var itemId = $(this).attr("value");
        delItem = $(this).parents('tr');
        delItem.css("background-color","red"); 
        $('<div></div>').appendTo('body')
        .html('<div><font size="3">Are you sure you want to delete :</br><strong>"'+ $(this).attr('rel') +'"</strong> ?</font></div>')
        .dialog({
            title: 'Delete message', 
            autoOpen: true,
            position: [ 'center',e.clientY+20],
            resizable: false,
            draggable: false,
            modal: true,
            buttons: {
                Yes:function ()  {                           
                    post_to_url($('#action').val(),{ "itemId": itemId } );
                    $(this).dialog("close");
                },
                No: function () {
                    delItem.css("background","");                    
                    $(this).dialog("close");
                }
            },
            open: function() {
                $('.ui-dialog-buttonpane').find('button:contains("Yes")').css({
                    "color":"#FFFFFF",
                    "background-color":"#00BD00",
                    "width":"65px"
                });
                $('.ui-dialog-buttonpane').find('button:contains("No")').css({
                    "color":"#FFFFFF",
                    "background-color":"#C30000",
                    "width":"65px"
                });             
            },
            close: function (event, ui) {
                $(this).remove();
            }
        });
    });
   $('#buy').live('click', function(e) { 
        if ($(this).attr('rel')=='A'){
             post_to_url($('#actionA').val(),{ "itemId": $('#movieId').val(),"movieType": "buy" } );
        }
    });
   $('#rent').live('click', function(e) { 
             post_to_url($('#actionA').val(),{ "itemId": $('#movieId').val(),"movieType": "rent" } );
        
    });
   
});

function post_to_url(path, params, method) {
    method = method || "post"; // Set method to post by default if not specified.

    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);

    for(var key in params) {
        if(params.hasOwnProperty(key)) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
         }
    }

    document.body.appendChild(form);
    form.submit();
}