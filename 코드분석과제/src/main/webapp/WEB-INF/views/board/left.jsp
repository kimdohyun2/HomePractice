<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<c:set var="root" value="${pageContext.request.contextPath}"/>
<div class="card" style="min-height: 500px;max-height: 1000px;">
   <div class="row">
     <div class="col-lg-12">
       <div class="card-body">
        <c:if test="${empty mem}">
         <h4 class="card-title">회원님</h4>
         <p class="card-text">환영합니다</p>         
         <form action="${root}/login/loginPro" method="post">
           <div class="form-group">
		    <label for="memberID">아이디:</label>
		    <input type="text" class="form-control" name="memberID">
		  </div>
		  <div class="form-group">
		    <label for="memberPwd">비밀번호:</label>
		    <input type="password" class="form-control" name="memberPwd">
		  </div>
		  <button type="submit" class="btn btn-primary form-control">로그인</button>
         </form>
         </c:if>
         <c:if test="${!empty mem}">
         <h4 class="card-title">${mem.memberName}</h4>
         <p class="card-text">환영합니다</p>
		 <form action="${root}/login/logoutPro" method="post">		  
		  <button type="submit" class="btn btn-primary form-control">로그아웃</button>
		 </form>
		</c:if>
       </div>
     </div>
   </div>    
    <div class="row">
     <div class="col-lg-12">
       <div class="card-body">
         <p class="card-text">MAP</p>
         <div class="input-group mb-3">
             <input type="text" class="form-control" id="address" placeholder="Search"/>
             <div class="input-group-append">
               <button type="button" class="btn btn-secondary" id="mapBtn">Go</button>             
             </div>         
         </div>
         <div id="map" style="width:100%;height:150px;"></div>
       </div>
     </div>
   </div> 
</div>