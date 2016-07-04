package br.com.fotosensores.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fotosensores.dao.ServiceDAO;
import br.com.fotosensores.model.Service;

/**
 * @author tiago
 *
 */

@Controller
public class ServicesController {

	@Inject
	private ServiceDAO dao;
	
	@Inject
	private Result result;

	@Inject
	private Validator validation;

	@Post("/services/save")
	public void save(@NotNull @Valid Service service) {
	
		validation.onErrorRedirectTo(this).form(null);
		
		if (service.getId() == null) {
			dao.save(service);
		} else {
			dao.update(service);
		}
		
		result.redirectTo(this).list();
	}

	@Path({"/services/form/{id}", "/services/form/"})
	public void form(Long id) {
		
		Service service;
		
		if (id != null) {
			service = dao.findById(id);
			result.include("service", service);
		}
	}

	@Path("/services/remove/{id}")
	public void remove(Long id) {
		dao.remove(id);
		result.redirectTo(this).list();
	}

	@Path("/services/list")
	public void list() {
		List<Service> services = dao.listAll();
		result.include("services", services);		
	}
}
