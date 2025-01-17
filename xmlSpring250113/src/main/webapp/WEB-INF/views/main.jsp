<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            loadList();
        });

        function loadList() {
            $.ajax({
                url: "board/all",
                type: "get",
                dataType: "json",
                success: make,
                error: function () {
                    alert("error");
                }
            });
        }

        function make(data) {
            let listHtml = "<table class='table table-bordered'>";
            listHtml += "<tr>";
            listHtml += "<th>번호</th>";
            listHtml += "<th>제목</th>";
            listHtml += "<th>작성자</th>";
            listHtml += "<th>작성일</th>";
            listHtml += "<th>조회수</th>";
            listHtml += "</tr>";

            $.each(data, function (index, obj) { // obj={"idx":5,"title":"게시판"~~ }
                listHtml += "<tr>";
                listHtml += "<td>" + obj.idx + "</td>";
                listHtml += "<td id='t" + obj.idx + "'><a href='javascript:goContent(" + obj.idx + ")'>" + obj.title + "</a></td>";
                listHtml += "<td>" + obj.writer + "</td>";
                listHtml += "<td>" + obj.indate.split(' ')[0] + "</td>";
                listHtml += "<td id='cnt" + obj.idx + "'>" + obj.count + "</td>";
                listHtml += "</tr>";

                listHtml += "<tr id='c" + obj.idx + "' style='display:none'>";
                listHtml += "<td>내용</td>";
                listHtml += "<td colspan='4'>";
                listHtml += "<textarea id='ta" + obj.idx + "' readonly rows='7' class='form-control'>" + obj.content + "</textarea>";
                listHtml += "<br/>";
                listHtml += "<span id='ub" + obj.idx + "'><button class='btn btn-success btn-sm' onclick='goUpdateForm(" + obj.idx + ")'>수정화면</button></span>&nbsp;";
                listHtml += "<button class='btn btn-danger btn-sm' onclick='goDelete(" + obj.idx + ")'>삭제</button>";
                listHtml += "</td>";
                listHtml += "</tr>";

            });
            listHtml += "<tr>";
            listHtml += "<td colspan='5'>";
            listHtml += "<button class='btn btn-primary btn-sm' onclick='goForm()'>글쓰기</button>";
            listHtml += "</td>";
            listHtml += "</tr>";
            listHtml += "</table>";
            $("#view").html(listHtml);

            $("#view").css("display", "block");
            $("#wfrom").css("display", "none");
        };


        function goList() {
            $("#view").css("display", "block");
            $("#wfrom").css("display", "none");
        };

        function goForm() {
            $("#view").css("display", "none");
            $("#wfrom").css("display", "block");
        };

        function goInsert() {
            let fData = $("#frm").serialize();

            $.ajax({
                url: "board/new",
                type: "post",
                data: fData,
                dataType: "text",
                success: function (response) {
                    alert(response);
                    loadList();
                },
                error: function (xhr, status, errorThrown) {
                    alert(xhr);
                    alert(status);
                    alert(errorThrown);
                    alert(error);
                }
            });
            $("#fclear").trigger("click");
        };

        function goContent(idx) {
            if ($("#c" + idx).css("display") == "none") {

                $.ajax({
                    url: "board/"+idx,
                    type: "put",
                    success: function (res){
                        $("#cnt"+idx).html(res);
                    },
                    error: function (request, error){
                        alert(request.responseText);
                        alert(error);
                    }
                })
                $("#c" + idx).css("display", "table-row")
            } else {
                $("#c" + idx).css("display", "none");
            }
        }


        function goDelete(idx) {
            $.ajax({
                url: "board/" + idx,
                type: "delete",
                success: function (response) {
                    alert(response);
                    loadList();
                },
                error: function (request, error) {
                    alert(request.responseText);
                    alert(error);
                }
            })
        }

        function goUpdateForm(idx) {
            $("#ta" + idx).attr("readonly", false);
            let title = $("#t" + idx).text();
            let newInput = "<input type='text' id='nt" + idx + "' class='form-control' style='padding: 0; width: 100px;' value='" + title + "'/>";
            $("#t" + idx).html(newInput);

            let newButton = "<button class='btn btn-warning btn-sm' onclick='goUpdate(" + idx + ")'>수정</button>"
            $("#ub" + idx).html(newButton);
        }

        function goUpdate(idx) {
            let update = {
                "idx": idx,
                "title": $("#nt" + idx).val(),
                "content": $("#ta" + idx).val()
            };
            $.ajax({
                url: "board/update",
                type: "put",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(update),
                success: function (res) {
                    alert(res);
                    loadList();
                },
                error: function (request, error) {
                    alert(request.responseText);
                    alert(error);
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
    <jsp:include page="always/header.jsp"/>
    <h2>Spring Legacy</h2>
    <div class="panel panel-default">
        <div class="panel-heading">BOARD</div>
        <div class="panel-body" id="view">Panel Content</div>
        <div class="panel-body" id="wfrom" style="display: none">
            <form id="frm">
                <table class="table">
                    <tr>
                        <td>제목</td>
                        <td><input type="text" id="title" name="title" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td><textarea rows="7" class="form-control" id="content" name="content"></textarea></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td><input type="text" id="writer" name="writer" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="button" class="btn btn-success btn-sm" onclick="goInsert()">등록</button>
                            <button type="reset" class="btn btn-warning btn-sm" id="fclear">취소</button>
                            <button type="button" class="btn btn-info btn-sm" onclick="goList()">리스트</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
