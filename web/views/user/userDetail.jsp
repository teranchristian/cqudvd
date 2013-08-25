<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
    $(document).ready(function() {
        $("#form").validate({
            rules: {
                "user.firstName": {
                    required: true
                },
                "user.lastName": {
                    required: true
                },
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
<br/>
<div class="wrap-body" >
    <div class=" container well">
        <div class="row">
            <div class="offset3 span6 offset3">
                <div class="headtitle">Update Your Detail</div>
            </div>
        </div>
    </div>
    <div class="container well">	
        <table  nowrap align="center" border="0" cellpadding="3" cellspacing="3">   
            <tr>
                <td align="center"  >
                    <s:label value="%{msg}" ></s:label>
                    </td>
                </tr>
            </table>
        <s:form name="form" id="form" action="user/updateUser" method="post" theme="simple" >
            <table    nowrap align="center" border="0" cellpadding="6" cellspacing="3"  width="40%">       
                <tr>
                    <td colspan="2">     
                        <div id="error" class="errorFormat"></div>
                        <input type="hidden"  maxlength="50" size="30" value="" />
                    </td>	
                </tr>                 
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="user.firstName" class="control-label lblinput">First Name :   </label>
                            <div class="controls pull-right">
                                <s:textfield type="text"  name="user.firstName" maxlength="50" size="30" />
                                <div id="errorE" class="errorFormat"></div>
                            </div>
                        </div>
                    </td>	
                </tr>	
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="user.lastName" class="control-label lblinput">Last Name :</label>
                            <div class="controls pull-right">
                                <s:textfield  name="user.lastName" maxlength="50" size="25"/>
                                <div id="errorE" class="errorFormat"></div>
                            </div>
                        </div>   
                    </td>	
                </tr>	
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="user.phoneNumber" class="control-label lblinput">Phone Number :</label>   
                            <div class="controls pull-right">
                                <s:textfield  name="user.phoneNumber" maxlength="10" size="10"/>
                                <div id="errorE" class="errorFormat"></div>
                            </div>
                        </div>
                    </td>	
                </tr>	
                <tr>
                    <td colspan="2">
                        <div class="control-group">
                            <label for="user.address" class="control-label lblinput">Address :</label>      
                            <div class="controls pull-right">
                                <s:textfield  name="user.address" maxlength="50" size="25"/>
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
