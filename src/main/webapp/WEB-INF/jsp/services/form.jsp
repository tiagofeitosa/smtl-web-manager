<form role="form" action="${linkTo[ServicesController].save(service)}"
	method="post">

	<input type="text" name="service.id" value="${service.id}"
		hidden="true" />

	<div class="form-group">
		<label for="description">Serviço</label> <input type="text"
			class="form-control" id="description" name="service.description"
			value="${service.description}" placeholder="meuserviço">
	</div>

	<div class="form-group">
		<label for="Comando">Comando</label> <input type="text"
			class="form-control" id="path" name="service.path"
			value="${service.path}" placeholder="service-meuservico">
	</div>

	<button type="submit" class="btn btn-primary">Salvar</button>

</form>