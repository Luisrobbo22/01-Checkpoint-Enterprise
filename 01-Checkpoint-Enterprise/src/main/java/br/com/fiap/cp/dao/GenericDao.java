package main.java.br.com.fiap.cp.dao;


import main.java.br.com.fiap.cp.exception.CommitException;

import javax.persistence.EntityNotFoundException;

public interface GenericDao<E, K> {

    void create(E entity);

    E read(K id) throws EntityNotFoundException;

    void update(E entity);

    void delete(K id) throws EntityNotFoundException;

    void commit() throws CommitException;

}
