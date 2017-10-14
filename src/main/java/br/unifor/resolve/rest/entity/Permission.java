package br.unifor.resolve.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "permissions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Permission implements Serializable {

	private static final long serialVersionUID = -6331748582983397498L;

	public Permission() {

	}

	public Permission(String id) {
        this.id = Long.valueOf(id);
	}

	public Permission(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissions_seq_gen")
	@SequenceGenerator(name = "permissions_seq_gen", sequenceName = "permissions_id_seq")
	private Long id;

	@Column(nullable = false,unique = true)
	private String name;

	/* getters and setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}