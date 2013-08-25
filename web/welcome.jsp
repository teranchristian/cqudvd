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
    <h2 class=" label-info text-center">What's new in store</h2>
    <p>With a bit of extra markup, it's possible to add any kind of HTML content like headings, paragraphs, or buttons into thumbnails.</p>
    <div class="row-fluid">
        <ul class="thumbnails">
            <li class="span4">
                <div class="thumbnail">
                    <img src="public/img/sample.png" alt="">
                    <div class="caption">
                        <h3>Thumbnail label</h3>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        <p><a href="#" class="btn btn-blue btn-size-action" >Rent</a> <a href="#" class="btn btn-size-action btn-yellow pull-right">Buy</a></p>
                    </div>
                </div>
            </li>
            <li class="span4">
                <div class="thumbnail">
                    <img src="public/img/sample.png"alt="">
                    <div class="caption">
                        <h3>Thumbnail label</h3>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        <p><a href="#" class="btn btn-blue btn-size-action">Rent</a> <a href="#" class="btn btn-size-action btn-yellow pull-right">Buy</a></p>
                    </div>
                </div>
            </li>
            <li class="span4">
                <div class="thumbnail">
                    <img src="public/img/sample.png" alt="">
                    <div class="caption">
                        <h3>Thumbnail label</h3>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        <p><a href="#" class="btn btn-blue btn-size-action">Rent</a> <a href="#" class="btn btn-size-action btn-yellow pull-right">Buy</a></p>
                    </div>
                </div>
            </li>
        </ul>
    </div>

</div>
