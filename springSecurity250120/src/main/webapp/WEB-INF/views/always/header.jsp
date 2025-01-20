<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<script>
    $(document).ready(function () {
        if (${!empty messageType}) {
            $("#myModal").modal("show");
        }
    });
</script>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">

            </button>
            <a class="navbar-brand" href="${root}">스프링</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="${root}main">게시판</a></li>
            </ul>


            <c:choose>
                <c:when test="${empty loginMemSession}">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">접속<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${root}member/login">
                                    <span class="glyphicon glyphicon-education"></span>로그인</a></li>
                                <li><a href="${root}member/join">
                                    <span class="glyphicon glyphicon-user"></span>회원가입</a></li>
                            </ul>
                        </li>
                    </ul>
                </c:when>

                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="navbar-brand">
                            <img src="${root}resources/img/${loginMemSession.memberProfile}" style="width:40px;"
                                 class="rounded-pill">
                        </li>
                        <c:if test="${loginMemSession.memberProfile eq ''}">
                        <span class="navbar-text">
                                    ${loginMemSession.memberName}님
                                <c:forEach var="authVo" items="${loginMemSession.authList}">
                                    <c:if test="${authVo.auth eq 'ROLE_USER'}">일반회원</c:if>
                                    <c:if test="${authVo.auth eq 'ROLE_VIP'}">VIP</c:if>
                                    <c:if test="${authVo.auth eq 'ROLE_ADMIN'}">관리자</c:if>
                                </c:forEach>
                                환영합니다
                        </span>>
                        </c:if>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">접속<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${root}member/update">정보수정</a></li>
                                <li><a href="${root}member/imageForm">사진등록</a></li>
                                <li><a href="${root}member/logout">로그아웃</a></li>
                            </ul>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div id="checkType2" class="modal-content panel-info">
            <div class="modal-header panel-heading">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" id="modalTitle">${messageType}</h4>
            </div>
            <div class="modal-body">
                <p id="idcheck">${message}</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>