package main.java.br.com.fiap.cp.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

    // 1 - Atributo estático que armazena a única instância
    private static EntityManagerFactory factory;

    // 2 - Método estático que retorna a única instância
    public static EntityManagerFactory getInstance() {

        //Valida se já existe a instância da fabrica
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("ORACLE");
        }
        return factory;
    }

    // 3 - Construtor privado, nenhuma classe consegue instanciar
    private EntityManagerFactorySingleton() {
    }

}

