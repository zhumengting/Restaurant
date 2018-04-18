<%@ page language="java" contentType="text/html; charset=UTF-8"
import="com.food.util.*"
    pageEncoding="UTF-8"%>
    <%@ page language="java" import="com.food.model.User" %>
<%
	//在页面上显示cookie
	if(request.getAttribute("user")==null){
		String username=null;
		String password=null;
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies!=null&& i<cookies.length;i++){
			if(cookies[i].getName().equals("user")){
				username=cookies[i].getValue().split("-")[0];
				password=cookies[i].getValue().split("-")[1];
			}
		}
		if(username==null){
			username="";
		}
		if(password==null){
			password="";
		}
		pageContext.setAttribute("user", new User(username,password));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>

       <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>欢迎来到大餐馆~</title>

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
			<ul id="menu-top-bar-right" class="nav nav-inline pull-right animate-dropdown flip">
                <li class="menu-item animate-dropdown"><a title="Store Locator" href="#"><i class="ec ec-map-pointer"></i>北京</a></li>
                <!-- <li class="menu-item animate-dropdown"><a title="Track Your Order" href="track-your-order.html"><i class="ec ec-transport"></i>Track Your Order</a></li> -->
                <li class="menu-item animate-dropdown"><a title="登陆" href="shop.html"><i class="ec ec-shopping-bag"></i>登陆</a></li>
                <li class="menu-item animate-dropdown"><a title="个人空间" href="my-account.html"><i class="ec ec-user"></i>个人空间</a></li>
            </ul>
		</nav>
	</div>
</div><!-- /.top-bar -->

            <header id="masthead" class="site-header header-v2">
    <div class="container">
        <div class="row">

            <!-- ============================================================= Header Logo ============================================================= -->
<div class="header-logo">
	<img src="assets/images/slider/logo.png" height="130" width="130" />
</div>
<!-- ============================================================= Header Logo : End============================================================= -->

<!-- ============================================================= Header Logo : End============================================================= -->

           <div class="header-support-info">
	<div class="media">
		<span class="media-left support-icon media-middle"><i class="ec ec-support"></i></span>
		<div class="media-body">
			<span class="support-number"><strong>Support</strong> (+800) 856 800 604</span><br/>
			<span class="support-email">Email: info@electro.com</span>
		</div>
	</div>
</div>

        </div><!-- /.row -->
    </div>
</header><!-- #masthead -->
<nav class="navbar navbar-primary navbar-full">
    <div class="container">
            <ul class="nav navbar-nav departments-menu animate-dropdown">
    <li class="nav-item dropdown ">

        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="departments-menu-toggle" >美食分类</a>
        <ul id="menu-vertical-menu" class="dropdown-menu yamm departments-menu-dropdown">
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
										GlobalInfo info=new GlobalInfo();
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
            <a title="Cameras, Audio &amp; Video" data-hover="dropdown" href="product-category.html" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">地标</a>
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
            <a title="Mobiles &amp; Tablets" data-hover="dropdown" href="product-category.html" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">区域</a>
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
            <a title="Accessories" data-hover="dropdown" href="product-category.html" data-toggle="dropdown" class="dropdown-toggle" aria-haspopup="true">用餐人数</a>
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
    </li>
</ul>
        <form class="navbar-search" method="get" action="/">
	<label class="sr-only screen-reader-text" for="search">Search for:</label>
	<div class="input-group">
		<input type="text" id="search" class="form-control search-field" dir="ltr" value="" name="s" placeholder="在这里搜索美食" />
		<div class="input-group-addon search-categories">
			<select name='product_cat' id='product_cat' class='postform resizeselect' >
				<option value='0' selected='selected'>全部美食</option>
                <%
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
</div>
</nav>









            <div id="content" class="site-content" tabindex="-1">
	<div class="container">

		<nav class="woocommerce-breadcrumb" >
			<a href="index.html">Home</a>
			<span class="delimiter"><i class="fa fa-angle-right"></i></span>
			Login
		</nav><!-- .woocommerce-breadcrumb -->

		<div id="primary" class="content-area">
			<main id="main" class="site-main">
				<article id="post-8" class="hentry">

					<div class="entry-content">
						<div class="woocommerce">
							<div class="customer-login-form">
								<span class="or-text">or</span>

								<div class="col2-set" id="customer_login">

									<div class="col-1">


										<h2>Login</h2>

										<form method="post" class="login" action="login.do" method="post" onsubmit="return checkForm()">

											<p class="before-login-text">
												Welcome back! Sign in to your account
											</p>

											<p class="form-row form-row-wide">
												<label for="username">Username 
												<span class="required">*</span></label>
												<input type="text" class="input-text" name="username" id="username" value="" />
											</p>

											<p class="form-row form-row-wide">
												<label for="password">Password
												<span class="required">*</span></label>
												<input class="input-text" type="password" name="password" id="password" />
											</p>


											<p class="form-row">
												<input class="button" type="submit" value="Login" name="login">
												<label for="rememberme" class="inline">
													<input name="rememberme" type="checkbox" id="rememberme" value="forever" /> Remember me
												</label>
											</p>

											<p class="lost_password">
												<a href="login-and-register.html">Lost your password?</a>
											</p>

										</form>


									</div><!-- .col-1 -->

									<div class="col-2">

										<h2>Register</h2>

										<form method="post" class="register">

											<p class="before-register-text">
												Create your very own account
											</p>


											<p class="form-row form-row-wide">
												<label for="reg_email">Email address
												<span class="required">*</span></label>
												<input type="email" class="input-text" name="email" id="reg_email" value="" />
											</p>


											<p class="form-row">
												<input type="submit" class="button" name="register" value="Register" />
											</p>

											<div class="register-benefits">
												<h3>Sign up today and you will be able to :</h3>
												<ul>
													<li>Make comments</li>
													<li>Find your favourite foods</li>
													<li>Keep a record of all your searching</li>
												</ul>
											</div>

										</form>

									</div><!-- .col-2 -->

								</div><!-- .col2-set -->

							</div><!-- /.customer-login-form -->
						</div><!-- .woocommerce -->
					</div><!-- .entry-content -->

				</article><!-- #post-## -->

			</main><!-- #main -->
		</div><!-- #primary -->


	</div><!-- .col-full -->
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

	</div>
</footer><!-- #colophon -->

        </div><!-- #page -->


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

        <!-- For demo purposes – can be removed on production -->

        <script src="switchstylesheet/switchstylesheet/switchstylesheet.js"></script>
<script type="text/javascript">
	function checkForm(){
		var userName=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		if(userName==null||userName==""){
			alert("用户名不能为空!");
			return false;
		}
		if(password==null||password==""){
			alert("密码不能为空!");
			return false;
		}
		return true;
	}
</script>
    </body>
</html>