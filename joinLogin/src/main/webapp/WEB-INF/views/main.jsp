<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>

<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery-3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script></head>
<body style="background-color: rgba(211, 211, 211, 0.5);">
<div class="container" style="margin-top: 50px; margin-bottom: 50px">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card" style="border-radius: 10px; overflow: hidden; background-color: white;">
                <div class="card-header" style="background-color: rgba(173, 216, 230, 0.5); display: flex;">
                    <h2>로그인 정보</h2>
                </div>
                <div class="card-body" style="background-color: #f8f9fa;"> <!-- card-body 배경을 지정 -->
                    <div class="user-info">
                        <label>유저번호:</label>
                        <span class="user-info-value">${loginBean.user_idx}</span>
                    </div>
                    <div class="user-info">
                        <label>아이디:</label>
                        <span class="user-info-value">${loginBean.user_id}</span>
                    </div>
                    <div class="user-info">
                        <label>이름:</label>
                        <span class="user-info-value">${loginBean.user_name}</span>
                    </div>
                    <div class="user-info">
                        <label>성별:</label>
                        <span class="user-info-value">${loginBean.user_gender}</span>
                    </div>
                    <div class="user-info">
                        <label>생년월일:</label>
                        <span class="user-info-value">${loginBean.user_birthday}</span>
                    </div>
                    <div class="user-info">
                        <label>이메일:</label>
                        <span class="user-info-value">${loginBean.user_email}</span>
                    </div>
                    <div class="user-info">
                        <label>우편번호:</label>
                        <span class="user-info-value">${loginBean.user_postcode}</span>
                    </div>
                    <div class="user-info">
                        <label>주소:</label>
                        <span class="user-info-value">${loginBean.user_address}</span>
                    </div>
                    <div class="user-info">
                        <label>상세주소:</label>
                        <span class="user-info-value">${loginBean.user_d_address}</span>
                    </div>
                    <div class="user-info">
                        <label>취미:</label>
                        <span class="user-info-value">${loginBean.user_hobby}</span>
                    </div>
                    <div class="user-info">
                        <label>직업:</label>
                        <span class="user-info-value">${loginBean.user_job}</span>
                    </div>
                    <div class="text-center">
                        <a href="${root}logout" class="btn btn-warning">로그아웃</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
