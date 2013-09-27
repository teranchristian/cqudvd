<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
    $(document).ready(function() {
        $('.carousel').carousel({interval: 7000});
    })
</script>
<br/>
<div class="container" style="background: #36363b!important;">
    <div id="myCarousel" class="carousel slide">
        Carousel items 
        <div class="carousel-inner">
            <div class="active item">
                <img src="public/img/banner1.jpg" />
            </div>
            <div class="item">
                <img src="public/img/banner2.jpg" />
            </div>
            <div class="item">
                <img src="public/img/banner3.jpg" />
            </div>
        </div>
        Carousel nav 
        <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>
</div>
<br/>

<div class="container">
    <h2 class=" label-info text-center">What's in store</h2>
    <br/>
    <p><h4> One of the largest DVD and  Blu-Ray destination. Check out our huge range of movies, TV series!</h4></p>
    <br>
    <div class="row-fluid">
        <ul class="thumbnails">
            <s:iterator value="%{list}">
            <li class="span4">
                <div class="thumbnail">
                    
                    <img src="${pageContext.request.contextPath}/public/moviepic/${movieId}.png"/>
                    <div class="caption">
                        <h3><s:property value="movieTitle"/> </h3>
                        <p><s:property value="description"/> </p>
                        <p><a class="btn btn-blue" href="${pageContext.request.contextPath}/movieDetails?itemId=<s:property value="movieId"/>" >view</a></p>
                    </div>
                </div>
            </li>
            </s:iterator>
        </ul>
    </div>

</div>
