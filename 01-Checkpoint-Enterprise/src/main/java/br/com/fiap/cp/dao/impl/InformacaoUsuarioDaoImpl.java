package main.java.br.com.fiap.cp.dao.impl;


import main.java.br.com.fiap.cp.dao.InformacaoUsuarioDao;
import main.java.br.com.fiap.cp.entity.InformacaoUsuario;

import javax.persistence.EntityManager;

public class InformacaoUsuarioDaoImpl extends GenericDaoImpl<InformacaoUsuario, Integer> implements InformacaoUsuarioDao {

    public InformacaoUsuarioDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
