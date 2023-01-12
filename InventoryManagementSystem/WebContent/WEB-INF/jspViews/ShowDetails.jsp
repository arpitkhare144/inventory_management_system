<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Show Details</h2>
		<c:choose>
			<c:when test="${not empty purchase}">
				<table border="1">
					<tr>
						<th>Purchase Id</th>
						<th>Transaction Id</th>
						<th>vendor Name</th>
						<th>Material CategoryId</th>
						<th>Purchase Date</th>
						<th>Purchase Amount</th>
					</tr>
					<c:forEach var="purchase" items="${purchase}">
						<tr>
							<td align="right">${purchase.purchaseId}</td>
							<td align="center">${purchase.transactionId}</td>
							<td align="center">${purchase.vendorName}</td>
							<td align="center">${purchase.materialCategoryId}</td>
							<td align="center"><fmt:formatDate pattern="dd-MMM-yyyy"
									value="${purchase.purchaseDate}" /></td>
							<td align="right">${purchase.purchaseAmount}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h3>No records Found</h3>
			</c:otherwise>
		</c:choose>

		<br>
		<br>
		<a href="${pageContext.request.contextPath}/index.jsp">HOME</a>
	</center>
</body>
</html>