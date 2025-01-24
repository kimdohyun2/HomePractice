<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>우리반 화이팅♥</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	$("button").on("click", function(e){
    		var fData=$("#frm");
    		var btn=$(this).data("btn"); // data-btn="list"
    		if(btn=='modify'){
    			fData.attr("action", "${root}/board/modify");
    		}else if(btn=='remove'){
    			fData.find("#title").remove();
    			fData.find("#content").remove();
    			fData.find("#writer").remove();
    			fData.attr("action", "${root}/board/remove");
    			fData.attr("method", "get")
    		}else if(btn=='list'){
    			fData.find("#idx").remove();
    			fData.find("#title").remove();
    			fData.find("#content").remove();
    			fData.find("#writer").remove();
    			fData.attr("action", "${root}/board/list");
    			fData.attr("method", "get")
    		}
    		fData.submit();    		
    	});    	
    });
  </script>
</head>
<body>

  <div class="card">
    <div class="card-header">
	    <div class="jumbotron jumbotron-fluid">
		  <div class="container">
		    <h1>화이팅♥</h1>
		  </div>
		</div>
    </div>
    <div class="card-body">
		<div class="row">
		  <div class="col-lg-2">
		    <jsp:include page="left.jsp"/>
		  </div>
		  <div class="col-lg-7">
		         <form id="frm" method="post">
      <table class="table table-bordered">
         <tr>
          <td>번호</td>
          <td><input type="text" class="form-control" name="idx" readonly="readonly" value="${vo.idx}"/></td>
         </tr>
         <tr>
          <td>제목</td>
          <td><input type="text" class="form-control" name="title" value="<c:out value='${vo.title}'/>"/></td>          
         </tr>
         <tr>
          <td>내용</td>
          <td><textarea rows="10" class="form-control" name="content"><c:out value='${vo.content}'/></textarea> </td>
         </tr>
         <tr>
          <td>작성자</td>
          <td><input type="text" class="form-control" name="writer" readonly="readonly" value="${vo.writer}"/></td>
         </tr>
         <tr>
           <td colspan="2" style="text-align: center;">
              <c:if test="${!empty mem && mem.memberID eq vo.memberID}">
                <button type="button" data-btn="modify" class="btn btn-sm btn-primary">수정</button>
                <button type="button" data-btn="remove" class="btn btn-sm btn-warning">삭제</button> 
              </c:if>
              <c:if test="${empty mem || mem.memberID ne vo.memberID}">
                <button disabled="disabled" type="button" class="btn btn-sm btn-primary">수정</button>
                <button disabled="disabled" type="button" class="btn btn-sm btn-warning">삭제</button> 
              </c:if>
              <button type="button" data-btn="list" class="btn btn-sm btn-info">목록</button>
           </td>
         </tr>
      </table>
          <input type="hidden" name="page" value="<c:out value='${cri.page}'/>"/>
          <input type="hidden" name="perPageNum" value="<c:out value='${cri.perPageNum}'/>"/>
          <input type="hidden" name="type" value="<c:out value='${cri.type}'/>"/>
          <input type="hidden" name="keyword" value="<c:out value='${cri.keyword}'/>"/>
      </form>
		  </div>
		   <div class="col-lg-3">
		    <jsp:include page="right.jsp"/>
		  </div> 
		</div>
    </div>
  </div>
</body>
</html>
