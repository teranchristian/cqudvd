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
            <div class="headblocktitle">Edit Movie </div>
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
        <s:form name="form" id="form" action="updateMovie" method="post" theme="simple" >
            <s:hidden  name="movie.movieId" />
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
                            <label for="movie.movieTitle" class="control-label lblinput">Movie Name :   </label>
                            <div class="controls pull-right">
                            <s:textfield  name="movie.movieTitle" maxlength="50" size="30"/>   
                                <div id="errorE" class="errorFormat"></div>
                            </div>
                        </div>
                    </td>
                </tr>  
                <tr>  
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movies.releaseYear" class="control-label lblinput">Release Year :   </label>
                            <div class="controls pull-right">
                            <s:textfield  name="movie.releaseYear" maxlength="50" size="30"/>
                            </div>
                        </div>
                    </td>
                </tr>  
                <tr>                      
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movies.description" class="control-label lblinput">Description :   </label>
                            <div class="controls pull-right">
                            <s:textarea label="Description" name="movie.description" cols="40" rows="10"/>                            
                            </div>
                        </div>
                    </td>	
                </tr>			
                <tr>                      
                    <td colspan="2">
                        <div class="control-group">
                            Movie cover :  
                            <div class="controls pull-right">
                                <a href="#" class="thumbnail" style="margin-left:5px;">
                                <img src="${pageContext.request.contextPath}/public/moviepic/${movie.movieId}.png"/>
                                </a>
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