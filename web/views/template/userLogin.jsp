<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="header">
    <div class="container  ">
        <div class="row header">
            <div class=" span12 ">
                <div class="row ">
                    <div class="span6">                        
                        <s:if test="%{#session['userId']== null}">     
                            <h3 class="currentUser pull-left "><a href="login" >Login</a>  | <a href="signUp" >Sign Up</a> </h3> 
                        </s:if>
                        <s:else>
                            <h3 class="currentUser pull-left ">
                                Welcome :
                                <div class="btn-group">
                                    <button class="btn btn-mini btn-inverse" data-toggle="dropdown"><i class="icon-white icon-user"></i> <s:property value="%{#session['userDescr']}" /></button>
                                    <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">
                                        <span class="icon-align-justify"></span>
                                    </button>
                                    <ul class="dropdown-menu ">
                                        <li><a href="${pageContext.request.contextPath}/user/userDetail">Change your detail</a></li>
                                        <li><a href="">Change your password</a></li>
                                    </ul>
                                </div>
                                | <a href="<s:url action="logout"/>" >logout</a> </h3>                      
                            </s:else>
                    </div>
                    <div class="span6">
                        <h3 class="currentUser pull-right">Follow us <img src="${pageContext.request.contextPath}/public/img/facebook.png"/>&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/public/img/twitter.png"/>&nbsp;&nbsp;<img  src="${pageContext.request.contextPath}/public/img/google.png"/> </h3> 
                    </div>
                </div>
            </div>
        </div>
    </div>  
</div>  
