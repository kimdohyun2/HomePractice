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
        $(document).ready(function (){
            if("${loginMemSession.memberGender}" == "남자"){
                $("#man").attr("checked", true);
            }else{
                $("#man").attr("checked", false);
            }
        });

        function pwCheck() {
            if ($("#memberPw1").val() != $("#memberPw2").val()) {
                $("#pwChecker").css("display", "block");
                $("#memberPw").val("");
            } else {
                $("#pwChecker").css("display", "none");
                $("#memberPw").val($("#memberPw1").val());
            }
        }

        function memberUpdate() {
            if ($("#memberPw1").val() != $("#memberPw2").val()) {
                $("#modalTitle").html('잘못된 입력 정보');
                $("#idcheck").html('비밀번호가 일치하지 않습니다');
                $("#myModal").modal("show");
                return;
            }

            if ($("#memberAge").val() === "") {
                $("#memberAge").val("0");
            }
            document.forms["fr"].submit();
        }
    </script>
    <style>
        input[type="radio"] {
            pointer-events: none;
            opacity: 0.6; /* 비활성화된 느낌을 주는 스타일 */
        }
    </style>
</head>
<body>
<div class="container">
    <jsp:include page="../always/header.jsp"/>
    <div class="panel panel-default">
        <div class="panel-body">
            <form name="fr" action="${root}member/updatePro" method="post">
                <table class="table table-borderd">
                    <input type="hidden" id="memberPw" name="memberPw">
                    <tr>
                        <td>아이디</td>
                        <td>
                            <input type="text" class="form-control" id="memberID" name="memberID" value="${loginMemSession.memberID}" readonly/>
                        </td>
                    </tr>

                    <tr>
                        <td>이름</td>
                        <td><input type="text" class="form-control" id="memberName" name="memberName" value="${loginMemSession.memberName}" readonly/></td>
                    </tr>

                    <tr>
                        <td>성별</td>
                        <td>
                            <input type="radio" value="남자" name="memberGender" id="man" readonly />남자
                            <input type="radio" value="여자" name="memberGender" id="woman" readonly />여자
                        </td>
                    </tr>

                    <tr>
                        <td>비밀번호</td>
                        <td>
                            <input type="password" class="form-control" name="memberPw1" id="memberPw1"
                                   onkeyup="pwCheck()"/>
                        </td>
                    </tr>

                    <tr>
                        <td>비밀번호확인</td>
                        <td>
                            <input type="password" class="form-control" name="memberPw2" id="memberPw2"
                                   onkeyup="pwCheck()"/>
                            <span id="pwChecker" style="color: red; display: none">비밀번호와 일치하지 않습니다</span>
                        </td>
                    </tr>

                    <tr>
                        <td>나이</td>
                        <td><input type="text" class="form-control" id="memberAge" name="memberAge"/></td>
                    </tr>

                    <tr>
                        <td>이메일</td>
                        <td><input type="email" class="form-control" id="memberEmail" name="memberEmail"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="button" class="btn btn-primary" value="정보수정" style="float: right"
                                   onclick="memberUpdate()"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
