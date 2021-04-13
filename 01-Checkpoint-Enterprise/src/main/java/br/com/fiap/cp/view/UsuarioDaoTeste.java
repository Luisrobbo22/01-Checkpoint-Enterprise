package main.java.br.com.fiap.cp.view;

import main.java.br.com.fiap.cp.dao.UsuarioDao;
import main.java.br.com.fiap.cp.dao.impl.UsuarioDaoImpl;
import main.java.br.com.fiap.cp.entity.Usuario;
import main.java.br.com.fiap.cp.exception.CommitException;
import main.java.br.com.fiap.cp.singleton.EntityManagerFactorySingleton;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.Calendar;

public class UsuarioDaoTeste {
    public static final Logger log = LoggerFactory.logger(UsuarioDaoTeste.class);

    public static void main(String[] args) {
        log.info("[UsuarioDaoTeste] - Instanciando um entity manager");

        EntityManager em =
                EntityManagerFactorySingleton.getInstance().createEntityManager();

        UsuarioDao dao = new UsuarioDaoImpl(em);

        Usuario usuario = new Usuario("Luis", "luis@gmail.com", "senha", Calendar.getInstance(), "12365023", "40650840560");

        log.info("[UsuarioDaoTeste] - Instanciando Cadastro");

        try {
            dao.create(usuario);
            dao.commit();
            System.out.println("usuario registrado!");
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info("[UsuarioDaoTeste] - Instanciando Leitura");
        try {
            usuario = dao.read(1);
            System.out.println(usuario.getNome());
        } catch (EntityNotFoundException e) {
            log.error("Usuario nao encontrado! " + e.getMessage());
        }

        log.info("[UsuarioDaoTeste] - Instanciando Atualizacao");
        usuario = new Usuario(1, "Felipe", "Felipe@gmail.com", "senha2", Calendar.getInstance(), "12365023", "40650840560", null, null, null);
        try {
            dao.update(usuario);
            dao.commit();
            System.out.println("Aluno atualizado!");
        } catch (CommitException e) {
            log.error(e.getMessage());
        }


        log.info("[UsuarioDaoTeste] - Instanciando Delete");
        try {
            dao.delete(1);
            dao.commit();
        } catch (EntityNotFoundException | CommitException e) {
            log.error(e.getMessage());
        }

        log.info("[UsuarioDaoTeste] - Fechando Conexao");
        em.close();
        EntityManagerFactorySingleton.getInstance().close();

    }
}
