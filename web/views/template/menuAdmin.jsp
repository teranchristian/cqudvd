<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="menuLogo">
    <div class="container">
        <div class="row">
            <div class="mainLogo ">
                <div class="span12 ">
                    <div class="menuLogo ">
                        <center>
                            <img  src="${pageContext.request.contextPath}/public/img/logo.png"/>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </div>  
</div>  


<div class="greenLine "></div>

<div class="menuOption">
    <div class="container">
        <div class="row">
            <div class="">
                <div class="span12 ">
                    <div class="menuOption" style="">
                        <ul id="nav">
                            <li><a href="${pageContext.request.contextPath}/admin/genre">Genres</a></li>                  
                            <li class="dropdown">
                                <a href="${pageContext.request.contextPath}/admin/movies" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="100" data-close-others="false">
                                    Movie<b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/admin/movies">Movies</a></li>
                                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/admin/movies/buyMovies">Buy Categories</a></li>
                                    <li class="divider"></li>
                                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/admin/movies/listRentMovies">Rent Categories</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="${pageContext.request.contextPath}/admin/report" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="100" data-close-others="false">
                                    Report<b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/admin/reports/stockReport">Stock Report</a></li>
                                    <li class="divider"></li>
                                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/admin/reports/salesReport">Sales Report</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>  
</div>  
