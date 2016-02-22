<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Release Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Release
</h1>

<c:url var="addAction" value="/gftrelease/add" ></c:url>

<form:form action="${addAction}" commandName="gftrelease">
<table>
	<c:if test="${!empty gftrelease.releaseName}">
	<tr>
		<td>
			<form:label path="releaseId">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="releaseId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="releaseId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="releaseName">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="releaseName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="releaseDescription">
				<spring:message text="releaseDescription"/>
			</form:label>
		</td>
		<td>
			<form:input path="releaseDescription" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty gftrelease.releaseName}">
				<input type="submit"
					value="<spring:message text="Edit release"/>" />
			</c:if>
			<c:if test="${empty gftrelease.releaseName}">
				<input type="submit"
					value="<spring:message text="Add release"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>releases List</h3>
<c:if test="${!empty listGftReleases}">
	<table class="tg">
	<tr>
		<th width="80">Release ID</th>
		<th width="120">Release Name</th>
		<th width="120">release Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listGftReleases}" var="release">
		<tr>
			<td>${release.releaseId}</td>
			<td>${release.releaseName}</td>
			<td>${release.releaseDescription}</td>
			<td><a href="<c:url value='/gftrelease/edit/${release.releaseId}' />" >Edit</a></td>
			<td><a href="<c:url value='/gftrelease/remove/${release.releaseId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
