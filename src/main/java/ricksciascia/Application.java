package ricksciascia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ricksciascia.entities.Evento;
import ricksciascia.entities.TipoEvento;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2pu");
//    IMPORTANTISSIMO METTERE NOME PERSISTENCE UNIT del FILE POM altrimenti non saprà dove collegarsi!

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
//        oggetto che si occuperà di gestire tutte le interazioni con il DB

    Evento ev1 = new Evento("Pupo in tour", LocalDate.of(2026, 1, 20),"Incredibile di nuovo PUPO", TipoEvento.PUBBLICO,30000);
    Evento ev2 = new Evento("Pupo a S.Siro", LocalDate.of(2026, 1, 28),"Incredibile di nuovo PUPO a S.Siro", TipoEvento.PUBBLICO,50000);
    }
}
