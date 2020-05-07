
<%@ page language="java" contentType="text/html; charset=UTF-8"
import="com.food.util.*,com.food.model.*"
    pageEncoding="UTF-8"%>
    <%
    User user=null;
	//在页面上显示cookie
	if(request.getSession().getAttribute("loginUser")==null){
		String loginCookieUserName=null;
		String loginCookieId=null;
		String loginCookiePassword=null;
		String isTimeout=null;
		Cookie[] cookies=request.getCookies();
		if(null!=cookies){    
            for(Cookie cookie : cookies){     
                    if("loginUserName".equals(cookie.getName())){  
                        loginCookieUserName = cookie.getValue();  
                    }else if("loginId".equals(cookie.getName())){  
                        loginCookieId = cookie.getValue();  
                    }else if("loginPassword".equals(cookie.getName())){  
                        loginCookiePassword = cookie.getValue();  
                    }else if("isTimeout".equals(cookie.getName())){  
                    	isTimeout = cookie.getValue();  
                    }      
            }
            if(isTimeout!=null){
            	user=new User(loginCookieId,loginCookiePassword);
            	user.setName(loginCookieUserName);
                request.getSession().setAttribute("loginUser", user);
            }else{
            	 user=new User("","");
     			user.setName("请登陆");
            }
		}
	}else{
		user=(User)request.getSession().getAttribute("loginUser");
		pageContext.setAttribute("loginUser",user);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en-US" itemscope="itemscope" itemtype="http://schema.org/WebPage">
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>欢迎来到大餐馆</title>
         <link rel="stylesheet" type="text/css" href="assets/css/index.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/animate.min.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/font-electro.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/owl-carousel.css" media="all" />
        <link rel="stylesheet" type="text/css" href="assets/css/style.css" media="all" />

        <link rel="stylesheet" type="text/css" href="assets/css/colors/yellow.css" media="all" />

        <!-- Demo Purpose Only. Should be removed in production -->
        <link rel="stylesheet" href="assets/css/config.css">



        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,700italic,800,800italic,600italic,400italic,300italic' rel='stylesheet' type='text/css'>

        <link rel="shortcut icon" href="assets/images/fav-icon.png">
    </head>

    <body class="page home page-template-default">
        <div id="page" class="hfeed site">
            <div class="top-bar">
	<div class="container">
		<nav>
			<ul id="menu-top-bar-left" class="nav nav-inline pull-left animate-dropdown flip">
				<li class="menu-item animate-dropdown"><a title="Welcome to Worldwide Electronics Store" href="ToMain.do">欢迎来到大餐馆（BIG RESTAURANT）!</a></li>
			</ul>
		</nav>

		<nav>
		<form action="./user/save" method="post">  
			<ul id="menu-top-bar-right" class="nav nav-inline pull-right animate-dropdown flip">
				<li class="menu-item animate-dropdown"><a title="Store Locator" href="ToMain.do"><i class="ec ec-map-pointer"></i>北京</a></li>
				<!-- <li class="menu-item animate-dropdown"><a title="Track Your Order" href="track-your-order.html"><i class="ec ec-transport"></i>Track Your Order</a></li> -->
				<li class="menu-item animate-dropdown"><a title="登陆" href="ToLogin.do"><i class="ec ec-shopping-bag"></i><input type="text" style="border:0;width:120px;readonly = "readonly"  id="username" value="你好，<%=user.getName()%>" name="username"/></a></li>
				<li class="menu-item animate-dropdown"><a title="个人空间" href="myAccount.do"><i class="ec ec-user"></i>个人空间</a></li>
				<li class="menu-item animate-dropdown"><a title="退出" href="ToLogout.do"><i class="ec ec-user"></i>退出</a></li>
			
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

            <form class="navbar-search" method="post" action="search.do">
	<label class="sr-only screen-reader-text" for="search"></label>
	<div class="input-group">
		<input type="text" id="search" class="form-control search-field" dir="ltr" value="" name="search"  placeholder="在这里搜索美食" />
		<div id="message"></div>
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
	</br>
	 <div class="search_suggest" id="gov_search_suggest">  
                <ul>  
                </ul>  
            </div>
</form>
           



        <div class="row">
	        <div class="col-xs-12 col-lg-3">
	        	<nav>
	<ul class="list-group vertical-menu yamm make-absolute">
		<li class="list-group-item"><span><i class="fa fa-list-ul"></i> 美食类别</span></li>

		<li class="highlight menu-item animate-dropdown"><a title="Value of the Day" href="FirstHighScore.do">全城最高分</a></li>

		<li class="highlight menu-item animate-dropdown"><a title="Top 100 Offers" href="ReadHottest.do">全城最热门</a></li>

		<li class="highlight menu-item animate-dropdown"><a title="New Arrivals" href="RecommendBaseOnUser.do">猜你喜欢(用户)</a></li>
		<li class="highlight menu-item animate-dropdown"><a title="New Arrivals" href="RecommendBaseOnUBussiness.do">猜你喜欢(商铺)</a></li>

		<li class="yamm-tfw menu-item menu-item-has-children animate-dropdown dropdown">
			<a title="Computers &amp; Accessories" data-hover="dropdown" href="#" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">菜系</a>
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
											<li><a href="ChooseCategory.do?chooseCategory=<%=info.FOODLIST1[i]%>"><%=info.FOODLIST1[i]%></a></li>
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
											<li><a href="ChooseCategory.do?chooseCategory=<%=info.FOODLIST2[i]%>"><%=info.FOODLIST2[i]%></a></li>
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
			<a title="Cameras, Audio &amp; Video" data-hover="dropdown" href="#" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">菜系国家</a>
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
											<li><a href="Country.do?m_country=<%=info.COUNTRYLIST1[i]%>"><%=info.COUNTRYLIST1[i]%></a></li>
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
											<li><a href="Country.do?m_country=<%=info.COUNTRYLIST2[i]%>"><%=info.COUNTRYLIST2[i]%></a></li>
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
			<a title="Mobiles &amp; Tablets" data-hover="dropdown" href="#" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">城市City</a>
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
											<li><a href="City.do?m_city=<%=info.CITYLIST1[i]%>"><%=info.CITYLIST1[i]%></a></li>
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
											<li><a href="City.do?m_city=<%=info.CITYLIST2[i]%>"><%=info.CITYLIST2[i]%></a></li>
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
			<a title="Accessories" data-hover="dropdown" href="#" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">用餐氛围</a>
			<ul role="menu" class=" dropdown-menu">
				<%
				for(int i=0;i<info.AMBIENCE.length;i++){ 
				
				%>
					<li class="menu-item animate-dropdown"><a title="Cases" href="ChooseEnvironment.do?chooseCategory=<%=info.AMBIENCE[i] %>"><%=info.AMBIENCE[i] %></a></li>
											
				<% }%>
				
			</ul>
		</li>

<li id="menu-item-2695" class="menu-item menu-item-has-children animate-dropdown dropdown">
			<a title="Accessories" data-hover="dropdown" href="#" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">时间/人数</a>
			<ul role="menu" class=" dropdown-menu">
			<%
				for(int i=0;i<info.PEOPLETIME.length;i++){ %>
					<li class="menu-item animate-dropdown"><a title="Cases" href="ChooseEnvironment.do?chooseCategory=<%=info.PEOPLETIME[i] %>"><%=info.PEOPLETIME[i] %></a></li>
											
				<% }%>
			</ul>
		</li>
<li id="menu-item-2695" class="menu-item menu-item-has-children animate-dropdown dropdown">
			<a title="Accessories" data-hover="dropdown" href="#" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">其他</a>
			<ul role="menu" class=" dropdown-menu">
			<%
				for(int i=0;i<info.OTHERS.length;i++){ %>
					<li class="menu-item animate-dropdown"><a title="Cases" href="ChooseEnvironment.do?chooseCategory=<%=info.OTHERS[i] %>"><%=info.OTHERS[i] %></a></li>
											
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
		<li class="highlight menu-item"><a href="FirstHighScore.do">所有美食</a></li>
		<li class="menu-item"><a href="FirstHighScore.do">最新点评</a></li>
		<li class="menu-item"><a href="FirstHighScore.do">美食博客</a></li>
		<li class="pull-right menu-item"><a href="FirstHighScore.do">赶快开始美食之旅吧~</a></li>
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
								<a href="ChooseCategory.do?chooseCategory=Ice Cream" class="big le-button ">搜索</a>
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
								<a href="ChooseCategory.do?chooseCategory=Hot Pot" class="big le-button ">搜索</a>
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
								<a href="ChooseCategory.do?chooseCategory=Kebab" class="big le-button ">搜索</a>
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
					<img  src="assets/images/banner/1.jpg" alt="">
				</div>
				<div class="media-body media-middle">
					<div class="ad-text">
						汤<br><strong>养生</strong>滋补<br>活血养肺
					</div>
					<div class="ad-action">
						<a href="ChooseCategory.do?chooseCategory=Soup">查看更多</a>
					</div>
				</div>
			</div>
		</div>

		<div class="ad col-xs-12 col-sm-4">
			<div class="media">
				<div class="media-left media-middle">
					<img  src="assets/images/banner/2.jpg" alt="">
				</div>
				<div class="media-body media-middle">
					<div class="ad-text">
						甜点<br> 优质美食<br> <strong>甜蜜午后</strong>
					</div>
					<div class="ad-action">
						<a href="ChooseCategory.do?chooseCategory=Desserts">查看更多</a>
					</div>
				</div>
			</div>
		</div>

		<div class="ad col-xs-12 col-sm-4">
			<div class="media">
				<div class="media-left media-middle">
					<img  src="assets/images/banner/3.jpg" alt="">
				</div>
				<div class="media-body media-middle">
					<div class="ad-text">
						粥 <br><strong>潮汕砂锅</strong><br>味蕾满足
					</div>
					<div class="ad-action">
						<a href="ChooseCategory.do?chooseCategory=Soup">查看更多</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

                <!-- ============================================================= 2-1-2 Product Grid ============================================================= -->


<!-- ============================================================= good place============================================================= -->                
<section class="section-product-cards-carousel animate-in-view fadeIn animated" data-animation="fadeIn">

	<header>

		<h2 class="h1">热评好店</h2>

		</header>

	<div id="home-v1-product-cards-careousel">
		<div class="woocommerce columns-3 home-v1-product-cards-carousel product-cards-carousel owl-carousel">

				<ul class="products columns-3">
														<li class="product product-card first">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=xfwRO04KbAPw_zRotCfWQQ&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive"style="width:100%;height:180px" src="assets/images/res/-gG-FFU7hRsEembOpILANg.jpg" alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=xfwRO04KbAPw_zRotCfWQQ&TAG=Hot" rel="tag" id="number1">点评数：2857</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=xfwRO04KbAPw_zRotCfWQQ&TAG=Hot">
					<h3>店铺名：Hash House A Go Go</h3>
				</a>

				<div class="price-add-to-cart">
				<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:80%"><strong class="rating">5</strong> out of 5</span></div>
				
				</div><!-- /.price-add-to-cart -->

			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card ">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=1yx2zLskVTe5WQdYjL2Apw&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive"style="width:100%;height:180px" src="assets/images/res/1bOVCGPMFIyIZ911xCZ-5Q.jpg" alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=1yx2zLskVTe5WQdYjL2Apw&TAG=Hot" rel="tag">点评数：2089</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=1yx2zLskVTe5WQdYjL2Apw&TAG=Hot">
					<h3>店铺名：Egg & I</h3>
				</a>

				<div class="price-add-to-cart">
				<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:90%"><strong class="rating">5</strong> out of 5</span></div>
				
				</div><!-- /.price-add-to-cart -->

				
			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card last">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=vxxMqBaAHuWdx4impsLSSA&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive"style="width:100%;height:180px" src="assets/images/res/-38DQS30MHtGhtELctshhw.jpg" alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=vxxMqBaAHuWdx4impsLSSA&TAG=Hot" rel="tag">点评数：1746</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=vxxMqBaAHuWdx4impsLSSA&TAG=Hot">
					<h3>店铺名：Studio B Show Kitchen Buffet</h3>
				</a>

				<div class="price-add-to-cart">	
					<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:80%"><strong class="rating">5</strong> out of 5</span></div>
			
				</div><!-- /.price-add-to-cart -->


			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card first">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=QnAzW6KMSciUcuJ20oI3Bw&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive"style="width:100%;height:180px" src="assets/images/res/-cnxyn_QxjugHDmMq5bisg.jpg"  alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=QnAzW6KMSciUcuJ20oI3Bw&TAG=Hot" rel="tag">点评数：1368</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=QnAzW6KMSciUcuJ20oI3Bw&TAG=Hot">
					<h3>店铺名：Joe\'s Farm Grill
</h3>
				</a>

				<div class="price-add-to-cart">
					
				<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:80%"><strong class="rating">5</strong> out of 5</span></div>
			
		
				</div><!-- /.price-add-to-cart -->


			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card ">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=MuIXnv7Oq7X3-4aEsp9dDA&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive" style="width:100%;height:180px" src="assets/images/res/0LexaqzfV4fvlVQ_Lpro5Q.jpg"  alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=MuIXnv7Oq7X3-4aEsp9dDA&TAG=Hot" rel="tag">点评数：1324</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=MuIXnv7Oq7X3-4aEsp9dDA&TAG=Hot">
					<h3>店铺名：Citizen Public House</h3>
				</a>

				<div class="price-add-to-cart">
				<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:90%"><strong class="rating">5</strong> out of 5</span></div>
			
				</div><!-- /.price-add-to-cart -->



			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card last">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=YacTpiq0ZptFcXD7I-kdGA&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive" style="width:100%;height:180px"src="assets/images/res/-RJuQG1NTg-Ek7MqTQPiOg.jpg" alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=YacTpiq0ZptFcXD7I-kdGA&TAG=Hot" rel="tag">点评数：1279</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=YacTpiq0ZptFcXD7I-kdGA&TAG=Hot">
					<h3>店铺名：Delmonico Steakhouse
</h3>
				</a>

				<div class="price-add-to-cart">
				<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:80%"><strong class="rating">5</strong> out of 5</span></div>
			
				</div><!-- /.price-add-to-cart -->

				

			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
							</ul>
					<ul class="products columns-3">
														<li class="product product-card first">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=iXA8Y2bzvZo8MjALfZxrIg&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive" style="width:100%;height:180px"src="assets/images/res/1J0ZbM-46TaAdRISM3gWOA.jpg" alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=iXA8Y2bzvZo8MjALfZxrIg&TAG=Hot" rel="tag">点评数：1127</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=iXA8Y2bzvZo8MjALfZxrIg&TAG=Hot">
					<h3>店铺名：Margaritaville</h3>
				</a>

				<div class="price-add-to-cart">
				<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:70%"><strong class="rating">5</strong> out of 5</span></div>
				

				</div><!-- /.price-add-to-cart -->

				

			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card ">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=Z0kyK8wCBNGkkUT9UrMWcg&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive" style="width:100%;height:180px"src="assets/images/res/-dakRiHsHRtDzp4MX7mviQ.jpg"  alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=Z0kyK8wCBNGkkUT9UrMWcg&TAG=Hot" rel="tag">点评数：1098</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=Z0kyK8wCBNGkkUT9UrMWcg&TAG=Hot">
					<h3>店铺名：Del Frisco\'s Double Eagle Steak House
</h3>
				</a>

				<div class="price-add-to-cart">
				<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:90%"><strong class="rating">5</strong> out of 5</span></div>
			
				</div><!-- /.price-add-to-cart -->

				

			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card last">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=sih8j621A66QoiUFues5qQ&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive"style="width:100%;height:180px" src="assets/images/res/-fmxvoKvdglsE3bXgq4lig.jpg"  alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=sih8j621A66QoiUFues5qQ&TAG=Hot" rel="tag">点评数：1093</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=sih8j621A66QoiUFues5qQ&TAG=Hot">
					<h3>店铺名：Carson Kitchen
</h3>
				</a>

				<div class="price-add-to-cart">
					<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:90%"><strong class="rating">5</strong> out of 5</span></div>
			
				</div><!-- /.price-add-to-cart -->

				
			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card first">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=IyCwqORkMSmK4mAgAFHgnA&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive"style="width:100%;height:180px" src="assets/images/res/-StWq6VT-sPZUCMZ2QIbFQ.jpg"  alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=IyCwqORkMSmK4mAgAFHgnA&TAG=Hot" rel="tag">点评数：1033</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=IyCwqORkMSmK4mAgAFHgnA&TAG=Hot">
					<h3>店铺名：Firefly
</h3>
				</a>

				<div class="price-add-to-cart">
					<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:90%"><strong class="rating">5</strong> out of 5</span></div>
			
				</div><!-- /.price-add-to-cart -->

				

			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card ">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=1NZLxU5WvB5roPFzneAlLw&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive" style="width:100%;height:180px"src="assets/images/res/2I1zlS0GDlYe6L14c_Z6rA.jpg" alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=1NZLxU5WvB5roPFzneAlLw&TAG=Hot" rel="tag">点评数：963</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=1NZLxU5WvB5roPFzneAlLw&TAG=Hot">
					<h3>店铺名：Barrio Caf茅
</h3>
				</a>

				<div class="price-add-to-cart">
					<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:80%"><strong class="rating">5</strong> out of 5</span></div>
			
				</div><!-- /.price-add-to-cart -->

				

			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
														<li class="product product-card last">

    <div class="product-outer">
		<div class="media product-inner">

			<a class="media-left" href="SingleBusinessDetail.do?m_businessId=t6SuvEq9PPVGzNv5bJzDtw&TAG=Hot" title="Pendrive USB 3.0 Flash 64 GB">
				<img class="media-object wp-post-image img-responsive" style="width:100%;height:180px"src="assets/images/res/-iml85rXdvpsDbWRMgs3zg.jpg"  alt="">

			</a>

			<div class="media-body">
				<span class="loop-product-categories">
					<a href="SingleBusinessDetail.do?m_businessId=t6SuvEq9PPVGzNv5bJzDtw&TAG=Hot" rel="tag">点评数：946</a>
				</span>

				<a href="SingleBusinessDetail.do?m_businessId=t6SuvEq9PPVGzNv5bJzDtw&TAG=Hot">
					<h3>店铺名：Bachi Burger
</h3>
				</a>

				<div class="price-add-to-cart">
					<div class="star-rating" title="Rated 5 out of 5"><span if="spanStar1"style="width:80%"><strong class="rating">5</strong> out of 5</span></div>
			
				</div><!-- /.price-add-to-cart -->


			</div>
		</div><!-- /.product-inner -->
	</div><!-- /.product-outer -->

					</li><!-- /.products -->
							</ul>
				</div>
	</div><!-- #home-v1-product-cards-careousel -->

</section>
<!-- ============================================================= end good place============================================================= -->                
<!-- ============================================================= guess you like============================================================= -->    
<section class="home-v1-recently-viewed-products-carousel section-products-carousel animate-in-view fadeIn animated" data-animation="fadeIn">

	<header>
		<h2 class="h1">猜你喜欢</h2>
		<div class="owl-nav">
			<a href="RecommendBaseOnUBussiness.do" rel="tag">查看更多</a>
		</div>
	</header>

			<div class="products owl-carousel recently-added-products products-carousel columns-6">
	
   <table id="test">

		</table>
		</div>
				</div>
		</div>
	</div>
</section>

<!-- ============================================================= end guess you like============================================================= -->              
         
<!-- ============================================================= freely============================================================= -->    

<section class="brands-carousel">
	
	<div class="container">
	<header>

		<h3 class="h3"style="padding-left:40px">5分好店</h3>

		</header>
		<div id="owl-brands" class="owl-brands owl-carousel unicase-owl-carousel owl-outer-nav">

			<div class="item">
				
				<a href="#"id="aLink1">

					<figure>			
						 <img id="myimg1" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#"id="aLink2">

					<figure>			
						 <img id="myimg2" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#"id="aLink3">

					<figure>			
						 <img id="myimg3" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#"id="aLink4">

					<figure>			
						 <img id="myimg4" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#"id="aLink5">

					<figure>			
						 <img id="myimg5" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
									<div class="item">
				
				<a href="#"id="aLink6">

					<figure>			
						 <img id="myimg6" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#"id="aLink7">

					<figure>			
						 <img id="myimg7" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#"id="aLink8">

					<figure>			
						 <img id="myimg8" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
						<div class="item">
				
				<a href="#"id="aLink9">

					<figure>			
						 <img id="myimg9" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
				<div class="item">
				
				<a href="#"id="aLink10">

					<figure>			
						 <img id="myimg10" src="assets/images/res/_2Sxy4s9KQm5XWoqZlmAQw.jpg" class="img-responsive" alt="图片加载失败">

					</figure>
						
				</a>	
							
			</div><!-- /.item -->
			</div>
			
			</div>			
</section> 
<!-- ============================================================= end freely============================================================= -->              
 
            </main><!-- #main -->
        </div><!-- #primary -->

    </div><!-- .container -->
</div><!-- #content -->







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
    	
    	document.getElementById('aLink1').href="SingleBusinessDetail.do?m_businessId="+result[0].business_id+"&TAG="+"HighScore";
    	document.getElementById('aLink2').href="SingleBusinessDetail.do?m_businessId="+result[1].business_id+"&TAG="+"HighScore";
    	document.getElementById('aLink3').href="SingleBusinessDetail.do?m_businessId="+result[2].business_id+"&TAG="+"HighScore";
    	document.getElementById('aLink4').href="SingleBusinessDetail.do?m_businessId="+result[3].business_id+"&TAG="+"HighScore";
    	document.getElementById('aLink5').href="SingleBusinessDetail.do?m_businessId="+result[4].business_id+"&TAG="+"HighScore";
    	document.getElementById('aLink6').href="SingleBusinessDetail.do?m_businessId="+result[5].business_id+"&TAG="+"HighScore";
    	document.getElementById('aLink7').href="SingleBusinessDetail.do?m_businessId="+result[6].business_id+"&TAG="+"HighScore";
    	document.getElementById('aLink8').href="SingleBusinessDetail.do?m_businessId="+result[7].business_id+"&TAG="+"HighScore";
    	document.getElementById('aLink9').href="SingleBusinessDetail.do?m_businessId="+result[8].business_id+"&TAG="+"HighScore";
    	document.getElementById('aLink10').href="SingleBusinessDetail.do?m_businessId="+result[9].business_id+"&TAG="+"HighScore";
    	
    	document.getElementById('myimg1').src="assets/images/res/"+result[0].photo_id+".jpg";
    	document.getElementById('myimg2').src="assets/images/res/"+result[1].photo_id+".jpg";
    	document.getElementById('myimg3').src="assets/images/res/"+result[2].photo_id+".jpg";
    	document.getElementById('myimg4').src="assets/images/res/"+result[3].photo_id+".jpg";
    	document.getElementById('myimg5').src="assets/images/res/"+result[4].photo_id+".jpg";
    	document.getElementById('myimg6').src="assets/images/res/"+result[5].photo_id+".jpg";
    	document.getElementById('myimg7').src="assets/images/res/"+result[6].photo_id+".jpg";
    	document.getElementById('myimg8').src="assets/images/res/"+result[7].photo_id+".jpg";
    	document.getElementById('myimg9').src="assets/images/res/"+result[8].photo_id+".jpg";
    	document.getElementById('myimg10').src="assets/images/res/"+result[9].photo_id+".jpg";
    } ,
    error:function(result){  
    	  
    } 
});
$.ajax({  
	type:"post",
	url: "mainRecommend.do",  
    contentType:"application/x-www-form-urlencoded",
    data: {},  
    dataType: "json",  
    success: function(result){    
    	result = eval(result);
    	
    	var str1="";
        str1 = "<tr>";
        for(var i=0;i<6;i++){
        	str1+="<td><div class=\"product\">"+
        	"<div class=\"product-outer\">"+
        	    "<span class=\"loop-product-categories\"><a href=\"SingleBusinessDetail.do?m_businessId="+result[i].business_id+
        		"&TAG=\"hot\" rel=\"tag\">点评数："+result[i].review_count+"</a></span>"+
        	    "<a href=\"SingleBusinessDetail.do?m_businessId="+result[i].business_id+"&TAG=\"hot\">"+
        	        "<h3>"+result[i].name+"</h3>"+
        	        "<div class=\"product-thumbnail\">"+
        	       "<img src=\""+result[i].image_id+"\"style=\"width:290px;height:155px\">"+
        	        "</div></a><div class=\"price-add-to-cart\">"+
        	        "<div class=\"star-rating\" title=\"Rated 5 out of 5\"><span if=\"spanStar1\"style=\"width:"+result[i].stars+"\"><strong class=\"rating\">5</strong> out of 5</span></div>"+
        	        "<a href=\"#\" rel=\"nofollow\" class=\"add_to_wishlist\"> like</a>"+
        	    "</div><!-- /.price-add-to-cart --></div></div><!-- /.products --></td>";
        }

        str1 += "</tr>";
        $("#test").append(str1);
    } ,
    error:function(result){  
     
    } 
});



