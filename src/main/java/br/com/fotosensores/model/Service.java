package br.com.fotosensores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@Column(nullable=false)
	@NotNull
	String description;
	@Column(nullable=false)
	@NotNull
	String path;

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getPath() {
		return path;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
