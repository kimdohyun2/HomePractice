<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script>

        function doubleCheck() {
            let memberID = $("#memberID").val();
            $.ajax({
                url: "${root}/member/doubleCheck",
                type: "get",
                data: {"memberID": memberID},
                success: function (result) {
                    if (result == 1) {
                        $("#modalTitle").html('아이디 중복체크');
                        $("#idcheck").html('사용할 수 있는 아이디이다');
                    } else {
                        $("#idcheck").html('사용할 수 없는 아이디이다');
                    }
                    $("#myModal").modal("show");
                },
                error: function (request, error) {
                    console.log(request.responseText);
                    console.log(error);
                }
            })
        }

        function pwCheck() {
            if ($("#memberPw1").val() != $("#memberPw2").val()) {
                $("#pwChecker").css("display", "block");
                $("#memberPw").val("");
            } else {
                $("#pwChecker").css("display", "none");
                $("#memberPw").val($("#memberPw1").val());
            }
        }

        function memberRegist() {
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
<body>
<div class="container">
    <jsp:include page="../always/header.jsp"/>
    <div class="panel panel-default">
        <div class="panel-body">
            <form name="fr" action="${root}member/register" method="post">
                <table class="table table-borderd">
                    <input type="hidden" id="memberPw" name="memberPw">
                    <tr>
                        <td>아이디</td>
                        <td>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" id="memberID" name="memberID"/>
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-primary" onclick="doubleCheck()">중복확인</button>
                                </span>
                            </div>
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
                        <td>이름</td>
                        <td><input type="text" class="form-control" id="memberName" name="memberName"/></td>
                    </tr>

                    <tr>
                        <td>나이</td>
                        <td><input type="text" class="form-control" id="memberAge" name="memberAge"/></td>
                    </tr>

                    <tr>
                        <td>성별</td>
                        <td>
                            <input type="radio" value="남자" name="memberGender"/>남자
                            <input type="radio" value="여자" name="memberGender"/>여자
                        </td>
                    </tr>

                    <tr>
                        <td>이메일</td>
                        <td><input type="email" class="form-control" id="memberEmail" name="memberEmail"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="button" class="btn btn-primary" value="회원등록" style="float: right"
                                   onclick="memberRegist()"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>