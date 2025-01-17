<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>

<head>
    <title>회원가입 조이고</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="${root}script/postCode.js"></script>
    <script src="${root}script/existId.js"></script>
</head>
<body style="background-color: rgba(211, 211, 211, 0.5);">
<div class="container" style="margin-top: 50px; margin-bottom: 50px">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card" style="border-radius: 10px; overflow: hidden;">
                <div class="card-header" style="background-color: rgba(173, 216, 230, 0.5); display: flex;">
                    <h2>회원가입</h2>
                </div>
                <div class="card-body">
                    <!-- Spring form:form 태그로 변환 -->
                    <form:form method="POST" action="${root}join_pro" modelAttribute="joinBean">
                        <!-- 중복확인 -->
                        <form:hidden path="existId" id="existId"/>

                        <!-- 아이디 -->
                        <div class="form-group">
                            <label for="user_id">아이디</label>
                            <div class="input-group">
                                <form:input path="user_id" class="form-control" id="user_id" readonly="false"/>
                                <div class="input-group-append">
                                    <button type="button" class="btn btn-primary" onclick="chexistId()" id="chexistBtn"
                                            style="width: 120px; border-radius: 0 5px 5px 0">중복확인
                                    </button>
                                    <button type="button" class="btn btn-warning" onclick="updateId()" id="updateIdBtn"
                                            style="width: 120px; display: none">아이디수정
                                    </button>
                                </div>
                            </div>
                            <form:errors path="user_id" style='color:red'/>
                        </div>

                        <!-- 비밀번호 -->
                        <div class="form-group">
                            <label for="user_pw">비밀번호</label>
                            <form:input type="password" path="user_pw" class="form-control"/>
                            <form:errors path="user_pw" style='color:red'/>
                        </div>

                        <!-- 비밀번호 확인 -->
                        <div class="form-group">
                            <label for="user_pw2">비밀번호 확인</label>
                            <form:input type="password" path="user_pw2" class="form-control"/>
                            <form:errors path="user_pw2" style='color:red'/>
                        </div>

                        <!-- 이름 -->
                        <div class="form-group">
                            <label for="user_name">이름</label>
                            <form:input path="user_name" class="form-control" id="user_name"/>
                            <form:errors path="user_name" style='color:red'/>
                        </div>

                        <!-- 성별 -->
                        <div class="form-group">
                            <label>성별</label><br>
                            <form:radiobutton path="user_gender" value="M" label="남"/>
                            <form:radiobutton path="user_gender" value="F" label="여"/><br>
                            <form:errors path="user_gender" style='color:red'/>
                        </div>

                        <!-- 생년월일 -->
                        <div class="form-group">
                            <label for="user_birthday">생년월일</label>
                            <form:input type="date" path="user_birthday" class="form-control"/>
                            <form:errors path="user_birthday" style='color:red'/>
                        </div>

                        <!-- 이메일 -->
                        <div class="form-group">
                            <label for="user_email">Email</label>
                            <form:input type="email" path="user_email" class="form-control"/>
                            <form:errors path="user_email" style='color:red'/>
                        </div>

                        <!-- 우편번호 -->
                        <div class="form-group">
                            <label for="user_postcode">주소</label>
                            <div class="input-group">
                                <form:input type="text" path="user_postcode" class="form-control" placeholder="우편번호"
                                            id="zipcode"/>
                                <div class="input-group-append">
                                    <button type="button" class="btn btn-info" onclick="postcode()">우편번호 찾기</button>
                                </div>
                            </div>
                            <form:errors path="user_postcode" style='color:red'/>
                        </div>

                        <!-- 주소 -->
                        <div class="form-group">
                            <form:input path="user_address" class="form-control" placeholder="주소" id="address"/>
                            <form:errors path="user_address" style='color:red'/>
                        </div>

                        <!-- 상세 주소 -->
                        <div class="form-group">
                            <form:input path="user_d_address" class="form-control" placeholder="상세주소"
                                        id="detailAddress"/>
                            <form:errors path="user_d_address" style='color:red'/>
                        </div>

                        <!-- 취미 -->
                        <div class="form-group">
                            <label>취미</label><br>
                            <form:checkbox path="user_hobby" value="인터넷" label="인터넷"/>
                            <form:checkbox path="user_hobby" value="여행" label="여행"/>
                            <form:checkbox path="user_hobby" value="게임" label="게임"/>
                            <form:checkbox path="user_hobby" value="영화" label="영화"/>
                            <form:checkbox path="user_hobby" value="운동" label="운동"/>
                            <form:checkbox path="user_hobby" value="자기" label="자기"/><br>
                            <form:errors path="user_hobby" style='color:red'/>
                        </div>

                        <!-- 직업 -->
                        <div class="form-group">
                            <label for="user_job">직업</label>
                            <form:select path="user_job" class="form-control">
                                <form:option value="학생" label="학생"/>
                                <form:option value="직장인" label="직장인"/>
                                <form:option value="자영업" label="자영업"/>
                                <form:option value="실업자" label="실업자"/>
                            </form:select>
                            <form:errors path="user_job" style='color:red'/>
                        </div>

                        <!-- 버튼들 -->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">회원가입</button>
                            <button type="reset" class="btn btn-secondary">다시쓰기</button>
                            <a href="${root}login" class="btn btn-secondary" style="float: right">로그인</a>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        if($('#existId').val() === "false"){
            $("#user_id").attr("readonly", true)
            $("#chexistBtn").css("display", "none");
            $("#updateIdBtn").css("display", "inline-block");
        }else{
            $("#user_id").attr("readonly", false)
            $("#chexistBtn").css("display", "inline-block");
            $("#updateIdBtn").css("display", "none");
        }
    });
</script>
</body>
</html>
