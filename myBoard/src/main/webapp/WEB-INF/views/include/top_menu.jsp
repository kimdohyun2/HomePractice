<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />

<nav
	class="navbar navbar-expand-md bg-dark text-white fixed-up shadow-lg">
    <a class="navbar-brand" href="${root}main">화이팅♥</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav">
          <c:forEach var="board" items="${boardList}">
              <li class="nav-item">
                  <a class="nav-link" href="${root}board/main?board_info_idx=${board.board_info_idx}&page=1">${board.board_info_name}</a>
              </li>
          </c:forEach>
      </ul>

        <ul class="navbar-nav ml-auto">
        <c:choose>
            <c:when test="${loginBean.userLogin==true}">
                <li class="nav-item">
                    <a class="nav-link" href="${root}user/modify">비밀번호수정</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${root}user/logout">로그아웃</a>
                </li>
            </c:when>

            <c:otherwise>
                <li class="nav-item">
                  <a class="nav-link" href="${root}user/login">로그인</a>
                </li>
                <li class="nav-item">
                   <a class="nav-link" href="${root}user/join">회원가입</a>
                </li>
            </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>