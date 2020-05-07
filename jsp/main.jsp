
<%@ page language="java" contentType="text/html; charset=UTF-8"
import="com.food.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en-US" itemscope="itemscope" itemtype="http://schema.org/WebPage">
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>欢迎来到大餐馆</title>

        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/animate.min.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/font-electro.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/owl-carousel.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/style.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/colors/yellow.css" media="all" />

        <!-- Demo Purpose Only. Should be removed in production -->
        <link rel="stylesheet" href="assets/css/config.css">

        <link href="assets/css/colors/green.css" rel="alternate stylesheet" title="Green color">
        <link href="assets/css/colors/pink.css" rel="alternate stylesheet" title="Pink color">
        <link href="assets/css/colors/blue.css" rel="alternate stylesheet" title="Blue color">
        <link href="assets/css/colors/red.css" rel="alternate stylesheet" title="Red color">
        <link href="assets/css/colors/orange.css" rel="alternate stylesheet" title="Orange color">
        <link href="assets/css/colors/black.css" rel="alternate stylesheet" title="Black color">
        <link href="assets/css/colors/gold.css" rel="alternate stylesheet" title="Gold color">
        <link href="assets/css/colors/yellow.css" rel="alternate stylesheet" title="Yellow color">
        <link href="assets/css/colors/flat-blue.css" rel="alternate stylesheet" title="Flat Blue color">
        <!-- Demo Purpose Only. Should be removed in production : END -->

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,700italic,800,800italic,600italic,400italic,300italic' rel='stylesheet' type='text/css'>

        <link rel="shortcut icon" href="assets/images/fav-icon.png">
    </head>

    <body class="page home page-template-default">
        <div id="page" class="hfeed site">
            <a class="skip-link screen-reader-text" href="#site-navigation">Skip to navigation</a>
            <a class="skip-link screen-reader-text" href="#content">Skip to content</a>

            <div class="top-bar">
	<div class="container">
		<nav>
			<ul id="menu-top-bar-left" class="nav nav-inline pull-left animate-dropdown flip">
				<li class="menu-item animate-dropdown"><a title="Welcome to Worldwide Electronics Store" href="#">欢迎来到大餐馆（BIG RESTAURANT）!</a></li>
			</ul>
		</nav>

		<nav>
		<form action="./user/save" method="post">  
			<ul id="menu-top-bar-right" class="nav nav-inline pull-right animate-dropdown flip">
				<li class="menu-item animate-dropdown"><a title="Store Locator" href="#"><i class="ec ec-map-pointer"></i>北京</a></li>
				<!-- <li class="menu-item animate-dropdown"><a title="Track Your Order" href="track-your-order.html"><i class="ec ec-transport"></i>Track Your Order</a></li> -->
				<li class="menu-item animate-dropdown"><a title="登陆" href="tologin.do"><i class="ec ec-shopping-bag"></i><input type="text" style="border:0;width:120px;readonly = "readonly"  id="username" value="你好，请登录" name="username"/></a></li>
				<li class="menu-item animate-dropdown"><a title="个人空间" href="my-account.html"><i class="ec ec-user"></i>个人空间</a></li>
			
			</ul>
			
			
		</form>  
			
		</nav>
	</div>
</div><!-- /.top-bar -->

            <header id="masthead" class="site-header header-v1">
    <div class="container">
        <div class="row">

            <!-- ============================================================= Header Logo ============================================================= -->
<div class="header-logo">
		<img src="assets/images/slider/logo.png" height="130" width="130" />
