<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>

<head>
    <title>로그인 조이고</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery-3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body style="background-color: rgba(211, 211, 211, 0.5);">
<div class="container" style="margin-top: 50px; margin-bottom: 50px">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card" style="border-radius: 10px; overflow: hidden;">
                <div class="card-header" style="background-color: rgba(173, 216, 230, 0.5);">
                    <h2>로그인</h2>
                </div>
                <c:if test="${fail==true}">
                    <div style="padding: 20px 20px 0 20px">
                    <div class="alert alert-danger">
                        <h2>로그인 실패</h2>
                        <p>아이디랑 비밀번호를 확인하세요</p>
                    </div>
                    </div>
                </c:if>
                <div class="card-body">
                    <!-- Spring form:form 태그로 변환 -->
                    <form:form method="POST" action="${root}login_pro" modelAttribute="loginBean">
                        <!-- 아이디 -->
                        <div class="form-group">
                            <label for="user_id">아이디</label>
                            <form:input path="user_id" class="form-control" id="user_id"/>
                            <form:errors path="user_id" style='color:red'/>
                        </div>

                        <!-- 비밀번호 -->
                        <div class="form-group">
                            <label for="user_pw">비밀번호</label>
                            <form:input type="password" path="user_pw" class="form-control" id="user_pw"/>
                            <form:errors path="user_pw" style='color:red'/>
                        </div>

                        <!-- 로그인 버튼 -->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">로그인</button>
                        </div>

                        <!-- 회원가입 링크 -->
                        <div class="form-group">
                            <p>아직 회원이 아니신가요? <a href="${root}join">회원가입</a></p>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
