<%@ taglib prefix="s" uri="/struts-tags"%>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="span12">
            <div class="headblocktitle">Movie Details</div>
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
        <s:form name="form" id="form"  theme="simple" enctype="multipart/form-data">
            <table    nowrap align="center" border="0" cellpadding="6" cellspacing="3"  width="40%">       
                <tr>
                    <td colspan="2">     
                        <div class="thumbnail" style="padding: 0">
                            <div style="padding:4px">
                                <img src="${pageContext.request.contextPath}/public/moviepic/<s:property value="movie.movieId"/>.png"> 
                            </div>
                            <div class="caption">
                                <h2><s:property value="movie.movieTitle"/></h2>                                
                                <p><s:label  value="%{movie.description}" /></p>
                                <p><i class="icon icon-map-marker"></i>Year :<s:property value="movie.releaseYear"/> </p>
                            </div>
                            <s:if test="%{movieRent.price!=null}"> 
                            <div class="modal-footer" style="text-align: left">
                                <h4>Rent Stock</h4>                                
                                <div class="progress  progress-striped active" style="background: #ddd">
                                    <div class="bar" style="width: <s:property  value="(movieRent.rented*100)/movieRent.stock" />%;"></div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span4 pull-left"><b><s:property value="movieRent.rented"/> out of <s:property value="movieRent.stock"/><br/>$<s:property value="movieRent.price"/></b></div><br/>
                                    <div class="span4 pull-right"><a  href="#RentModal" data-toggle="modal" class="btn btn-blue btn-size-action" >Rent</a></div>
                                </div>
                            </div>
                            </s:if>                            
                            <s:if test="%{movieBuy.price!=null}"> 
                            <div class="modal-footer" style="text-align: left">
                                <h4>Buy</h4>  
                                <div class="row-fluid">
                                    <div class="span4 pull-left"><b>In Stock <s:property value="movieBuy.stock"/> <br/>$<s:property value="movieBuy.price"/></b></div>
                                    <div class="span4 pull-right"><a href="#BuyModal" data-toggle="modal" class="btn btn-yellow  btn-size-action" >Buy</a></div>
                                </div>
                            </div>
                            </s:if>
                        </div>
                    </td>	
                </tr>  						
            </table>	
        </s:form>
    </div> 
</div>  
<!--
modal rent
-->
<div id="RentModal" class="modal hide fade">
    <div class="modal-header">
        <button class="close" data-dismiss="modal">×</button>
        <h3>Please select your options?</h3>
    </div>
    <div class="modal-body">
        <div class="row-fluid">
            <div class="span12">
                <div class="span6">
                    <div class="logowrapper">
                        <img src="${pageContext.request.contextPath}/public/moviepic/<s:property value="movie.movieId"/>.png"> 
                    </div>
                </div>
                <div class="span6">
                    <form class="form-horizontal">
                        <div class="help-block">
                            <center>
                            <button type="submit" class="btn btn-large btn-info">Add to Cart</button>
                            </center>
                        </div>
                        <hr>
                        <div class="help-block">
                            <center>
                            <button type="submit" class="btn btn-large btn-info">Check Out</button>
                            </center>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <p><i>CQU. DvD Store</i></p>
    </div>
</div>
<!--
modal rent
-->
<!--
modal buy
-->
<div id="BuyModal" class="modal hide fade">
    <div class="modal-header">
        <button class="close" data-dismiss="modal">×</button>
        <h3>Please select your 'buy' options?</h3>
    </div>
    <div class="modal-body">
        <div class="row-fluid">
            <div class="span12">
                <div class="span6">
                    <div class="logowrapper">
                        <img src="${pageContext.request.contextPath}/public/moviepic/<s:property value="movie.movieId"/>.png"> 
                    </div>
                </div>
                <div class="span6">
                    <form class="form-horizontal">
                        <div class="help-block">
                            <center>
                            <button type="submit" class="btn btn-large btn-info">Add to Cart</button>
                            </center>
                        </div>
                        <hr>
                        <div class="help-block">
                            <center>
                            <button type="submit" class="btn btn-large btn-info">Check Out</button>
                            </center>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <p><i>CQU. DvD Store</i></p>
    </div>
</div>
<!--
modal buy
-->