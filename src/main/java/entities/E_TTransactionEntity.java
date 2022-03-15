package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "t_transaction", schema = "sel", catalog = "")

@NamedQueries({
        @NamedQuery(name="Find_transaction_user", query="SELECT e from E_TTransactionEntity e, E_TMembreEntity m where e.idMembreBeneficiaire = m.id and m.nomMembre=?1 and m.prenomMembre=?2"),
        @NamedQuery(name="Sum_transaction_user", query="SELECT SUM(t.montantTransaction) from E_TTransactionEntity t where t.dateValidation between ?1 and ?2")
         })

public class E_TTransactionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TRANSACTION")
    private int idTransaction;
    @Basic
    @Column(name = "DATE_CREATION")
    private Date dateCreation;
    @Basic
    @Column(name = "ETAT")
    private String etat;
    @Basic
    @Column(name = "DATE_VALIDATION")
    private Date dateValidation;
    @Basic
    @Column(name = "ID_PROPOSITION")
    private int idProposition;
    @Basic
    @Column(name = "MONTANT_TRANSACTION")
    private int montantTransaction;
    @Basic
    @Column(name = "ID_MEMBRE_BENEFICIAIRE")
    private int idMembreBeneficiaire;
    @Basic
    @Column(name = "MONTANT_ECU")
    private int montantEcu;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public int getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(int idProposition) {
        this.idProposition = idProposition;
    }

    public int getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(int montantTransaction) {
        this.montantTransaction = montantTransaction;
    }

    public int getIdMembreBeneficiaire() {
        return idMembreBeneficiaire;
    }

    public void setIdMembreBeneficiaire(int idMembreBeneficiaire) {
        this.idMembreBeneficiaire = idMembreBeneficiaire;
    }

    public int getMontantEcu() {
        return montantEcu;
    }

    public void setMontantEcu(int montantEcu) {
        this.montantEcu = montantEcu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_TTransactionEntity that = (E_TTransactionEntity) o;
        return idTransaction == that.idTransaction && idProposition == that.idProposition && montantTransaction == that.montantTransaction && idMembreBeneficiaire == that.idMembreBeneficiaire && montantEcu == that.montantEcu && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(etat, that.etat) && Objects.equals(dateValidation, that.dateValidation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaction, dateCreation, etat, dateValidation, idProposition, montantTransaction, idMembreBeneficiaire, montantEcu);
    }
}
