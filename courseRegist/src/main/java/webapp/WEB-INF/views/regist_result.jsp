<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<script>
    <c:choose>
    <c:when test="${suc}">
        alert("수강신청 성공!")
    </c:when>
    <c:otherwise>
        alert("수강신청 실패!")
    </c:otherwise>
    </c:choose>

    location.href = '${root}menu'
</script>