</div>
<!-- ============================================================= Header Logo : End============================================================= -->

            <form class="navbar-search" method="get" action="/">
	<label class="sr-only screen-reader-text" for="search"></label>
	<div class="input-group">
		<input type="text" id="search" class="form-control search-field" dir="ltr" value="" name="search"  placeholder="在这里搜索美食" />
		
		<div class="input-group-addon search-categories">
			<select name='product_cat' id='product_cat' class='postform resizeselect' >
			<option value='0' selected='selected'>全部美食</option>
			<%
			GlobalInfo info=new GlobalInfo();
			for(int i=0;i<info.FOODLIST1.length;i++){ %>
				<option class="level-0" value="<%=info.FOODLIST1[i]%>"><%=info.FOODLIST1[i]%></option>
				<% }%>
			</select>
		</div>
		<div class="input-group-btn">
			<input type="hidden" id="search-param" name="post_type" value="product" />
			<button type="submit" class="btn btn-secondary"><i class="ec ec-search"></i></button>
		</div>
	</div>
</form>
           



        <div class="row">
	        <div class="col-xs-12 col-lg-3">
	        	<nav>
	<ul class="list-group vertical-menu yamm make-absolute">
		<li class="list-group-item"><span><i class="fa fa-list-ul"></i> 美食类别</span></li>

		<li class="highlight menu-item animate-dropdown"><a title="Value of the Day" href="home-v2.html">全城最高分</a></li>

		<li class="highlight menu-item animate-dropdown"><a title="Top 100 Offers" href="home-v3.html">全城最热门</a></li>

		<li class="highlight menu-item animate-dropdown"><a title="New Arrivals" href="home-v3-full-color.html">新店种草</a></li>

		<li class="yamm-tfw menu-item menu-item-has-children animate-dropdown dropdown">
			<a title="Computers &amp; Accessories" data-hover="dropdown" href="product-category.html" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">菜系</a>
			<ul role="menu" class=" dropdown-menu">
	<li class="menu-item animate-dropdown menu-item-object-static_block">
		<div class="yamm-content">
			<div class="row">
				<div class="col-sm-6">
					<div class="vc_column-inner ">
						<div class="wpb_wrapper">
							<div class="wpb_text_column wpb_content_element ">
								
									<ul>
										<li class="nav-title">菜品类别</li>
										<%
										for(int i=0;i<info.FOODLIST1.length;i++){ %>
											<li><a href="#"><%=info.FOODLIST1[i]%></a></li>
										<% }%>
										
									</ul>							
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="vc_column-inner ">
						<div class="wpb_wrapper">
							<div class="wpb_text_column wpb_content_element ">
								<div class="wpb_wrapper">
									<ul>
									<li class="nav-title"></li>
										<%
										for(int i=0;i<info.FOODLIST2.length;i++){ %>
											<li><a href="#"><%=info.FOODLIST2[i]%></a></li>
										<% }%>
									
									</ul>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</li>
</ul>
		</li>
		

		<li class="yamm-tfw menu-item menu-item-has-children animate-dropdown dropdown">
			<a title="Cameras, Audio &amp; Video" data-hover="dropdown" href="product-category.html" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">菜系国家</a>
			<ul role="menu" class=" dropdown-menu">
	<li class="menu-item animate-dropdown menu-item-object-static_block">
		<div class="yamm-content">
			<div class="row">
				<div class="col-sm-6">
					<div class="vc_column-inner ">
						<div class="wpb_wrapper">
							<div class="wpb_text_column wpb_content_element ">
								<div class="wpb_wrapper">
									<ul>
									<li class="nav-title">国别</li>
										<%
										for(int i=0;i<info.COUNTRYLIST1.length;i++){ %>
											<li><a href="#"><%=info.COUNTRYLIST1[i]%></a></li>
										<% }%>
										
										
									</ul>					

								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="vc_column-inner ">
						<div class="wpb_wrapper">
							<div class="wpb_text_column wpb_content_element ">
								<div class="wpb_wrapper">
									<ul>
										<li class="nav-title"></li>
										<%
										for(int i=0;i<info.COUNTRYLIST2.length;i++){ %>
											<li><a href="#"><%=info.COUNTRYLIST2[i]%></a></li>
										<% }%>
										
									</ul>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</li>
