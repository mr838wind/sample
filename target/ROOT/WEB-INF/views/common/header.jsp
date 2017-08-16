<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String headerCategoryYN = StringUtils.stripToEmpty(request.getParameter("headerCategoryYN"));
	// default "N"
	if(StringUtils.isEmpty(headerCategoryYN)) {
		headerCategoryYN = "N";
	}
	String uri = request.getRequestURI();
	boolean hideCategories = uri.endsWith("main.jsp") || uri.endsWith("mypage.jsp") || uri.endsWith("search.jsp");
	
%>
<style>

	.nav .active > a{color:#fff; border-radius:2px; background:#bebebe;}
	
	.menuSelected {
		border-radius:2px; 
		background:#bebebe;
	}
	
	.menuSelected a {
		color:#fff;
	}
	
	#menuBox li a {
		padding-left: 10px;
		padding-right: 10px;
	}
	
	/*.mainCategory {
		position: absolute !important;
		padding-left: 78px !important;
		border-bottom: 1px solid #b9b9b9;
		border-top: 1px solid #b9b9b9;
		display: none;
		background-color: #fff;
		width:100% !important;
	}*/
	
	.mainCategory {
		display: none;
	}
	
	/* .mainNavCate {
		border:none;
	} */
	
	.mainNavCate {
		border-top: 1px solid #b9b9b9;
	}
	
	
	
	.header{
		background-color: #fff;
    	width: 100%;
    	position: fixed;
    	z-index:10;
	}
	
	.main-content {
		padding-top: 129px;
	}
	
	.project-content {
		padding-top: 220px;
	}
	
	.list-content {
		padding-top: 220px;
	}
	
	.sub-content {
		padding-top: 150px;
	}
	
	.portfolio-content {
		padding-top: 220px;
	}
	
	.detail-content {
		padding-top: 220px;
	}
	
	.request-content {
		padding-top: 180px;
	}
	
	.search-content {
		padding-top: 180px;
	}
	
	.content {
		padding-top: 220px;
	}
	
</style>
	<!-- header -->
	<div class="header">
		<!-- inner -->
		<jsp:include page="/openHeaderInner.do" />
		<!-- //inner -->
		
		<!-- naver -->
		<div class="nav-section">
			<!-- nav -->
			<script>
				
				//현재 활성화된 메뉴 (1뎁스 카테고리)
				var activeMenu;
				
				//롤오버 메뉴
				var hoverMenu;
				
				//현재 활성화된 카테고리
				var activeCategory;
				
				//자연 카테고리 (필터 대상)
				var natureCategory;
				
				
				var menuList = new Array();
				
				menuList[0] = 	"/product/";
				
				menuList[1] = 	"/project/";
				
				menuList[2] = "/designer/";
								
				menuList[3] = "/producer/";
				
				
				
				$(function(){
					
					natureCategory = $('.nav-cate .depth2').find("#007");
					
					//자연 메뉴 제외한 메뉴들 show
					$('.nav-cate .depth2').children().each(function() {
						
						if( $(this).hasClass('active') ) {
							activeCategory = this;
						}
						
						if( $(this) != natureCategory ) {
							$(this).show();
						}
					})
					
					//메뉴 밖으로 나갔을 경우
					$('#menuArea').mouseleave(function() {
						$('#menuBox li').each(function() {
							$(this).removeClass('menuSelected');
						})
						
						$(activeMenu).addClass("active");
						$(activeCategory).addClass("active");
						
						hoverMenu = activeMenu;
						if( <%=hideCategories%> ) {
							$('.depth2').hide();	
						}
						
						filterMenus(true);
						
					});
					
					//메뉴 롤 오버시
					$('#menuBox li').mouseover(function() {
						
						$(activeMenu).removeClass("active");
						$(activeCategory).removeClass("active");
						
						
						$('#menuBox li').each(function() {
							$(this).removeClass('menuSelected');
						});
						
						$(this).addClass('menuSelected');
						hoverMenu = this;
						$('.depth2').show();
						filterMenus();
					});
					
					
					$('.nav-cate .depth2 > li').mouseover(function() {
						if( activeCategory != this ) {
							$(activeCategory).removeClass("active");
						}
					});
					
					//활성화 메뉴 초기화
					initActiveMenu();
					
				});
				
				function initActiveMenu() {
					
					var currentPath = window.location.pathname;
					var activeMenuIndex = 0;
					
					for( var i =0; i < menuList.length; i++ ) {
						
						// menuList 변경: '/designer/designer.do' ---> '/designer/';
						var menu = menuList[i];
						if(currentPath.startsWith(menu)) {
							//console.log('>>> menu=' + menu + ', currentPath=' + currentPath);
							activeMenu = $( "#menuBox li:eq("+activeMenuIndex+")" ).get(0);
							$(activeMenu).addClass("active");
							hoverMenu = activeMenu;
							filterMenus(true);
							return;
						}
						
						activeMenuIndex++;
					}
				}
				
				/**
				* 메뉴 필터링
				* 현재는 자연 카테고리만 상단 메뉴에 맞게 필터링 함
				*/
				function filterMenus(mouseLeave) {
					
					if( mouseLeave ) {
						if( $(activeMenu).attr('id') == "product" || $(activeMenu).attr('id') == "project" ) {
							$(natureCategory).show();
						} else {
							$(natureCategory).hide();
						}
					} else {
						
						if( $(hoverMenu).attr('id') == "designer" || $(hoverMenu).attr('id') == "producer" ) {
							$(natureCategory).hide();
						} else {
							$(natureCategory).show();
						}
					}
				}
				
				function searchCategory(searchCode) {
					var menuURI = $(hoverMenu).find('a').attr('href');
					window.location.href = menuURI + "?schCate=" + searchCode;
					//javascript:searchCategory(); schCate=
				}
				
			</script>
			<h2 class="skip">메인메뉴</h2>
			<div id="menuArea">
				<div class="nav">
					<ul id="menuBox">
						<li id="product" class="first"><a href="/product/product.do">디자인</a></li>
						<li id="project"><a href="/project/project.do">디자인 프로젝트</a></li>
						<li id="designer"><a href="/designer/designer.do">디자이너</a></li>
						<li id="producer" class="last"><a href="/producer/producer.do">제작자</a></li>
					</ul>
				</div>
				<!-- 카테고리 -->
				<%-- <% if("Y".equals(headerCategoryYN) ) { %> --%>
				
				<div class="nav-cate <%=hideCategories ? "mainNavCate" : "" %>">
					<ul class="depth2 <%=hideCategories ? "mainCategory" : "" %>" >
						<jsp:include page="/openHeaderNaverCate.do" />
					</ul>
				</div>
				
				<%-- <% } %> --%>
				<!-- //카테고리 -->
			</div>
		</div>
		<!-- //naver -->
	</div>
	<!-- //header -->