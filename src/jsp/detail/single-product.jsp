<%@ page language="java" contentType="text/html; charset=UTF-8"
import="com.food.util.*,java.util.*,com.food.view.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US" itemscope="itemscope" itemtype="http://schema.org/WebPage">
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Electro &#8211; Electronics Ecommerce Theme</title>

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

    <body class="single-product full-width">
        <div id="page" class="hfeed site">
            <a class="skip-link screen-reader-text" href="#site-navigation">Skip to navigation</a>
            <a class="skip-link screen-reader-text" href="#content">Skip to content</a>

            <div class="top-bar">
	<div class="container">
		<nav>
			<ul id="menu-top-bar-left" class="nav nav-inline pull-left animate-dropdown flip">
				<li class="menu-item animate-dropdown"><a title="Welcome to Worldwide Electronics Store" href="#">Welcome to Worldwide Electronics Store</a></li>
			</ul>
		</nav>

		<nav>
			<ul id="menu-top-bar-right" class="nav nav-inline pull-right animate-dropdown flip">
				<li class="menu-item animate-dropdown"><a title="Store Locator" href="#"><i class="ec ec-map-pointer"></i>Store Locator</a></li>
				<li class="menu-item animate-dropdown"><a title="Track Your Order" href="track-your-order.html"><i class="ec ec-transport"></i>Track Your Order</a></li>
				<li class="menu-item animate-dropdown"><a title="Shop" href="shop.html"><i class="ec ec-shopping-bag"></i>Shop</a></li>
				<li class="menu-item animate-dropdown"><a title="My Account" href="my-account.html"><i class="ec ec-user"></i>My Account</a></li>
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
<% 
	BItem bItem=(BItem)request.getAttribute("BusinessItem");
    %>
		<nav class="woocommerce-breadcrumb">
			<a href="index.html">Home</a>
			<span class="delimiter"><i class="fa fa-angle-right"></i>
			</span><%=bItem.getName()%>
		</nav><!-- /.woocommerce-breadcrumb -->

		<div id="primary" class="content-area">
			<main id="main" class="site-main">

				<div class="product">
					<div class="single-product-wrapper">
						<div class="product-images-wrapper">
							<span class="onsale">hot!</span>
							 <div class="images electro-gallery">
	<div class="thumbnails-single owl-carousel">
		<a href="images/single-product/s1-1.jpg" class="zoom" title="" data-rel="prettyPhoto[product-gallery]">
			<img src="assets/images/blank.gif" data-echo="<%=bItem.getImage_id()%>" style="width:100%;height:400px" alt="">
		</a>
	</div><!-- .thumbnails-single -->

	
</div><!-- .electro-gallery -->								</div><!-- /.product-images-wrapper -->

						<div class="summary entry-summary">

	<span class="loop-product-categories">
		<a href="product-category.html" rel="tag">Headphones</a>
	</span><!-- /.loop-product-categories -->

	<h1 itemprop="name" class="product_title entry-title"><%=bItem.getName()%></h1>

	<div class="woocommerce-product-rating">
		<div class="star-rating" title="Rated 4.33 out of 5">
			<span style="width:<%=bItem.getStars()%>">
				<strong itemprop="ratingValue" class="rating">4.33</strong>
				out of <span itemprop="bestRating">5</span>				based on
				<span itemprop="ratingCount" class="rating">3</span>
				customer ratings
			</span>
		</div>

		<a href="#reviews" class="woocommerce-review-link">
			(<span itemprop="reviewCount" class="count"><%=bItem.getReview_count()%></span> customer reviews)
		</a>
	</div><!-- .woocommerce-product-rating -->

	<div class="brand">
		<a href="product-category.html">
			<img src="assets/images/single-product/brand.png" alt="Gionee" />
		</a>
	</div><!-- .brand -->

	<div class="availability in-stock">
		Availablity: <span><%=bItem.isOpen()%></span>
	</div><!-- .availability -->

	<hr class="single-product-title-divider" />

	<div class="action-buttons">

		<a href="#" class="add_to_wishlist" >
		        Wishlist
		</a>


		<a href="#" class="add-to-compare-link" data-product_id="2452">Compare</a>
	</div><!-- .action-buttons -->

	<div itemprop="description">
		<ul>
			<li><%=bItem.getNeighborhoods()%></li>
			<li><%=bItem.getCategories()%></li>
			<li><%=bItem.getFull_address()%></li>
		</ul>
		<p><strong>OPEN HOUR</strong>: <%=bItem.getHours()%></p>
	</div><!-- .description -->


	<form class="variations_form cart" method="post">


	<div class="single_variation_wrap">
		<div class="woocommerce-variation single_variation"></div>
		<div class="woocommerce-variation-add-to-cart variations_button">
			<button type="submit" class="single_add_to_cart_button button">LIKE</button>
		</div>
	</div>