</ul>
		</li>

		<li class="yamm-tfw menu-item menu-item-has-children animate-dropdown dropdown">
			<a title="Mobiles &amp; Tablets" data-hover="dropdown" href="product-category.html" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">城市City</a>
			<ul role="menu" class=" dropdown-menu">
	<li class="menu-item animate-dropdown menu-item-object-static_block">
		<div class="yamm-content">
			<div class="row">
				<div class="col-sm-6">
					<div class="vc_column-inner ">
						<div class="wpb_wrapper">
							<div class="wpb_text_column wpb_content_element ">
								<div class="wpb_wrapper">
									<ul>
										<li class="nav-title">城市City</li>
										<%
										for(int i=0;i<info.CITYLIST1.length;i++){ %>
											<li><a href="#"><%=info.CITYLIST1[i]%></a></li>
										<% }%>
										
									</ul>

								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="vc_column-inner ">
						<div class="wpb_wrapper">
							<div class="wpb_text_column wpb_content_element ">
								<div class="wpb_wrapper">
									<ul>
										<li class="nav-title"></li>
										<%
										for(int i=0;i<info.CITYLIST2.length;i++){ %>
											<li><a href="#"><%=info.CITYLIST2[i]%></a></li>
										<% }%>
									</ul>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</li>
</ul>
		</li>


		<li id="menu-item-2695" class="menu-item menu-item-has-children animate-dropdown dropdown">
			<a title="Accessories" data-hover="dropdown" href="product-category.html" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">用餐氛围</a>
			<ul role="menu" class=" dropdown-menu">
				<%
				for(int i=0;i<info.AMBIENCE.length;i++){ %>
					<li class="menu-item animate-dropdown"><a title="Cases" href="shop.html"><%=info.AMBIENCE[i] %></a></li>
											
				<% }%>
				
			</ul>
		</li>

<li id="menu-item-2695" class="menu-item menu-item-has-children animate-dropdown dropdown">
			<a title="Accessories" data-hover="dropdown" href="product-category.html" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">时间/人数</a>
			<ul role="menu" class=" dropdown-menu">
			<%
				for(int i=0;i<info.PEOPLETIME.length;i++){ %>
					<li class="menu-item animate-dropdown"><a title="Cases" href="shop.html"><%=info.PEOPLETIME[i] %></a></li>
											
				<% }%>
			</ul>
		</li>
<li id="menu-item-2695" class="menu-item menu-item-has-children animate-dropdown dropdown">
			<a title="Accessories" data-hover="dropdown" href="product-category.html" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">其他</a>
			<ul role="menu" class=" dropdown-menu">
			<%
				for(int i=0;i<info.OTHERS.length;i++){ %>
					<li class="menu-item animate-dropdown"><a title="Cases" href="shop.html"><%=info.OTHERS[i] %></a></li>
											
				<% }%>
			</ul>
		</li>



			</ul>
		</li>
	</ul>
</nav>
	        </div>

	        <div class="col-xs-12 col-lg-9">
            	<nav>
	<ul id="menu-secondary-nav" class="secondary-nav">
		<li class="highlight menu-item"><a href="home-v2.html">所有美食</a></li>
		<li class="menu-item"><a href="home-v3.html">团购</a></li>
		<li class="menu-item"><a href="home-v3-full-color.html">最新点评</a></li>
		<li class="menu-item"><a href="blog-v1.html">美食博客</a></li>
		<li class="pull-right menu-item"><a href="blog-v2.html">赶快开始美食之旅吧~</a></li>
	</ul>
</nav>
            </div>
        </div>
    </div>
