package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_operation_ecu", schema = "sel", catalog = "")
public class E_TOperationEcuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_OPERATION_ECU")
    private int idOperationEcu;
    @Basic
    @Column(name = "DATE_HEURE_OPERATION")
    private Timestamp dateHeureOperation;

    @Basic
    @Column(name = "MONTANT_OPERATION")
    private int montantOperation;
    @ManyToOne
    @JoinColumn(name = "ID_MEMBRE_DEBITEUR", referencedColumnName = "ID_MEMBRE", nullable = false)
    private E_TMembreEntity tMembreByIdMembreDebiteur;
    @ManyToOne
    @JoinColumn(name = "ID_MEMBRE_CREDITEUR", referencedColumnName = "ID_MEMBRE", nullable = false)
    private E_TMembreEntity tMembreByIdMembreCrediteur;

    public int getIdOperationEcu() {
        return idOperationEcu;
    }

    public void setIdOperationEcu(int idOperationEcu) {
        this.idOperationEcu = idOperationEcu;
    }

    public Timestamp getDateHeureOperation() {
        return dateHeureOperation;
    }

    public void setDateHeureOperation(Timestamp dateHeureOperation) {
        this.dateHeureOperation = dateHeureOperation;
    }




    public int getMontantOperation() {
        return montantOperation;
    }

    public void setMontantOperation(int montantOperation) {
        this.montantOperation = montantOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof E_TOperationEcuEntity)) return false;
        E_TOperationEcuEntity that = (E_TOperationEcuEntity) o;
        return idOperationEcu == that.idOperationEcu && montantOperation == that.montantOperation && Objects.equals(dateHeureOperation, that.dateHeureOperation) && Objects.equals(tMembreByIdMembreDebiteur, that.tMembreByIdMembreDebiteur) && Objects.equals(tMembreByIdMembreCrediteur, that.tMembreByIdMembreCrediteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOperationEcu, dateHeureOperation, montantOperation, tMembreByIdMembreDebiteur, tMembreByIdMembreCrediteur);
    }

    public E_TMembreEntity gettMembreByIdMembreDebiteur() {
        return tMembreByIdMembreDebiteur;
    }

    public void settMembreByIdMembreDebiteur(E_TMembreEntity tMembreByIdMembreDebiteur) {
        this.tMembreByIdMembreDebiteur = tMembreByIdMembreDebiteur;
    }

    public E_TMembreEntity gettMembreByIdMembreCrediteur() {
        return tMembreByIdMembreCrediteur;
    }

    public void settMembreByIdMembreCrediteur(E_TMembreEntity tMembreByIdMembreCrediteur) {
        this.tMembreByIdMembreCrediteur = tMembreByIdMembreCrediteur;
    }
}
