package com.hichem.rtibi.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employe {
	/*
	 * @TableGenerator(allocationSize = 100,table = "id_gen",pkColumnName =
	 * "gen_name",valueColumnName = "gen_val",name = "employe_gen")
	 * 
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.TABLE,generator = "employe_gen")
	 */
	@GenericGenerator(name="empl_id",strategy="com.hichem.rtibi.entities.CustomerGenerator")
	@Id
	@GeneratedValue(generator = "empl_id")
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
