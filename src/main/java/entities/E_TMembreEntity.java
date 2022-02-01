package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_membre", schema = "sel", catalog = "")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_MEMBRE", discriminatorType = DiscriminatorType.STRING)
public abstract class E_TMembreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MEMBRE")
    private int idMembre;
    @Basic
    @Column(name = "NOM_MEMBRE")
    private String nomMembre;
    @Basic
    @Column(name = "PRENOM_MEMBRE")
    private String prenomMembre;
    @Basic
    @Column(name = "MAIL_MEMBRE")
    private String mailMembre;
    @Basic
    @Column(name = "STATUT")
    private String statut;
    @Basic
    @Column(name = "SOLDE_HEURE")
    private int soldeHeure;
    @Basic
    @Column(name = "SOLDE_ECU")
    private int soldeEcu;

    @Basic
    @Column(name = "HABITANT")
    private Integer habitant;
    @Basic
    @Column(name = "RAISON_SOCIALE")
    private String raisonSociale;
    @Basic
    @Column(name = "CLIENT_COMPTE_ECU")
    private int clientCompteEcu;


    @OneToMany(mappedBy = "tMembreByIdMembre")
    private Collection<E_TCotisationsEntity> tCotisationsByIdMembre;
    @OneToMany(mappedBy = "tMembreByIdMembre")
    private Collection<E_TOperationChangeEntity> tOperationChangesByIdMembre;
    @OneToMany(mappedBy = "tMembreByIdMembreDebiteur")
    private Collection<E_TOperationEcuEntity> tOperationEcusByIdMembre;
    @OneToMany(mappedBy = "tMembreByIdMembreCrediteur")
    private Collection<E_TOperationEcuEntity> tOperationEcusByIdMembre_0;

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public String getMailMembre() {
        return mailMembre;
    }

    public void setMailMembre(String mailMembre) {
        this.mailMembre = mailMembre;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getSoldeHeure() {
        return soldeHeure;
    }

    public void setSoldeHeure(int soldeHeure) {
        this.soldeHeure = soldeHeure;
    }

    public int getSoldeEcu() {
        return soldeEcu;
    }

    public void setSoldeEcu(int soldeEcu) {
        this.soldeEcu = soldeEcu;
    }


    public Integer getHabitant() {
        return habitant;
    }

    public void setHabitant(Integer habitant) {
        this.habitant = habitant;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public int getClientCompteEcu() {
        return clientCompteEcu;
    }

    public void setClientCompteEcu(int clientCompteEcu) {
        this.clientCompteEcu = clientCompteEcu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof E_TMembreEntity)) return false;
        E_TMembreEntity that = (E_TMembreEntity) o;
        return idMembre == that.idMembre && soldeHeure == that.soldeHeure && soldeEcu == that.soldeEcu && clientCompteEcu == that.clientCompteEcu && Objects.equals(nomMembre, that.nomMembre) && Objects.equals(prenomMembre, that.prenomMembre) && Objects.equals(mailMembre, that.mailMembre) && Objects.equals(statut, that.statut) && Objects.equals(habitant, that.habitant) && Objects.equals(raisonSociale, that.raisonSociale) && Objects.equals(tCotisationsByIdMembre, that.tCotisationsByIdMembre) && Objects.equals(tOperationChangesByIdMembre, that.tOperationChangesByIdMembre) && Objects.equals(tOperationEcusByIdMembre, that.tOperationEcusByIdMembre) && Objects.equals(tOperationEcusByIdMembre_0, that.tOperationEcusByIdMembre_0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMembre, nomMembre, prenomMembre, mailMembre, statut, soldeHeure, soldeEcu, habitant, raisonSociale, clientCompteEcu, tCotisationsByIdMembre, tOperationChangesByIdMembre, tOperationEcusByIdMembre, tOperationEcusByIdMembre_0);
    }

    public Collection<E_TCotisationsEntity> gettCotisationsByIdMembre() {
        return tCotisationsByIdMembre;
    }

    public void settCotisationsByIdMembre(Collection<E_TCotisationsEntity> tCotisationsByIdMembre) {
        this.tCotisationsByIdMembre = tCotisationsByIdMembre;
    }

    public Collection<E_TOperationChangeEntity> gettOperationChangesByIdMembre() {
        return tOperationChangesByIdMembre;
    }

    public void settOperationChangesByIdMembre(Collection<E_TOperationChangeEntity> tOperationChangesByIdMembre) {
        this.tOperationChangesByIdMembre = tOperationChangesByIdMembre;
    }

    public Collection<E_TOperationEcuEntity> gettOperationEcusByIdMembre() {
        return tOperationEcusByIdMembre;
    }

    public void settOperationEcusByIdMembre(Collection<E_TOperationEcuEntity> tOperationEcusByIdMembre) {
        this.tOperationEcusByIdMembre = tOperationEcusByIdMembre;
    }

    public Collection<E_TOperationEcuEntity> gettOperationEcusByIdMembre_0() {
        return tOperationEcusByIdMembre_0;
    }

    public void settOperationEcusByIdMembre_0(Collection<E_TOperationEcuEntity> tOperationEcusByIdMembre_0) {
        this.tOperationEcusByIdMembre_0 = tOperationEcusByIdMembre_0;
    }

    public E_TMembreEntity(String nomMembre, String prenomMembre, String mailMembre, String statut) {
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
        this.mailMembre = mailMembre;
        this.statut = statut;
    }

    public E_TMembreEntity() {
    }
}


