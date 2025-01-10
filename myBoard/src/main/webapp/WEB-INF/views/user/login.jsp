<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<head>
    <title>우리반 화이팅♥</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery-3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="/WEB-INF/views/include/top_menu.jsp"/>

<div class="container" style="margin-top: 100px; margin-bottom: 100px">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card shadow">
                <div class="card-body">
                    <c:if test="${fail==true}">
                        <div class="alert alert-danger">
                            <h2>로그인 실패</h2>
                            <p>아이디랑 비밀번호 확인해라</p>
                        </div>
                    </c:if>
                    <form:form action="${root}user/login_pro" method="post" modelAttribute="loginProBean">
                        <div class="form-group">
                            <form:label path="user_id">아이디</form:label>
                            <form:input type="text" path="user_id" class="form-control"/>
                            <form:errors path="user_id" style='color:red'/>
                        </div>
                        <div class="form-group">
                            <form:label path="user_pw">비밀번호</form:label>
                            <form:password path="user_pw" class="form-control"/>
                            <form:errors path="user_pw" style='color:red'/>
                        </div>
                        <div class="form-group">
                            <div class="text-right">
                                <form:button class="btn btn-primary">로그인</form:button>
                                <a href="${root}user/join">회원가입</a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="/WEB-INF/views/include/bottom_menu.jsp"/>

</body>
</html>