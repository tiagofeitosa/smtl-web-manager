<form role="form" action="${linkTo[ServicesController].save(service)}" method="post">
  <input type="text" name="service.id" value="${service.id}" hidden="true" />
  <div class="form-group">
    <label for="description">Name</label>
    <input type="text" class="form-control" id="description" name="service.description" value="${service.description}" placeholder="Nome do serviço" >
  </div>
  <div class="form-group">
    <label for="path">Path</label>
    <input type="text" class="form-control" id="path" name="service.path" value="${service.path}" placeholder="/opt/services/service-meuservico" >
  </div>
  <button type="submit" class="btn btn-default">Salvar</button>
</form>