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

        })

        function previewImage() {
            const file = document.getElementById("memberProfile").files[0];  // 선택된 파일을 가져옵니다.

            if (file) {
                const reader = new FileReader();

                reader.onload = function(e) {
                    const image = document.createElement('img');  // 이미지를 동적으로 생성합니다.
                    image.src = e.target.result;  // 미리보기 이미지의 소스는 파일 내용을 사용합니다.
                    image.alt = 'Selected Image';
                    image.style.maxWidth = '300px';  // 이미지 크기 조정 (필요시)
                    image.style.maxHeight = '300px';  // 이미지 크기 조정 (필요시)

                    const previewContainer = document.getElementById('imagePreview');
                    previewContainer.innerHTML = '';  // 이전 미리보기 내용을 비웁니다.
                    previewContainer.appendChild(image);  // 새로운 이미지 미리보기를 추가합니다.
                };

                reader.readAsDataURL(file);  // 선택된 파일을 읽어서 data URL로 변환합니다.
            }
        }

        function uploadImg(){
            document.forms["fr"].submit();
        }
    </script>
    <style>
        img {
            width : 140px;
            height : 180px;
        }
    </style>
</head>
<body>
<div class="container">
    <jsp:include page="../always/header.jsp"/>
    <div class="panel panel-default">
        <div class="panel-body">
            <form name="fr" action="${root}member/imageRegist" method="post" enctype="multipart/form-data">
                <table class="table table-borderd">
                    <tr>
                        <td>아이디</td>
                        <td>
                            <input type="text" class="form-control" id="memberID" name="memberID" value="${loginMemSession.memberID}" readonly/>
                        </td>

                    </tr>
                    <tr>
                        <td>사진 업로드</td>
                        <td>
                            <div id="imagePreview" style="margin-top: 20px;">
                                <c:choose>
                                    <c:when test="${not empty loginMemSession.memberProfile}">
                                        <img src="${root}resources/img/${loginMemSession.memberProfile}">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${root}resources/img/defaultImage.webp">
                                    </c:otherwise>
                                </c:choose>
                            </div><br>
                            <input type="file" id="memberProfile" name="memberProfile" accept="image/*" value="사진 선택" onchange="previewImage()">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="button" class="btn btn-primary" value="사진업로드" style="float: right" onclick="uploadImg()"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