</form>


</div><!-- .summary -->
					</div><!-- /.single-product-wrapper -->


					<div class="woocommerce-tabs wc-tabs-wrapper">
						<ul class="nav nav-tabs electro-nav-tabs tabs wc-tabs" role="tablist">

							<li class="nav-item description_tab">
								<a href="#tab-description" class="active" data-toggle="tab">Description</a>
							</li>

							<li class="nav-item reviews_tab">
								<a href="#tab-reviews" data-toggle="tab">Reviews</a>
							</li>
						</ul>

<div class="tab-content">
							
<!-- 店铺的详细描述 -->

<div class="tab-pane active in panel entry-content wc-tab" id="tab-description">
<h3>Technical Specifications</h3>
<table class="table">
	<tbody>
		<tr>
			<td>Brand</td>
			<td>Apple</td>
		</tr>
		<tr>
			<td>Item Height</td>
			<td>18 Millimeters</td>
		</tr>
		<tr>
			<td>Item Width</td>
			<td>31.4 Centimeters</td>
		</tr>
		<tr>
			<td>Screen Size</td>
			<td>13 Inches</td>
		</tr>
		<tr class="size-weight">
			<td>Item Weight</td>
			<td>1.6 Kg</td>
		</tr>
		<tr class="size-weight">
			<td>Product Dimensions</td>
			<td>21.9 x 31.4 x 1.8 cm</td>
		</tr>
		<tr class="item-model-number">
			<td>Item model number</td>
			<td>MF841HN/A</td>
		</tr>
		<tr>
			<td>Processor Brand</td>
			<td>Intel</td>
		</tr>
		<tr>
			<td>Processor Type</td>
			<td>Core i5</td>
		</tr>
		<tr>
			<td>Processor Speed</td>
			<td>2.9 GHz</td>
		</tr>
		<tr>
			<td>RAM Size</td>
			<td>8 GB</td>
		</tr>
		<tr>
			<td>Hard Drive Size</td>
			<td>512 GB</td>
		</tr>
		<tr>
			<td>Hard Disk Technology</td>
			<td>Solid State Drive</td>
		</tr>
		<tr>
			<td>Graphics Coprocessor</td>
			<td>Intel Integrated Graphics</td>
		</tr>
		<tr>
			<td>Graphics Card Description</td>
			<td>Integrated Graphics Card</td>
		</tr>
		<tr>
			<td>Hardware Platform</td>
			<td>Mac</td>
		</tr>
		<tr>
			<td>Operating System</td>
			<td>Mac OS</td>
		</tr>
		<tr>
			<td>Average Battery Life (in hours)</td>
			<td>9</td>
		</tr>
	</tbody>
