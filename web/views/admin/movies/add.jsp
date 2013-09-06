<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
    $(document).ready(function() {
        $("#form").validate({
            rules: {
                "movie.movieTitle": {
                    required: true 
                },
                "movie.releaseYear": {
                    required: true,
                    digits: true
                },
                "movie.description": {
                    required: true 
                },
                "userImage": {
                    required: true,
                    accept: "png|jpe?g|gif", 
                    filesize: 1048576
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
            <div class="headblocktitle">Add new Movie</div>
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
        <s:form name="form" id="form" action="insertMovie" method="post" theme="simple" enctype="multipart/form-data">
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
                            <label for="movie.movieTitle" class="control-label lblinput">Title :   </label>
                            <div class="controls pull-right">
                                <s:textfield  name="movie.movieTitle" maxlength="50" size="30"/>                                
                            </div>
                        </div>
                    </td>	
                </tr>	
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movie.genreId" class="control-label lblinput">Genres :   </label>
                            <div class="controls pull-right">
                                <s:select name="movie.genreId"  label="movie.genreId"  list="%{listGenre}" listKey="genreId" listValue="genre" value="%{movie.genreId}"/>
                            </div>
                        </div>
                    </td>	
                </tr>	
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movie.releaseYear" class="control-label lblinput">Release Year :   </label>
                            <div class="controls pull-right">
                                <s:textfield  name="movie.releaseYear" maxlength="5" size="5"/>                                
                            </div>
                        </div>
                    </td>	
                </tr>
                
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="movie.description" class="control-label lblinput">Description :   </label>
                            <div class="controls pull-right">
                                <s:textarea name="movie.description" cols="40" rows="10"/>
                            </div>
                        </div>
                    </td>	
                </tr>
                <tr>
                    <td >
                        Image:
                    </td><td>       
                            <div class="controls pull-right">
                                <s:file name="userImage"/>
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