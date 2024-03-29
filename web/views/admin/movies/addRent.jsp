<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
    $(document).ready(function() {
        $("#form").validate({
            rules: {
                "movieRent.price": {
                    required: true
                },
                "movieRent.stock": {
                    required: true,
                    digits: true
                }
            },
             messages: { "userImage": "File must be JPG, GIF or PNG, less than 1MB" },
            highlight: function(element) {
                $(element).closest('.control-group').removeClass('success').addClass('error');
            },
            success: function(element) {
                element
                        .addClass('valid')
                        .closest('.control-group').removeClass('error').addClass('success');
            }
        });
    });
</script>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="span12">
            <div class="headblocktitle">Add New Rent Movie</div>
        </div>
    </div>
    <br/>
    <div class="container well">	
        <table  nowrap align="center" border="0" cellpadding="3" cellspacing="3">   
            <tr>
                <td align="center"  >
                    <s:label value="%{msg}" ></s:label>
                    </td>
                </tr>
            </table>
        <s:form name="form" id="form" action="insertRentMovie" method="post" theme="simple" >
            <table    nowrap align="center" border="0" cellpadding="6" cellspacing="3"  width="40%">       
                <tr>
                    <td colspan="2">     
                        <div id="error" class="errorFormat"></div>
                        <input type="hidden"  maxlength="50" size="30"  />
                    </td>	
                </tr>                 
                	
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movie.movieId" class="control-label lblinput">Movie Title :   </label>
                            <div class="controls pull-right">
                                <s:select name="movie.movieId"  label="movie.movieId"  list="%{listForRent}" listKey="movieId" listValue="movieTitle" value="%{movie.movieId}"/>
                            </div>
                        </div>
                    </td>	
                </tr>	
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movieRent.price" class="control-label lblinput">Price: </label>
                            <div class="controls pull-right">
                                <div class="input-prepend input-append">
                                <span class="add-on">$</span>
                                <s:textfield  name="movieRent.price" maxlength="5" size="5" style="width:180px;"/>                                
                                </div> 
                                
                            </div>
                        </div>
                    </td>	
                </tr>
                
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movieRent.stock" class="control-label lblinput">Stock :   </label>
                            <div class="controls pull-right">
                                <s:textfield name="movieRent.stock" maxlength="8" size="8"/>
                            </div>
                        </div>
                    </td>	
                </tr>              
                               
                <tr>
                    <td colspan="2">
                        <div class="modal-footer">  
                            <input type="submit" class="btn btn-success" Value="Save" />
                            <button type="button" class="btn btn-danger" onclick="history.go(-1);">Cancel</button>
                        </div>

                    </td>					
                </tr>						
            </table>	
        </s:form>
    </div> 
</div>  