</table>
							</div><!-- /.panel -->

							<div class="tab-pane panel entry-content wc-tab" id="tab-reviews">
								<div id="reviews" class="electro-advanced-reviews">
	<div class="advanced-review row">
		<div class="col-xs-12 col-md-6">
			<h2 class="based-title">Based on 3 reviews</h2>
			<div class="avg-rating">
				<span class="avg-rating-number">4.3</span> overall
			</div>

			<div class="rating-histogram">
				<div class="rating-bar">
					<div class="star-rating" title="Rated 5 out of 5">
						<span style="width:100%"></span>
					</div>
					<div class="rating-percentage-bar">
						<span style="width:33%" class="rating-percentage">

						</span>
					</div>
					<div class="rating-count">1</div>
				</div><!-- .rating-bar -->

				<div class="rating-bar">
					<div class="star-rating" title="Rated 4 out of 5">
						<span style="width:80%"></span>
					</div>
					<div class="rating-percentage-bar">
						<span style="width:67%" class="rating-percentage"></span>
					</div>
					<div class="rating-count">2</div>
				</div><!-- .rating-bar -->

				<div class="rating-bar">
					<div class="star-rating" title="Rated 3 out of 5">
						<span style="width:60%"></span>
					</div>
					<div class="rating-percentage-bar">
						<span style="width:0%" class="rating-percentage"></span>
					</div>
					<div class="rating-count zero">0</div>
				</div><!-- .rating-bar -->

				<div class="rating-bar">
					<div class="star-rating" title="Rated 2 out of 5">
						<span style="width:40%"></span>
					</div>
					<div class="rating-percentage-bar">
						<span style="width:0%" class="rating-percentage"></span>
					</div>
					<div class="rating-count zero">0</div>
				</div><!-- .rating-bar -->

				<div class="rating-bar">
					<div class="star-rating" title="Rated 1 out of 5">
						<span style="width:20%"></span>
					</div>
					<div class="rating-percentage-bar">
						<span style="width:0%" class="rating-percentage"></span>
					</div>
					<div class="rating-count zero">0</div>
				</div><!-- .rating-bar -->
			</div>
		</div><!-- /.col -->

		<div class="col-xs-12 col-md-6">
			<div id="review_form_wrapper">
				<div id="review_form">
					<div id="respond" class="comment-respond">
						<h3 id="reply-title" class="comment-reply-title">Add a review
							<small><a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display:none;">Cancel reply</a>
							</small>
						</h3>

						<form action="#" method="post" id="commentform" class="comment-form">
							<p class="comment-form-rating">
								<label>Your Rating</label>
							</p>

							<p class="stars">
								<span><a class="star-1" href="#">1</a>
									<a class="star-2" href="#">2</a>
									<a class="star-3" href="#">3</a>
									<a class="star-4" href="#">4</a>
									<a class="star-5" href="#">5</a>
								</span>
							</p>

							<p class="comment-form-comment">
								<label for="comment">Your Review</label>
								<textarea id="comment" name="comment" cols="45" rows="8" aria-required="true"></textarea>
							</p>

							<p class="form-submit">
								<input name="submit" type="submit" id="submit" class="submit" value="Add Review" />
								<input type='hidden' name='comment_post_ID' value='2452' id='comment_post_ID' />
								<input type='hidden' name='comment_parent' id='comment_parent' value='0' />
							</p>

							<input type="hidden" id="_wp_unfiltered_html_comment_disabled" name="_wp_unfiltered_html_comment_disabled" value="c7106f1f46" />
							<script>(function(){if(window===window.parent){document.getElementById('_wp_unfiltered_html_comment_disabled').name='_wp_unfiltered_html_comment';}})();</script>
						</form><!-- form -->
					</div><!-- #respond -->
				</div>
			</div>

		</div><!-- /.col -->
	</div><!-- /.row -->

	<div id="comments">

		<ol class="commentlist">
			<li itemprop="review" class="comment even thread-even depth-1">

				<div id="comment-390" class="comment_container">

					<img alt='' src="assets/images/blog/avatar.jpg" class='avatar' height='60' width='60' />
					<div class="comment-text">

						<div class="star-rating" title="Rated 4 out of 5">
							<span style="width:80%"><strong itemprop="ratingValue">4</strong> out of 5</span>
						</div>


						<p class="meta">
							<strong>John Doe</strong> &ndash;
							<time itemprop="datePublished" datetime="2016-03-03T14:13:48+00:00">March 3, 2016</time>:
						</p>



						<div itemprop="description" class="description">
							<p>Fusce vitae nibh mi. Integer posuere, libero et ullamcorper facilisis, enim eros tincidunt orci, eget vestibulum sapien nisi ut leo. Cras finibus vel est ut mollis. Donec luctus condimentum ante et euismod.
							</p>
						</div>


						<p class="meta">
							<strong itemprop="author">John Doe</strong> &ndash; <time itemprop="datePublished" datetime="2016-03-03T14:13:48+00:00">March 3, 2016</time>
                            <a href="#" style="float:right" rel="nofollow" class="comment_cool"> cool</a>
                            <a href="#" style="float:right" rel="nofollow" class="comment_funny"> funny</a>
                            <a href="#" style="float:right" rel="nofollow" class="comment_useful"> useful</a>
						</p>


					</div>
				</div>
			</li><!-- #comment-## -->

			<li class="comment odd alt thread-odd thread-alt depth-1">

				<div class="comment_container">

					<img alt='' src="assets/images/blog/avatar.jpg" class='avatar' height='60' width='60' />
					<div class="comment-text">

						<div itemprop="reviewRating" itemscope itemtype="http://schema.org/Rating" class="star-rating" title="Rated 5 out of 5">
							<span style="width:100%"><strong itemprop="ratingValue">5</strong> out of 5</span>
						</div>

						<p class="meta">
							<strong>Anna Kowalsky</strong> &ndash;
							<time itemprop="datePublished" datetime="2016-03-03T14:14:47+00:00">March 3, 2016</time>:
						</p>


						<div itemprop="description" class="description">
							<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse eget facilisis odio. Duis sodales augue eu tincidunt faucibus. Etiam justo ligula, placerat ac augue id, volutpat porta dui.
							</p>
						</div>

						<p class="meta">
							<strong itemprop="author">Anna Kowalsky</strong> &ndash; <time itemprop="datePublished" datetime="2016-03-03T14:14:47+00:00">March 3, 2016</time>
						</p>

					</div>
				</div>
			</li><!-- #comment-## -->

			<li class="comment odd alt thread-odd thread-alt depth-1">

				<div class="comment_container">

					<img alt='' src="assets/images/blog/avatar.jpg" class='avatar' height='60' width='60' />
					<div class="comment-text">

						<div itemprop="reviewRating" class="star-rating" title="Rated 5 out of 5">
							<span style="width:100%"><strong itemprop="ratingValue">5</strong> out of 5</span>
						</div>

						<p class="meta">
							<strong>Anna Kowalsky</strong> &ndash;
							<time itemprop="datePublished" datetime="2016-03-03T14:14:47+00:00">March 3, 2016</time>:
						</p>


						<div itemprop="description" class="description">
							<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse eget facilisis odio. Duis sodales augue eu tincidunt faucibus. Etiam justo ligula, placerat ac augue id, volutpat porta dui.
							</p>
						</div>

						<p class="meta">
							<strong itemprop="author">Anna Kowalsky</strong> &ndash; <time itemprop="datePublished" datetime="2016-03-03T14:14:47+00:00">March 3, 2016</time>
						</p>

					</div>
				</div>
			</li><!-- #comment-## -->
		</ol><!-- /.commentlist -->

	</div><!-- /#comments -->

	<div class="clear"></div>
