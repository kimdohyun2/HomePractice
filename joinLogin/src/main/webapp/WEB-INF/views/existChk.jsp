<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>아이디 중복 확인</title>
    <!-- Bootstrap 4 CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            max-width: 500px;
            margin-top: 100px;
            padding: 50px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .message-container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .message-container .btn {
            margin: 0 5px;
        }

        #exist_chk {
            margin: 10px 0 20px 0;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="message-container">
        <h6 id="user_id">"${user_id}"</h6>

        <h4 id="exist_chk"></h4>

        <div>
            <button class="btn btn-success" id="useIdBtn" onclick="useId()">사용하기</button>
            <button class="btn btn-secondary" onclick="useCancle()">취소</button>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $.ajax({
            url: "existChk",
            data: {user_id : "${user_id}"},
            success: function (response){
                if (response === true){
                    $("#useIdBtn").css("display", "none");
                    $("#exist_chk").text("중복된 아이디입니다");
                }else{
                    $("#useIdBtn").css("display", "inline-block");
                    $("#exist_chk").text("사용 가능한 아이디입니다");
                }
            },
            error: function (xhr,status,errorThrown){
                alert(xhr);alert(status);alert(errorThrown);
                alert(error);
            }
        });
    });

    function useId(){
        window.opener.document.querySelector("#existId").value = false;
        window.opener.document.querySelector("#user_id").setAttribute("readonly", "true");
        window.opener.document.querySelector("#chexistBtn").style.display = "none";
        window.opener.document.querySelector("#updateIdBtn").style.display = "inline-block";
        window.close()
    }

    function useCancle(){
        window.opener.document.querySelector("#user_id").value = "";
        window.close()
    }
</script>
</body>
</html>