</header><!-- #masthead -->

            <div id="content" class="site-content" tabindex="-1">
    <div class="container">
        <div id="primary" class="content-area">
            <main id="main" class="site-main">
                <div class="home-v1-slider" >
	<!-- ========================================== SECTION – HERO : END========================================= -->

	<div id="owl-main" class="owl-carousel owl-inner-nav owl-ui-sm">

		<div class="item" style="background-image: url(assets/images/slider/banner-2.jpg);">
			<div class="container">
				<div class="row">
					<div class="col-md-offset-3 col-md-5">
						<div class="caption vertical-center text-left">
							<div class="hero-subtitle-v2 fadeInDown-1">
								树莓冰淇淋<br>水果
							</div>
							<div class="hero-2 fadeInDown-2">
								夏天就要来了
							</div>
							<div class="hero-v2-price fadeInDown-3">
								快来清凉一夏吧
							</div>
							<div class="hero-action-btn fadeInDown-4">
								<a href="single-product.html" class="big le-button ">搜索</a>
							</div>
						</div><!-- /.caption -->
					</div>
				</div>
			</div><!-- /.container -->
		</div><!-- /.item -->


		<div class="item" style="background-image: url(assets/images/slider/banner-1.jpg);">
			<div class="container">
				<div class="row">
					<div class="col-md-offset-3 col-md-5">
						<div class="caption vertical-center text-left">
							
							<div class="hero-subtitle-v2 fadeInDown-1">
							老北京铜火锅 VS 网红海底捞
							</div>
							<div class="hero-2 fadeInDown-2">
								你更喜欢哪一款？
							</div>
							<div class="hero-v2-price fadeInDown-3">
								热火夏天,火力全开
							</div>
							<div class="hero-action-btn fadeInDown-4">
								<a href="single-product.html" class="big le-button ">搜索</a>
							</div>
						</div><!-- /.caption -->
					</div>
				</div>
			</div><!-- /.container -->
		</div><!-- /.item -->

		<div class="item" style="background-image: url(assets/images/slider/banner-3.jpg);">
			<div class="container">
				<div class="row">
					<div class="col-md-offset-3 col-md-5">
						<div class="caption vertical-center text-left">
							
							<div class="hero-subtitle-v2 fadeInDown-1">
								牛排，羊排，五花肉
							</div>
							<div class="hero-2 fadeInDown-2">
								无肉不欢
							</div>
							<div class="hero-v2-price fadeInDown-3">
								全城最热烤肉
							</div>
							<div class="hero-action-btn fadeInDown-4">
								<a href="single-product.html" class="big le-button ">搜索</a>
							</div>
						</div><!-- /.caption -->
					</div>
				</div>
			</div><!-- /.container -->
		</div><!-- /.item -->


	</div><!-- /.owl-carousel -->

<!-- ========================================= SECTION – HERO : END ========================================= -->

</div><!-- /.home-v1-slider -->
                <div class="home-v1-ads-block animate-in-view fadeIn animated" data-animation="fadeIn">
	<div class="ads-block row">
		<div class="ad col-xs-12 col-sm-4">
			<div class="media">
				<div class="media-left media-middle">
					<img data-echo="assets/images/banner/1.jpg" src="assets/images/blank.gif" alt="">
				</div>
				<div class="media-body media-middle">
					<div class="ad-text">
						汤<br><strong>养生</strong>滋补<br>活血养肺
					</div>
					<div class="ad-action">
						<a href="#">查看更多</a>
					</div>
				</div>
			</div>
		</div>

		<div class="ad col-xs-12 col-sm-4">
			<div class="media">
				<div class="media-left media-middle">
					<img data-echo="assets/images/banner/2.jpg" src="assets/images/blank.gif" alt="">
				</div>
				<div class="media-body media-middle">
					<div class="ad-text">
						甜点<br> 优质美食<br> <strong>甜蜜午后</strong>
					</div>
					<div class="ad-action">
						<a href="#">查看更多</a>
					</div>
				</div>
			</div>
		</div>

		<div class="ad col-xs-12 col-sm-4">
			<div class="media">
				<div class="media-left media-middle">
					<img data-echo="assets/images/banner/3.jpg" src="assets/images/blank.gif" alt="">
				</div>
				<div class="media-body media-middle">
					<div class="ad-text">
						粥 <br><strong>潮汕砂锅</strong><br>味蕾满足
					</div>
					<div class="ad-action">
						<a href="#">查看更多</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

                <!-- ============================================================= 2-1-2 Product Grid ============================================================= -->


