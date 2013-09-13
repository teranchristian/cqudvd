<%@ taglib prefix="s" uri="/struts-tags"%>
<br>
<br>
<div class="container">
    <s:if test="%{list.isEmpty()}">   
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
                            <th class="mainlistheading" style="width: 5%">
                                GENRE
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
                                </td>                           
                                <td>
                                    <s:property value="genre.genre"/>
                                </td>
                                <td>
                                    <a class="btn btn-blue" href="${pageContext.request.contextPath}/movieDetails?itemId=<s:property value="movieId"/>" >view</a>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>                
                </table>
            </s:else>
        </div>
    </div>
</div>  
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/public/js/adminAct.js"></script>