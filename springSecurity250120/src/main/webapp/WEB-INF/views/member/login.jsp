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
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            if (${not empty messageType}) {
                $("#myModal").modal("show");
            }
        })
    </script>
</head>
<body>
<div class="container">
    <jsp:include page="../always/header.jsp"/>
    <div class="panel panel-default">
        <div class="panel-body">
            <form name="fr" action="${root}member/loginPro" method="post">
                <table class="table table-borderd">
                    <tr>
                        <td >아이디</td>
                        <td><input type="text" class="form-control" id="memberID" name="memberID"/></td>
                    </tr>

                    <tr>
                        <td >비밀번호</td>
                        <td>
                            <input type="password" class="form-control" name="memberPw" id="memberPw"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" class="btn btn-primary" value="로그인" style="float: right"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
