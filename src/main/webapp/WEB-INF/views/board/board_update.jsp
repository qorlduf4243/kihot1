<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ include file="../include/header.jsp" %>
   
   <!-- container -->
   <div id="container">
      <!-- location_area -->
      <div class="location_area member">
         <div class="box_inner">
            <h2 class="tit_page">스프링 <span class="in">in</span> 자바</h2>
            <p class="location">고객센터 <span class="path">/</span> 공지사항</p>
            <ul class="page_menu clear">
               <li><a href="javascript:;" class="on">회원가입</a></li>
            </ul>
         </div>
      </div>   
      <!-- //location_area -->

      <!-- bodytext_area -->
      <div class="bodytext_area box_inner">
         <!-- appForm -->
         <form action="/board/update" class="appForm" method="post" encType="multipart/form-data">
            <fieldset>
               <legend>게시판 입력 양식</legend>
               <p class="info_pilsoo pilsoo_item">필수입력</p>
               <ul class="app_list">                  
                  <li class="clear">
                     <label for="title_lbl" class="tit_lbl pilsoo_item">제목</label>
                     <div class="app_content"><input value="${boardVO.title}" name="title" type="text" class="w100p" id="title_lbl" placeholder="제목을 입력하세요." required /></div>
                  </li>
                  <li class="clear">
                     <label for="content_lbl" class="tit_lbl pilsoo_item">내용</label>
                     <div class="app_content"><textarea name="content" id="content_lbl" class="w100p" placeholder="내용을 남겨주세요." required >${boardVO.content}</textarea></div>
                  </li>
                  <li class="clear">
                     <label for="name_lbl" class="tit_lbl pilsoo_item">작성자명</label>
                     <div class="app_content"><input value="${boardVO.writer}" name="writer" type="text" class="w100p" id="pwd2_lbl" placeholder="이름을 입력해주세요." required /></div>
                  </li>
                  <li class="clear">
                  <label for="file_lbl" class="tit_lbl">첨부파일</label>
                     <div class="app_content"><input type="file" name="file" id="file_lbl" value="파일선택"></div>
                  </li>
                                 
               </ul>
               <p class="btn_line">
               <button type="submit" class="btn_baseColor">수정</button>
               
               <button onclick="location.href='/board/list';return false;" class="btn_baseColor">목록</button>
               </p>   
               
            </fieldset>
            <input name = "bno" type="hidden" value="${boardVO.bno}">
            <input name="page" type="hidden" value="${pageVO.page}">
         </form>
         <!-- //appForm -->
         
      </div>
      <!-- //bodytext_area -->

   </div>
   <!-- //container -->
   
<%@ include file="../include/footer.jsp" %>