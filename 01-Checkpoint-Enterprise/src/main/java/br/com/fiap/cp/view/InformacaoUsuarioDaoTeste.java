package main.java.br.com.fiap.cp.view;

import main.java.br.com.fiap.cp.dao.InformacaoUsuarioDao;
import main.java.br.com.fiap.cp.dao.impl.InformacaoUsuarioDaoImpl;
import main.java.br.com.fiap.cp.entity.InformacaoUsuario;
import main.java.br.com.fiap.cp.entity.pk.EstadoAndInfoUsuarioPk;
import main.java.br.com.fiap.cp.exception.CommitException;
import main.java.br.com.fiap.cp.singleton.EntityManagerFactorySingleton;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.Calendar;

public class InformacaoUsuarioDaoTeste {
    public static final Logger log = LoggerFactory.logger(InformacaoUsuarioDaoTeste.class);


    public static void main(String[] args) {
        log.info("[InformacaoUsuarioDaoTeste] - Instanciando um entity manager");
        EntityManager em =
                EntityManagerFactorySingleton.getInstance().createEntityManager();

        InformacaoUsuarioDao dao = new InformacaoUsuarioDaoImpl(em);

        log.info("[InformacaoUsuarioDaoTeste] - Cadastrando uma informacao do usuario");
        // Cadastrar
        EstadoAndInfoUsuarioPk inforUsuarioPK = new EstadoAndInfoUsuarioPk(1, 1);
        InformacaoUsuario informacaoUsuario = new InformacaoUsuario(inforUsuarioPK, Calendar.getInstance(), 1.81, 91, (91 / (1.81 * 1.81)));


//        try {
//            dao.create(informacaoUsuario);
//            dao.commit();
//        } catch (CommitException e) {
//            System.out.println(e.getMessage());
//        }

//        // Pesquisar e exibir os dados
//        try {
//            informacaoUsuario = dao.read(informacaoUsuario.getInforUsuarioPK().getIdUsuario());
//            System.out.println(informacaoUsuario.getAltura());
//
//        } catch (EntityNotFoundException e) {
//            log.error(e.getMessage());
//        }


        // Atualizar
        informacaoUsuario = new InformacaoUsuario(inforUsuarioPK, Calendar.getInstance(), 1.85, 90.0, 24.9);


        try {
            dao.update(informacaoUsuario);
            dao.commit();
            log.info("[InformacaoUsuarioDaoTeste] - Informacao do usuario atualizada");
        } catch (CommitException e) {
            log.error(e.getMessage());
        }


        // Remover
        try {
            dao.delete(1);
            dao.commit();
        } catch (EntityNotFoundException | CommitException e) {
            System.out.println(e.getMessage());
        }

        // Fechar
        em.close();
        EntityManagerFactorySingleton.getInstance().close();
        log.info("[InformacaoUsuarioDaoTeste] - Conexão fechada");


    }
}
