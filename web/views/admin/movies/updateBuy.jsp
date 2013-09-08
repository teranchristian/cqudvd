<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
    $(document).ready(function() {
        $("#form").validate({
            rules: {
                "movie.movieTitle": {
                    required: true 
                },
                "movie.releaseYear": {
                    required: true 
                },
                "movie.description": {
                    required: true 
                }
            },
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
            <div class="headblocktitle">Edit Buy Movie </div>
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
        <s:form name="form" id="form" action="updateBuy" method="post" theme="simple" >
            <s:hidden  name="movieType.movieTypeId" />
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
                            <label for="movieType.movie.movieTitle" class="control-label lblinput">Movie Name :   </label>
                            <div class="controls pull-right">
                                <s:textfield  name="movieType.movie.movieTitle" maxlength="50" size="30" readonly="true"/>   
                                <div id="errorE" class="errorFormat"></div>
                            </div>
                        </div>
                    </td>
                </tr>  
                <tr>  
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movieType.price" class="control-label lblinput">Price :   </label>
                            <div class="controls pull-right">
                            <s:textfield  name="movieType.price" maxlength="50" size="30"/>
                            </div>
                        </div>
                    </td>
                </tr>  
                <tr>                      
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movieType.stock" class="control-label lblinput">Stock :   </label>
                            <div class="controls pull-right">
                            <s:textarea label="Stock" name="movieType.stock" cols="40" rows="10"/>                            
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