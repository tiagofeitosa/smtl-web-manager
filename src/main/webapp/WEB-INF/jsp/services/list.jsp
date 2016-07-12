<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-striped">
	<thead>
		<tr>
			<th class="text-center">Serviço</th>
			<th class="text-center">Comando</th>
			<th></th>
			<th></th>
			<th class="text-center">Iniciar com o sistema</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="service" items="${services}">
			<tr>
				<td class="text-center">${service.description}</td>
				<td class="text-center">${service.path}</td>
				<td class="text-center"><a href="${linkTo[ServicesController].form(service.id)}">editar</a></td>
				<td class="text-center"><a href="${linkTo[ServicesController].remove(service.id)}">remover</a></td>
				<td class="text-center">
					<input type="checkbox" data-toggle="toggle"
						<c:if test="${service.sysIni == true}">
   							checked
						</c:if>
					onchange="startup(this, ${service.id});"></td>
				<td class="text-center"><input type="button" onclick="send(this);" class="btn btn-primary" value=""	id="btn-${service.id}"></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td class="text-center"><a class="btn btn-primary" role="button" href="${linkTo[ServicesController].form(service.id)}">Novo</a></td>
		</tr>
	</tfoot>
</table>

<script src="<c:url value='/js/webSocketServiceStatus.js'/>"></script>
<script type="text/javascript">
function startup(chkBox, id) {
	$.ajax("/smtl-web-manager/services/list/" + id + "/" + (chkBox.checked ? true : false));
	// $.ajax("/manager/services/list/" + id + "/" + (chkBox.checked ? true : false));
}
</script>
