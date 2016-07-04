<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Serviço</th>
			<th>Comando</th>
			<th></th>
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
				<td><input type="button" onclick="send(this);"
					class="btn btn-primary" value="" id="btn-${service.id}"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a class="btn btn-primary" role="button"
	href="${linkTo[ServicesController].form(service.id)}">Novo</a>

<script src="<c:url value='/js/webSocketServiceStatus.js'/>"></script>