<!-- ============================================================= good place============================================================= -->                

<!-- ============================================================= end good place============================================================= -->                

            </main><!-- #main -->
        </div><!-- #primary -->

    </div><!-- .container -->
</div><!-- #content -->


<!-- ============================================================= guess you like============================================================= -->    
<!-- ============================================================= end guess you like============================================================= -->              
          
<!-- ============================================================= freely============================================================= -->    
<h2 class="sr-only">5分好店</h2>
<section class="brands-carousel">

	<div class="container">
		<div id="owl-brands" class="owl-brands owl-carousel unicase-owl-carousel owl-outer-nav">

			<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg1" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg2" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg3" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg4" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg5" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
									<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg6" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg7" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg8" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg9" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
									<div class="item">
				
				<a href="#">

					<figure>			
						 <img id="myimg10" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
			</div>
			
			</div>			
</section> 



<!-- ============================================================= end freely============================================================= -->              
 

            <footer id="colophon" class="site-footer">
	<div class="copyright-bar">
		<div class="container">
			<div class="pull-left flip copyright">&copy; <a href="jsp/about.jsp">大餐馆</a> - 版权所有</div>
			<div class="pull-right flip payment">
				<div class="footer-payment-logo">
			</div>
		</div><!-- /.container -->
	</div><!-- /.copyright-bar -->

	
</footer><!-- #colophon -->

        </div><!-- #page -->

        <!-- For demo purposes – can be removed on production : End -->

        <script type="text/javascript" src="assets/js/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/tether.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap-hover-dropdown.min.js"></script>
        <script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>
        <script type="text/javascript" src="assets/js/echo.min.js"></script>
        <script type="text/javascript" src="assets/js/wow.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.easing.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.waypoints.min.js"></script>
        <script type="text/javascript" src="assets/js/electro.js"></script>
		<script type="text/javascript" src="assets/js/jQuery.js"></script>
        <!-- For demo purposes – can be removed on production -->

        <script src="switchstylesheet/switchstylesheet/switchstylesheet.js"></script>

<script type="text/javascript">
$.ajax({  
	type:"post",
    url: "mainbottom.do",  
    contentType:"application/x-www-form-urlencoded",
    data: {},  
    dataType: "json",  
    success: function(result){    
    	result = eval(result);
    	
    	document.getElementById('myimg1').src="assets/images/res/"+result[0]+".jpg";
    	document.getElementById('myimg2').src="assets/images/res/"+result[1]+".jpg";
    	document.getElementById('myimg3').src="assets/images/res/"+result[2]+".jpg";
    	document.getElementById('myimg4').src="assets/images/res/"+result[3]+".jpg";
    	document.getElementById('myimg5').src="assets/images/res/"+result[4]+".jpg";
    	document.getElementById('myimg6').src="assets/images/res/"+result[5]+".jpg";
    	document.getElementById('myimg7').src="assets/images/res/"+result[6]+".jpg";
    	document.getElementById('myimg8').src="assets/images/res/"+result[7]+".jpg";
    	document.getElementById('myimg9').src="assets/images/res/"+result[8]+".jpg";
    	document.getElementById('myimg10').src="assets/images/res/"+result[9]+".jpg";
    } ,
    error:function(result){  
    	alert("out"); 
        alert(result[1]);    
    } 
});

  
function selectList(){
    $.ajax({
        url:'<%=request.getContextPath()%>/user/selectList.do',
        type:'post',
        async : false, //默认为true 异步
        dataType:'json',
        error:function(){
            alert('error');
        },
        success:function(data){
            alert(data)
        }
    });
}
</script>
    </body>
</html>
