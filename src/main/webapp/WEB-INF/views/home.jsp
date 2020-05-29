<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scaleable=no">
<title>HOME</title>
<link rel="shortcut icon" href="/images/favicon/favicon.ico">
<link rel="apple-touch-icon-precomposed"
	href="/images/favicon/home-touch-icon.png">
<link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/resources/css/user.css">
<style>
.go_top {
	position: fixed;
	right: 20px;
	bottom: 112px;
	text-align: center;
	background: red;
	z-index: 100;
	padding: 20px;
	opacity: 0.5;
	color: blue !important;
}
</style>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/common.js"></script>
<!-- 사용자 스크립트 -->
<script>
	
</script>
</head>
<body>
	<!-- 더미 데이터:CSS작업전 내용 -->
	<div id="wrap">
		<header class="header cfixed">
			<h1 class="logo">
				<a href="">LOGO</a>
			</h1>
			<nav>
				<ul class="gnb">
					<li><a href="/">HOME</a></li>
					<li><a href="#weare">WE ARE</a></li>
					<li><a href="#work">WORK</a></li>
					<li><a href="#blog">BLOG</a></li>
					<li><a href="#contactus">CONTACT US</a></li>
				</ul>
			</nav>
			<span class="menu-toggle-btn"> <span></span> <span></span> <span></span>
			</span>
		</header>
		<article class="slider">
			<img src="/resources/images/qwe.jpg" alt="">
		</article>
		<section class="content">
			<section class="display-section">
				<div class="container">
					<h2 class="sec-tit" id="weare">WE ARE</h2>
					<p class="desc">
						"휴먼 교육센터 디지털 컨버전스 과정 입니다." <br> "그리고, 지금은 화면 설계 시간 입니다."
					</p>
				</div>
			</section>
			<section class="promotion-section">
				<div class="container">
					<ul class="promo-list">
						<li><a href="#" onclick="return false"> <img
								src="/resources/images/qwe.jpg" alt="">
								<h3>HOME</h3>
								<p>휴면 교육센터 디지털 컨버전스 과정 입니다.</p>
						</a></li>
						<li><a href="#" onclick="return false"> <img
								src="/resources/images/qwe.jpg" alt="">
								<h3>HOME</h3>
								<p>휴면 교육센터 디지털 컨버전스 과정 입니다.</p>
						</a></li>
						<li><a href="#" onclick="return false"> <img
								src="/resources/images/qwe.jpg" alt="">
								<h3>HOME</h3>
								<p>휴면 교육센터 디지털 컨버전스 과정 입니다.</p>
						</a></li>
						<li><a href="#" onclick="return false"> <img
								src="/resources/images/qwe.jpg" alt="">
								<h3>HOME</h3>
								<p>휴면 교육센터 디지털 컨버전스 과정 입니다.</p>
						</a></li>
					</ul>
				</div>
			</section>

		</section>
		<section class="work-section cfixed">
			<h2 class="sec-tit" id="work">WORK</h2>
			<ul class="work-list">
				<li><a href="#" onclick="return false">
						<div class="info">
							<h3>작업1</h3>
							<span>소스/작업1</span>
						</div> <img src="/resources/images/qwe.jpg" alt="">
				</a></li>
				<li><a href="#" onclick="return false">
						<div class="info">
							<h3>작업1</h3>
							<span>소스/작업1</span>
						</div> <img src="/resources/images/qwe.jpg" alt="">
				</a></li>
				<li><a href="#" onclick="return false">
						<div class="info">
							<h3>작업1</h3>
							<span>소스/작업1</span>
						</div> <img src="/resources/images/qwe.jpg" alt="">
				</a></li>
				<li><a href="#" onclick="return false">
						<div class="info">
							<h3>작업1</h3>
							<span>소스/작업1</span>
						</div> <img src="/resources/images/qwe.jpg" alt="">
				</a></li>
				<li><a href="#" onclick="return false">
						<div class="info">
							<h3>작업1</h3>
							<span>소스/작업1</span>
						</div> <img src="/resources/images/qwe.jpg" alt="">
				</a></li>
				<li><a href="#" onclick="return false">
						<div class="info">
							<h3>작업1</h3>
							<span>소스/작업1</span>
						</div> <img src="/resources/images/qwe.jpg" alt="">
				</a></li>
				<li><a href="#" onclick="return false">
						<div class="info">
							<h3>작업1</h3>
							<span>소스/작업1</span>
						</div> <img src="/resources/images/qwe.jpg" alt="">
				</a></li>
				<li><a href="#" onclick="return false">
						<div class="info">
							<h3>작업1</h3>
							<span>소스/작업1</span>
						</div> <img src="/resources/images/qwe.jpg" alt="">
				</a></li>

			</ul>
		</section>
		<section class="blog-section">
			<div class="container">
				<h2 class="sec-tit" id="blog">BLOG</h2>
				<ul class="blog-list">
					<li><a href="#" onclick="return false"><img
							src="/resources/images/qwe.jpg" alt=""></a> <time
							datetime="2016-10-30">OCT 30, 2016</time> <a href=""><h3>타임스페이스는
								사용자 중심의 웹페이지를 제작하는 회사 입니다.</h3></a></li>
					<li><a href="#" onclick="return false"><img
							src="/resources/images/qwe.jpg" alt=""></a> <time
							datetime="2016-10-30">OCT 30, 2016</time> <a href=""><h3>타임스페이스는
								사용자 중심의 웹페이지를 제작하는 회사 입니다.</h3></a></li>
					<li><a href="#" onclick="return false"><img
							src="/resources/images/qwe.jpg" alt=""></a> <time
							datetime="2016-10-30">OCT 30, 2016</time> <a href=""><h3>타임스페이스는
								사용자 중심의 웹페이지를 제작하는 회사 입니다.</h3></a></li>
				</ul>
			</div>
		</section>
		<section class="contact-section">
			<div class="container">
				<h2 class="sec-tit" id="contactus">CONTACT</h2>
				<div class="form-box">
					<form action="" method="">
						<fieldset class="cfixed">
							<legend class="blind">CONTACT US</legend>
							<div class="form">
								<label for="name" class="blind">name</label> <input type="text"
									id="name" placeholder="Name"> <label for="phone"
									class="blind">phone</label> <input type="tel" id="phone"
									placeholder="Phone"> <label for="email" class="blind">email</label>
								<input type="email" id="email" placeholder="Email Address">
							</div>
							<div class="textarea">
								<label for="message" class="blind">message</label>
								<textarea name="message" id="message" placeholder="Message"></textarea>
							</div>
						</fieldset>
						<div class="send-btn">
							<button>메세지 보내기</button>
						</div>
					</form>
				</div>
			</div>
		</section>
		<footer class="footer">
			<p class="copyright">LOGO</p>
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3193.1908531424174!2d127.18028131558675!3d36.83790497994078!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b293c64087a5b%3A0x1873dee0e6399a00!2z67Cx7ISd66y47ZmU64yA7ZWZ6rWQ!5e0!3m2!1sko!2skr!4v1513569521608"
				width="600" height="450" frameborder="0" style="border: 0"
				allowfullscreen=""></iframe>
		</footer>
	</div>
	<a href="#" class="s_point">
		<p class="go_top">TOP</p>
	</a>
	</p>
</body>
</html>