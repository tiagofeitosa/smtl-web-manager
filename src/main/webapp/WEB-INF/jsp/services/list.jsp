<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Service</th>
			<th>Path</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="service" items="${services}">
			<tr>
				<td>${service.description}</td>
				<td>${service.path}</td>
				<td><a href="${linkTo[ServicesController].form(service.id)}">editar</a></td>
				<td><a href="${linkTo[ServicesController].remove(service.id)}">remover</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
