<%@ taglib prefix="s" uri="/struts-tags"%>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="span12">
            <div class="headblocktitle">Search Results for <s:label value="%{searchInput}" theme="simple"></s:label></div>
        </div>
    </div>
    <div  style="margin-top: 40px">      
        <div class="mainlist">
            <table  nowrap align="center" border="0" cellpadding="3" cellspacing="3">   
                <tr>
                    <td align="center"  >
                        <s:label value="%{msg}" ></s:label>                        
                    </td>
                </tr>
            </table>
                <input type="hidden" id="action" value="${pageContext.request.contextPath}/admin/deleteMovie"/>
            <table border="0" cellpadding="1px" cellspacing="0px"  nowrap="nowrap"  id="example" class="table-bordered data-table table table-hover" style="border: 1px solid black;">
                <thead>
                    <tr>
                        <th class="mainlistheading" style="width: 11%" >
                            MOVIE COVER
                        </th>
                        <th class="mainlistheading" align="left" valign="center">
                            TITLE
                        </th>
                        <th class="mainlistheading" align="left" valign="center">
                            RELEASE YEAR
                        </th>
                        <th class="mainlistheading" align="left" valign="center">
                            DESCRIPTION
                        </th>	
                        <th class="mainlistheading" style="width: 5%">
                            OPTIONS
                        </th>						
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{list}">
                        <tr>
                            <td>
                               <img src="${pageContext.request.contextPath}/public/moviepic/<s:property value="movieId"/>.png"> 
                            </td>
                            <td>
                                <s:property value="movieTitle"/>                       
                            </td>
                            <td>
                                <s:property value="releaseYear"/>                       
                            </td><td>
                                <s:property value="description"/>                       
                            </td>                            
                            <td>
                                
                            </td<
                    </tr>
                </s:iterator>
                </tbody>                
            </table>
        </div>
    </div>
</div>  
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/public/js/adminAct.js"></script>