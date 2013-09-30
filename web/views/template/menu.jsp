<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="menuLogo">
    <div class="container">
        <div class="row">
            <div class="mainLogo ">
                <div class="span12 ">
                    <div class="menuLogo ">
                        <center>
                            <a href="${pageContext.request.contextPath}"> <img  src="${pageContext.request.contextPath}/public/img/logo.png"/></a>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </div>  
</div>  
<div class="greenLine "></div>
<div class="menuSearch">
    <div class="container">
        <div class="row">
            <div class="menuSearch">
                <div class="span12 ">
                    <div class="content-center " style="padding-top: 10px;">
                        <form class="bs-docs-example" method="post" action="${pageContext.request.contextPath}/searchMovie">
                            <div class="input-append">
                                <input name="searchInput"  id="searchInput" type="text" class="span4" placeholder="Search">
                                <div class="btn-group">                                    
                                    <select name="searchType" id="searchType" class="dropdown-toggle btn btn-blue" style="width: 120px">                                        
                                        <option value="T" selected="true">Title</option>
                                        <option value="G">Genre</option>
                                        <option value="Y">Year</option>
                                    </select>
                                    <button style="margin-left: 10px; width: 100px" class="btn btn-success" >Search</button>                                    
                                </div>
                            </div>
                        </form>           
                    </div>
                </div>
            </div>
        </div>
    </div>  
</div>  
<div class="menuOption">
    <div class="container">
        <div class="row">
            <div class="">
                <div class="span12 ">
                    <div class="menuOption" style="">
                        <ul id="nav">
                            <li><a href="${pageContext.request.contextPath}">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}">Our Products</a></li>
                            <li><a href="${pageContext.request.contextPath}">FAQs</a></li>
                            <li><a href="${pageContext.request.contextPath}">Contact</a></li>
                            <li><a href="${pageContext.request.contextPath}">Login</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>  
</div>  