</div><!-- /.electro-advanced-reviews -->
							</div><!-- /.panel -->
						</div>
					</div><!-- /.woocommerce-tabs -->

				</div><!-- /.product -->

			</main><!-- /.site-main -->
		</div><!-- /.content-area -->
	</div><!-- /.container -->
</div><!-- /.site-content -->


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

        <!-- For demo purposes – can be removed on production -->

        <script src="switchstylesheet/switchstylesheet.js"></script>

           <script>
           (function($) {
               $(document).ready(function(){
                   $(".changecolor").switchstylesheet( { seperator:"color"} );
                   $('.show-theme-options').click(function(){
                       $(this).parent().toggleClass('open');
                       return false;
                   });

                   $('#home-pages').on( 'change', function() {
                       $.ajax({
                           url : $('#home-pages option:selected').val(),
                           success:function(res) {
                               location.href = $('#home-pages option:selected').val();
                           }
                       });
                   });

                    $('#demo-pages').on( 'change', function() {
            			$.ajax({
            				url : $('#demo-pages option:selected').val(),
            				success:function(res) {
            					location.href = $('#demo-pages option:selected').val();
            				}
            			});
            		});

                    $('#header-style').on( 'change', function() {
            			$.ajax({
            				url : $('#header-style option:selected').val(),
            				success:function(res) {
            					location.href = $('#header-style option:selected').val();
            				}
            			});
            		});

                    $('#shop-style').on( 'change', function() {
            			$.ajax({
            				url : $('#shop-style option:selected').val(),
            				success:function(res) {
            					location.href = $('#shop-style option:selected').val();
            				}
            			});
            		});

                    $('#product-category-col').on( 'change', function() {
            			$.ajax({
            				url : $('#product-category-col option:selected').val(),
            				success:function(res) {
            					location.href = $('#product-category-col option:selected').val();
            				}
            			});
            		});

                    $('#single-products').on( 'change', function() {
            			$.ajax({
            				url : $('#single-products option:selected').val(),
            				success:function(res) {
            					location.href = $('#single-products option:selected').val();
            				}
            			});
            		});

                    $('.style-toggle').on( 'click', function() {
            			$(this).parent('.config').toggleClass( 'open' );
            		});
               });
        })(jQuery);
        </script>
        <!-- For demo purposes – can be removed on production : End -->

    </body>
</html>
