package main.java.br.com.fiap.cp.dao.impl;


import main.java.br.com.fiap.cp.dao.EstadoDao;
import main.java.br.com.fiap.cp.entity.Estado;

import javax.persistence.EntityManager;

public class EstadoDaoImpl extends GenericDaoImpl<Estado, Integer> implements EstadoDao {

    public EstadoDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
