<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<br/>
<div class="wrap-body">
    <div class=" container well">
        <div class="row">
            <div class="offset3 span6 offset3">
                <div class="headtitle">Logon</div>
            </div>
        </div>
    </div>
    <div class="container">	
        <table  nowrap align="center" border="0" cellpadding="3" cellspacing="3">   
            <tr>
                <td align="center"  >
                    <s:label value="%{msg}" ></s:label>
                    </td>
                </tr>
            </table>
        <form action="${pageContext.request.contextPath}/validate" method="post" >
            <table  class=""  nowrap align="center" border="0" cellpadding="3" cellspacing="3"  width="25%">       
                <tr>
                    <td colspan="2">     
                        <div id="error" class="errorFormat"></div>
                        <input type="hidden"  maxlength="50" size="25"  />
                    </td>	
                </tr>                 
                <tr>
                    <td colspan="2">
                        <div >
                            Email Address :<br>
                            <input type="text" name="login.email" maxlength="50" size="25" value=""  autocomplete="off" autofocus="autofocus"/>
                            <div id="errorE" class="errorFormat"></div>
                        </div
                    </td>	
                </tr>	
                <tr>
                    <td colspan="2">
                        Password :<br>
                        <input type="password" name="login.password" maxlength="50" size="25" value="" />
                        <div id="errorF" class="errorFormat"></div>
                    </td>	
                </tr>	
                <tr>
                    <td colspan="2" align="right">
                        <input TYPE="submit" class="btn btn-success" Value="Login" />
                    </td>					
                </tr>						
            </table>	
        </form>
    </div> 
</div>
