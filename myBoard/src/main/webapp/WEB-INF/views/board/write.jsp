<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>우리반 화이팅</title>
    <!-- Bootstrap CDN -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<body>
<c:import url="/WEB-INF/views/include/top_menu.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px">
    <div class="row">
        <div class="col-sm-3">

		</div>
        <div class="col-sm-6">
            <div class="card shadow">
                <div class="card-body">
                    <form:form action="${root}board/write_pro" method="post" modelAttribute="writeBean">
                        <form:hidden path="content_board_idx"/>
                        <div class="form-group">
                            <form:label path="content_subject">제목</form:label>
                            <form:input type="text" path="content_subject" class="form-control"/>
                            <form:errors path="content_subject" style='color:red'/>
                        </div>

                        <div class="form-group">
                            <form:label path="content_text">내용</form:label>
                            <form:textarea path="content_text" class="form-control" rows="10"/>
                            <form:errors path="content_text" style='color:red'/>
                        </div>

                        <div class="form-group">
                            <div class="text-right">
                                <button type="submit" class="btn btn-primary">작성하기</button>
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