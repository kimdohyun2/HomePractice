<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<script>
    alert("게시글이 수정되었습니다")
    location.href="${root}board/read?board_info_idx=${modifyBean.content_board_idx}&content_idx=${modifyBean.content_idx}&page=${page}"
</script>