<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div id = "searchBox">
		<select id = "searchType">
			<option>--------------------------</option>
			<option ${scri.searchType == 'i'? 'selected':'' } value = "i">ID</option>
			<option ${scri.searchType == 'n'? 'selected':'' } value = "n">NAME</option>
			<option ${scri.searchType == 'e'? 'selected':'' } value = "e">E-mail</option>
			<option ${scri.searchType == 't'? 'selected':'' } value = "t">TEL</option>
			<option ${scri.searchType == 'in'? 'selected':'' } value = "in">ID or NAME</option>
			<option ${scri.searchType == 'ie'? 'selected':'' } value = "ie">ID or E-mail</option>
			<option ${scri.searchType == 'it'? 'selected':'' } value = "it">ID or TEL</option>
			<option ${scri.searchType == 'inet'? 'selected':'' } value = "inet">ID or NAME or E-mail or TEL</option>
		</select>
		<input type = "text" id = "keyword" value="${scri.keyword }">
		<button id ="btnSearch">SEARCH</button>
		<button id = "btnImageRegist">New IMAGE</button>
	</div>
	<div id ="listBody">
		<ul id= "list">
			<c:forEach var = "item" items="${list }">
				<li>
					<img>
					<p>${item.userid.userid }</p>
					<p>${item.fullname }
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class = "pageBox">
		<ul class = "pagination">
			<c:if test="${pageMaker.prev==true }">
				<li>
					<a href = "listPage?page=${pageMaker.startPage-1 }">&#8882;</a>
				</li>
			</c:if>
			<c:if test = "${pageMaker.prev == false }">
				<li>
					<a href = "#">&#8938;</a>
				</li>
			</c:if>
			<c:forEach begin = "${pageMaker.startPage }" end = "${pageMaker.endPage }" var = "idx">
				<li ${idx==pageMaker.cri.page ? 'class=active':'' }>
					<a href = "listPage?page=${idx }">${idx }</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next==true }">
				<li>
					<a href = "listPage?page=${pageMaker.endPage+1 }">&#8883;</a>
				</li>
			</c:if>
			<c:if test = "${pageMaker.next == false }">
				<li>
					<a href = "#">&#8939;</a>
				</li>
			</c:if>
		</ul>
	</div>
</section>
<script>
	$("#btnSearch").click(function(){
		var type = $("#searchType").val();
		var keyword = $("#keyword").val();
		location.href = "listAll?searchType="+type+"&keyword="+keyword;
	})
	$("#btnRegister").click(function(){
		location.href = "imageRegist";
	})
</script>
<%@ include file="../include/footer.jsp"%>