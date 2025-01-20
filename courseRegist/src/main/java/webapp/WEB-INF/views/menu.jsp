<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
    <title>수강신청</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        .table th {
            background-color: #f8f9fa;
            text-align: center;
        }

        .table td {
            text-align: center;
            vertical-align: middle;
        }

        .btn-custom {
            padding: 2px 10px;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <!-- 로그아웃 버튼 -->
    <div class="text-right mb-3">
        <a class="btn btn-warning" href="${root}logout">로그아웃</a>
    </div>

    <!-- 강의목록 -->
    <h3 class="text-center mb-4">강의목록</h3>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>과목번호</th>
            <th>과목명</th>
            <th>학점</th>
            <th>수강인원</th>
            <th>강의요일</th>
            <th>강의시간</th>
            <th>수강신청</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${subList}" varStatus="status">
            <tr>
                <td>${item.cs_num}</td>
                <td>${item.cs_name}</td>
                <td>${item.credit}</td>
                <td>${item.cur_regi}/${item.max_regi}</td>
                <td>${item.cs_day}</td>
                <td>${item.cs_time}</td>
                <td>
                    <c:choose>
                        <c:when test="${item.cur_regi < item.max_regi}">
                            <a class="btn btn-primary btn-custom" href="${root}regist_pro?cs_num=${item.cs_num}">
                                신청
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a class="btn btn-secondary btn-custom" href="#">
                                마감
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <!-- 내 강의 목록 -->
    <h3 class="text-center mt-5 mb-4">내 강의 목록</h3>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>과목번호</th>
            <th>과목명</th>
            <th>학점</th>
            <th>수강인원</th>
            <th>강의요일</th>
            <th>강의시간</th>
            <th>수강신청</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${mySublist}">
            <tr>
                <td>${course.cs_num}</td>
                <td>${course.cs_name}</td>
                <td>${course.credit}</td>
                <td>${course.cur_regi}/${course.max_regi}</td>
                <td>${course.cs_day}</td>
                <td>${course.cs_time}</td>
                <td>
                    <a class="btn btn-danger btn-custom" href="${root}delete_pro?cs_num=${course.cs_num}">
                        취소
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>