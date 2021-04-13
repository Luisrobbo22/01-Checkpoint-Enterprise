package main.java.br.com.fiap.cp.dao.impl;


import main.java.br.com.fiap.cp.dao.GeneroDao;
import main.java.br.com.fiap.cp.entity.Genero;

import javax.persistence.EntityManager;

public class GeneroDaoImpl extends GenericDaoImpl<Genero, Integer> implements GeneroDao {

	public GeneroDaoImpl(EntityManager entityManager) {
		super(entityManager);
	} 

}
