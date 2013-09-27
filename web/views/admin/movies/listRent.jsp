<%@ taglib prefix="s" uri="/struts-tags"%>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="span12">
            <div class="headblocktitle">List of Movies for Rent</div>
        </div>
    </div>
    <br/>
    <div class="row">            
        <button type="button" class="btn btn-warning pull-right" onclick="document.location.href = '${pageContext.request.contextPath}/admin/addRentList';">New Rent Movie</button>                
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
                <input type="hidden" id="action" value="${pageContext.request.contextPath}/admin/deleteRentItem"/>
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
                            PRICE
                        </th>
                        <th class="mainlistheading" align="left" valign="center">
                            STOCK
                        </th>
                        <th class="mainlistheading" align="left" valign="center">
                            RENTED
                        </th><th class="mainlistheading" style="width: 5%">
                            EDIT
                        </th>						
                        <th class="mainlistheading" style="width: 5%">
                            DELETE
                        </th>	
                        						
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{listRent}">
                        
                        <tr>
                            <td>
                               <img src="${pageContext.request.contextPath}/public/moviepic/<s:property value="movie.movieId"/>.png"> 
                            </td>
                            <td>
                                <s:property value="movie.movieTitle"/>                       
                            </td>
                            <td>
                                $ <s:property value="price"/>                       
                            </td><td>
                                <s:property value="stock"/>                       
                            </td>                            
                            </td><td>
                                <s:property value="rented"/>                       
                            </td>                            
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/editRentList?itemId=<s:property value="movieRentId"/>"><center><i class="icon-pencil"></i></center></a>
                            </td>
                            <td>
                            <center><i class="icon-trash" id="del" rel="<s:property value="movie.movieTitle"/>" value="<s:property value="movieRentId"/>"></i></center>
                    </td>
                    </tr>
                </s:iterator>
                </tbody>                
            </table>
        </div>
    </div>
</div>  
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/public/js/adminAct.js"></script>