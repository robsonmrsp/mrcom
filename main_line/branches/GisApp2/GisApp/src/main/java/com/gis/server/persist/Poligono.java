package com.gis.server.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;
@Entity
@Table
public class Poligono {

	@Id
	@Column(name="poli_id")
	private Integer id;

	@Column(name="poli_nome")
	private String nome;

	@Type(type = "org.hibernatespatial.postgis.PGGeometryUserType")
	@Column(name="poli_pontos")
	private Geometry figura;

	public Poligono() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Geometry getFigura() {
		return figura;
	}

	public void setFigura(Geometry figura) {
		this.figura = figura;
	}

	public Poligono(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
}
