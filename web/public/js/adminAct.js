//end table    
$(document).ready(function() {  
    
    $('#del').live('click', function(e) {          
        var armID = $(this).attr("value");
        alert(armID);
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
                    $.ajax({
                        type: 'POST',
                        url: $('#action').val(),
                        data: {
                            armID : armID
                        },
                        dataType: "text",
                        cache: false,
                        success: function(o){                      
                            delItem.remove();
                        },
                        error: function() {
                            alert( 'Something goes wrong!' )
                        }
                    });
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
   
    
   
});