package ricksciascia.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
//NOTAZIONE OBBLIGATORIA, è OBBLIGATORIO SEGNALARE CHE è UN ENTITY altrimenti Hibernate non può creare la tabella in DB
// (a patto che abbiamo messo opzione <property name="hibernate.hbm2ddl.auto" value="update"/> nel persistence.xml
@Table(name="evento") // NOTAZIONE facoltativa per cambiare nome alla tabella
public class Evento {
    @Id // NOTAZIONE OBBLIGATORIA, devo dichiarare qual'è la PrimaryKey di questa tabella che verrà creata
    @GeneratedValue(strategy = GenerationType.IDENTITY) // opzionale ma consigliata delego il DB a generare l ID
    private long id;
    @Column(name = "titolo_evento",nullable = false, length = 30)
    private String titolo;
    @Column(name="data_evento",nullable = false)
    private LocalDate dataEvento;
    @Column(name="descrizione",nullable = false, length = 300)
    private String descrizione;
    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING) // serve per gli enum se non vogliamo che siano convertiti in smallint come formato in DB
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti", nullable = false)
    private int numeroMassimoPartecipanti;

    public Evento() {}
//    RICORDARSI SEMPRE DI METTERE COSTRUTTORE VUOTO PER TUTTE LE ENTITIES IN QUANTO VERRÀ USATO DA JPA per CREARE GLI OGGETTI in LETTURA DA DB

//    COSTRUTTORE custom
    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
//    GETTER E SETTER come al solito


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public long getId() {
        return id;
    }

}
