<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<!DOCTYPE html>
<html>
<head>
    <title>수강신청</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h4 class="mb-0">로그인</h4>
                </div>
                <div class="card-body">
                    <c:if test="${fail==true}">
                        <div class="alert alert-danger alert-dismissible fade show">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>로그인 실패!</strong> 아이디와 비밀번호를 확인해주세요.
                        </div>
                    </c:if>

                    <form:form action="${root}login_pro" method="post" modelAttribute="loginProBean"
                               class="needs-validation" novalidate="true">
                        <input type="hidden" name="fail" value="${fail}">
                        <div class="form-group">
                            <form:label path="stu_id" class="font-weight-bold">아이디</form:label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <form:input path="stu_id" class="form-control" placeholder="아이디를 입력하세요"/>
                            </div>
                            <form:errors path="stu_id" class="text-danger small"/>
                        </div>

                        <div class="form-group">
                            <form:label path="stu_pw" class="font-weight-bold">비밀번호</form:label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                                </div>
                                <form:password path="stu_pw" class="form-control" placeholder="비밀번호를 입력하세요"/>
                            </div>
                            <form:errors path="stu_pw" class="text-danger small"/>
                        </div>

                        <div class="form-group mt-4">
                            <form:button class="btn btn-primary btn-block py-2">
                                로그인
                            </form:button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Font Awesome 아이콘 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
</body>
</html>