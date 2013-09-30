<%@ taglib prefix="s" uri="/struts-tags"%>
<br>
<br>
<div class="container">
    <s:if test="%{#list.isEmpty()|| #listRent.isEmpty() }">   
        <br/>
        <br/>
        <div class="hero-unit center">
            <h3>            
                No Products Containing All Your Search Terms Were Found.                
            </h3>
            <h4>
                <font face="Tahoma" color="red">Suggestions:</font>
                <ul class="nav nav-list">
                    <li><i class="icon-chevron-right"></i>Make sure all words are spelt correctly.</li>
                    <li><i class="icon-chevron-right"></i>Try different keywords.</li>
                    <li><i class="icon-chevron-right"></i>Try more general keywords.</li>
                    <li><i class="icon-chevron-right"></i>Try fewer keywords.</li>
                </ul>
            </h4>           
        </div>
    </s:if>
    <s:else>
        <div class="row">
            <div class="span12">
                <div class="headblocktitle">Check out completed</div>
                </div>
            </div>
            <div  style="margin-top: 40px">      
                <div class="mainlist">
                    <table  nowrap align="center" border="0" cellpadding="3" cellspacing="3">   
                        <tr>
                            <td align="center"  > Your confirmation number is :
                                <b><s:label value="%{msg}" ></s:label></b>                        
                            </td>
                        </tr>
                    </table>            
                
            </s:else>
                    
        </div>
    </div>
</div>  
<input type="hidden" id="action" value="${pageContext.request.contextPath}/removeItemCart"/>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/public/js/actions.js"></script>