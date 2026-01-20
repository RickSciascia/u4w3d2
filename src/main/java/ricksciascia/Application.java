package ricksciascia;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2pu");
//    IMPORTANTISSIMO METTERE NOME PERSISTENCE UNIT del FILE POM altrimenti non saprà dove collegarsi!

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
