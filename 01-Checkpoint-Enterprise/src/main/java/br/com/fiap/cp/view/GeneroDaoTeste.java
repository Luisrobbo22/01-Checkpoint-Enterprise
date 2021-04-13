package main.java.br.com.fiap.cp.view;

import main.java.br.com.fiap.cp.dao.GeneroDao;
import main.java.br.com.fiap.cp.dao.impl.GeneroDaoImpl;
import main.java.br.com.fiap.cp.entity.Genero;
import main.java.br.com.fiap.cp.exception.CommitException;
import main.java.br.com.fiap.cp.singleton.EntityManagerFactorySingleton;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class GeneroDaoTeste {
	public static final Logger log = LoggerFactory.logger(UsuarioDaoTeste.class);

    public static void main(String[] args) {
        EntityManager em =
                EntityManagerFactorySingleton.getInstance().createEntityManager();

        GeneroDao dao = new GeneroDaoImpl(em);

        Genero genero = new Genero("Masculino");
        
        System.out.println("Iniciando cadastro");

        try {
            dao.create(genero);
            dao.commit();
            System.out.println("Genero registrado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Inicio leitura");
        try {
        	genero = dao.read(1);
            System.out.println(genero.getDescricao() );
        } catch (EntityNotFoundException e) {
            System.out.println("Genero nao encontrado!");
        }

        System.out.println("Inicio atualizacao");
        genero = new Genero("Feminino");	        
        try {
            dao.update(genero);
            dao.commit();
            System.out.println("Genero atualizado!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Inicio delete");
        try {
            dao.delete(1);
            dao.commit();
        } catch (EntityNotFoundException | CommitException e) {
            System.out.println(e.getMessage());
        }

        //Fechar
        em.close();
        EntityManagerFactorySingleton.getInstance().close();
    }		    
}