</script>
<script type="text/javascript">  
//实现搜索输入框的输入提示js类  
function oSearchSuggest(searchFuc){  
    var input = $('#search');  
    var suggestWrap = $('#gov_search_suggest');  
    var key = "";  
    var init = function(){  
        input.bind('keyup',sendKeyWord);  
        input.bind('blur',function(){setTimeout(hideSuggest,100);})  
    }  
    var hideSuggest = function(){  
        suggestWrap.hide();  
    }  
      
    //发送请求，根据关键字到后台查询  
    var sendKeyWord = function(event){  
          
        //键盘选择下拉项  
        if(suggestWrap.css('display')=='block'&&event.keyCode == 38||event.keyCode == 40){  
            var current = suggestWrap.find('li.hover');  
            if(event.keyCode == 38){  
                if(current.length>0){  
                    var prevLi = current.removeClass('hover').prev();  
                    if(prevLi.length>0){  
                        prevLi.addClass('hover');  
                        input.val(prevLi.html());  
                    }  
                }else{  
                    var last = suggestWrap.find('li:last');  
                    last.addClass('hover');  
                    input.val(last.html());  
                }  
                  
            }else if(event.keyCode == 40){  
                if(current.length>0){  
                    var nextLi = current.removeClass('hover').next();  
                    if(nextLi.length>0){  
                        nextLi.addClass('hover');  
                        input.val(nextLi.html());  
                    }  
                }else{  
                    var first = suggestWrap.find('li:first');  
                    first.addClass('hover');  
                    input.val(first.html());  
                }  
            }  
              
        //输入字符  
        }else{   
            var valText = $.trim(input.val());  
            if(valText ==''||valText==key){  
                return;  
            }  
            searchFuc(valText);  
            key = valText;  
        }             
          
    }  
    //请求返回后，执行数据展示  
    this.dataDisplay = function(data){  
        if(data.length<=0){  
            suggestWrap.hide();  
            return;  
        }  
          
        //往搜索框下拉建议显示栏中添加条目并显示  
        var li;  
        var tmpFrag = document.createDocumentFragment();  
        suggestWrap.find('ul').html('');  
        for(var i=0; i<data.length; i++){  
            li = document.createElement('LI');  
            li.innerHTML = data[i];  
            tmpFrag.appendChild(li);  
        }  
        suggestWrap.find('ul').append(tmpFrag);  
        suggestWrap.show();  
          
        //为下拉选项绑定鼠标事件  
        suggestWrap.find('li').hover(function(){  
                suggestWrap.find('li').removeClass('hover');  
                $(this).addClass('hover');  
          
            },function(){  
                $(this).removeClass('hover');  
        }).bind('click',function(){  
            input.val(this.innerHTML);  
            suggestWrap.hide();  
        });  
    }  
    init();  
};  
  
//实例化输入提示的JS,参数为进行查询操作时要调用的函数名  
var searchSuggest =  new oSearchSuggest(sendKeyWordToBack);  
//参数为一个字符串，是搜索输入框中当前的内容  
function sendKeyWordToBack(keyword){  
             $.ajax({  
                       type: "POST",  
                       url: "autoComplemSearch.do",  
                       contentType:"application/x-www-form-urlencoded",
                       data: {"keyword":keyword},  
                       dataType: "json",
                       success: function(businessName){  
                          businessName = eval(businessName);  
                        // alert(businessName.length);
                        // var key=data.split(",");  
                         var aData = [];  
                         var length = (businessName.length>10)?10:businessName.length;
                         for(var i=0;i<length;i++){  
                                //以下为根据输入返回搜索结果的模拟效果代码,实际数据由后台返回  
                            if(businessName[i]!=""){  
                                 aData.push(businessName[i]);  
                            }  
                         }  
                        //将返回的数据传递给实现搜索输入框的输入提示js类  
                         searchSuggest.dataDisplay(aData);  
                       }  
         });   
               
               
      
}  
  
</script>  
    </body>
</html>
