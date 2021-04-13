package main.java.br.com.fiap.cp.dao.impl;


import main.java.br.com.fiap.cp.dao.UsuarioDao;
import main.java.br.com.fiap.cp.entity.Usuario;

import javax.persistence.EntityManager;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao {

    public UsuarioDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
