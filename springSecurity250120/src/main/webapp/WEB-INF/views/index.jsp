<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </script>
<%--    <script>--%>
<%--        $(document).ready(function () {--%>
<%--            if (${not empty messageType}) {--%>
<%--                $("#myModal2").modal("show");--%>
<%--            }--%>
<%--        })--%>
<%--    </script>--%>
</head>
<body>
<div class="container">
    <jsp:include page="always/header.jsp"/>

    <div class="panel panel-default">
        <div class="panel-body">
            <!-- Navigation Tabs -->
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#tab1">Tab 1</a></li>
                <!--<li><a data-toggle="tab" href="#tab2">Tab 2</a></li>-->
            </ul>

            <!-- Tab Content -->
            <div class="tab-content">
                <div id="tab1" class="tab-pane fade in active">
                    <img src="${root}resources/img/testImg.png">
                </div>
                <div id="tab2" class="tab-pane fade">
                    <h3>Tab 2</h3>
                    <p>This is the content of Tab 2.</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>