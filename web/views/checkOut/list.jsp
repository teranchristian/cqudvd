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
                <div class="headblocktitle">View Cart</div>
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
                                Description
                            </th>
                            <th class="mainlistheading" style="width: 5%">
                                Type
                            </th>
                            <th class="mainlistheading" style="width: 5%">
                                price
                            </th>						
                            <th class="mainlistheading" style="width: 5%">
                                del
                            </th>						
                        </tr>
                    </thead>
                    <tbody>
                        <s:set var="total" value="%{0}" />
                        <s:iterator value="%{list}">
                            <tr>
                                <td>
                                    <img src="${pageContext.request.contextPath}/public/moviepic/<s:property value="movie.movieId"/>.png"> 
                                </td>
                                <td>
                                     <s:property value="movie.movieTitle"/>                       
                                </td>
                                <td>
                                    <s:property value="movie.description"/>                       
                                </td>                           
                                <td>
                                    Buy
                                </td>
                                <td>
                                    $<s:property value="price"/>
                                    <s:set var="total" value="%{price + #attr.total}" />
                                </td>
                                <td>
                                    <center><i class="icon-trash" id="delCart" rel="buy" value="<s:property value="movie.movieId"/>"></i></center>
                                </td>
                            </tr>
                        </s:iterator>
                        <s:iterator value="%{listRent}">
                            <tr>
                                <td>
                                    <img src="${pageContext.request.contextPath}/public/moviepic/<s:property value="movie.movieId"/>.png"> 
                                </td>
                                <td>
                                 <s:property value="movie.movieTitle"/>                 
                                </td>
                                <td>
                               <s:property value="movie.description"/> 
                                </td>                           
                                <td>
                                    Rent
                                </td>
                                <td>
                                    $<s:property value="price"/>
                                    <s:set var="total" value="%{price + #attr.total}" />
                                </td>
                                <td>                                    
                                    <center><i class="icon-trash" id="delCart" rel="rent" value="<s:property value="movie.movieId"/>"></i></center>
                                </td>
                            </tr>
                        </s:iterator>
                            <tr>
                                <td class="mainlistheading"  colspan="4">                                    
                                </td>
                                <td>
                                    $<s:property value="%{'' + #attr.total}" /> 
                                </td>
                                <td class="mainlistheading" >                                    
                                </td>
                            </tr>
                    </tbody>                
                </table>
            </s:else>
                    <input type="button" class="pull-left btn-danger btn-large" value="Clear Cart"/><button  class="pull-right btn-warning btn-large" ><i class="icon-lock icon-white"></i> CHECKOUT</button>
            <br/><p/><p/><br/>
        </div>
    </div>
</div>  
<input type="hidden" id="action" value="${pageContext.request.contextPath}/removeItemCart"/>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/public/js/actions.js"></script>