<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
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
                    <div class="form-group">
                        <label for="board_writer_name">글쓴이</label>
                        <input type="text" value="${readContent.content_writer_name}" disabled="disabled"
                               class="form-control" id="board_writer_name" name="board_writer_name"/>
                    </div>

                    <div class="form-group">
                        <label for="board_date">작성날짜</label>
                        <input type="text" value="${readContent.content_date}" disabled="disabled"
                               class="form-control" id="board_date" name="board_date"/>
                    </div>

                    <div class="form-group">
                        <label for="board_subject">제목</label>
                        <input type="text" value="${readContent.content_subject}" disabled="disabled"
                               class="form-control" id="board_subject" name="board_subject"/>
                    </div>

                    <div class="form-group">
                        <label for="board_content">내용</label>
                        <textarea disabled="disabled" class="form-control" id="board_content" name="board_content" rows="10">${readContent.content_text}</textarea>
                    </div>


                    <div class="form-group">
                        <div class="text-right">
                            <a class="btn btn-primary"
                               href="${root}board/main?board_info_idx=${readContent.content_board_idx}&page=${page}">목록</a>

                            <!--글 작성한 사람과 로그인한 사람이 다르면 수정, 삭제 안뜬다 -->
                            <c:if test="${loginBean.user_idx == readContent.content_writer_idx}">
                                <a class="btn btn-info"
                                   href="${root}board/modify?content_idx=${readContent.content_idx}&page=${page}">수정</a>
                                <a class="btn btn-danger"
                                   href="${root}board/delete?content_idx=${readContent.content_idx}&board_info_idx=${readContent.content_board_idx}&page=${page}">삭제</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


    <c:import url="/WEB-INF/views/include/bottom_menu.jsp"/>

</body>
</html>