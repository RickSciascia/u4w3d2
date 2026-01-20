package ricksciascia.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ricksciascia.entities.Evento;
import ricksciascia.exceptions.NotFoundException;

public class EventoDAO {
//DAO Data Access Object è un Design Pattern una classe che ci fa interagire con il DB
//   Le operazioni come salvare modificare leggere dei record richiede l uso del EntityManager
//   il DAO nasconde questa complessità fornendo dei metodi che andremo ad impostare in modo da nascondere tutto sotto le coperte

    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
//    METODI
//    save
    public void save(Evento newEvent){
//        1) Creare Transazione con EntityManager
        EntityTransaction transaction = entityManager.getTransaction();
//        2) iniziare transazione
        transaction.begin();
//        3) aggiungere il newEvent al PersistenceContext (memoria locale) con il metodo .persist() dell'EntityManager
        entityManager.persist(newEvent);
//        4) commit della transazione ovvero passaggio del newEvent da PersistenceContext al DB
        transaction.commit();
//        5) Log di avvenuta operazione
        System.out.println("Operazione di salvataggio evento: "+ newEvent.getTitolo()+ " avvenuta corretamente nel DB");
    };

    public Evento getById(long id) {
//        metodo .find(parametro1 = classe del elemento che stiamo cercando, parametro2 = primaryKeyDaCercare ) integrato nell EntityManager!
        Evento eventoTrovato = entityManager.find(Evento.class, id);
        if(eventoTrovato == null) throw new NotFoundException(id);
        return eventoTrovato;
    };

    public void delete(long id) {
//        1) cerco l evento (riutilizzo il metodo fatto sopra)
        Evento eventoDaCancellare = getById(id);
//        2) creo transazione con EM
        EntityTransaction transaction = entityManager.getTransaction();
//        3) apro transazione con EM
        transaction.begin();
//        4) metodo .remove del EM che andrà in PersistenceContext (memoria locale)
        entityManager.remove(eventoDaCancellare);
//        5) commit
        transaction.commit();
//        6) Log operazione
        System.out.println("L'evento con ID: "+id+" è stato eliminato dal DB!");
    };

}
