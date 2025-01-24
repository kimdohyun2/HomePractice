<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!--현재 스프링 시큐리티에서 인증된 사용자 객체 가져옴(UserDetails)-->
<c:set var="memVo" value="${SPRING_SECURITY_CONTEXT.authentication.principal}"/>
<c:set var="auth" value="${SPRING_SECURITY_CONTEXT.authentication.authorities}"/>

<script>
    let csrfName = "${_csrf.headerName}";
    let csrfToken = "${_csrf.token}";

    console.log("${memVo}")
    console.log("${auth}")
    console.log("${memVo.username}")
    console.log("${memVo.password}")
    console.log("${memVo.member.memberName}")
    console.log("${empty loginMemSession}")
    console.log("${principal}")

    $(document).ready(function () {
        if (${!empty messageType}) {
            $("#myModal").modal("show");
        }
    });

    function logoutFunc(){
        $.ajax({
            url:"${root}member/logout",
            type:"post",
            beforeSend: function (xhr){
                xhr.setRequestHeader(csrfName,csrfToken)
            },
            success: function (){
                location.href="${root}";
            },
            error: function (request, error) {
                console.log(request.responseText);
                console.log(error);
            }
        })
    }
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
                <li><a href="${root}board/main">게시판</a></li>
            </ul>


            <security:authorize access="isAnonymous()">
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
            </security:authorize>

            <security:authorize access="isAuthenticated()">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <c:if test="${empty memVo.member.memberProfile }">
                            <span class="navbar-text">
                                <img src="${root}resources/img/defaultImage.webp"
                                     style="width:30px;height:40px" class="rounded-pill">
                            </span>
                        </c:if>
                        <c:if test="${!empty memVo.member.memberProfile}">
                            <span class="navbar-text">
                                <img src="${root}resources/img/${memVo.member.memberProfile}"
                                     style="width:30px;height:40px" class="rounded-pill">
                            </span>
                        </c:if>
                        <span class="navbar-text">
                            ${memVo.member.memberName}
                            <security:authorize access="hasRole('ROLE_USER')">
                                일반회원
                            </security:authorize>
                            <security:authorize access="hasRole('ROLE_VIP')">
                                VIP
                            </security:authorize>
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                관리자
                            </security:authorize>님 환영합니다
<%--                                ${loginMemSession.memberName}님--%>
<%--                                    <c:forEach var="authVo" items="${loginMemSession.authList}">--%>
<%--                                        <c:if test="${authVo.auth eq 'ROLE_USER'}">일반회원</c:if>--%>
<%--                                        <c:if test="${authVo.auth eq 'ROLE_VIP'}">VIP</c:if>--%>
<%--                                        <c:if test="${authVo.auth eq 'ROLE_ADMIN'}">관리자</c:if>--%>
<%--                                    </c:forEach>--%>
<%--                                    환영합니다--%>
                        </span>
                    </li>

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">접속<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${root}member/update">정보수정</a></li>
                            <li><a href="${root}member/imageForm">사진등록</a></li>
                            <li><a href="javascript:logoutFunc()">로그아웃</a></li>
                            <form action="${root}member/logout" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <input type="submit" value="로그아웃">
                            </form>
                        </ul>
                    </li>
                </ul>
            </security:authorize>
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