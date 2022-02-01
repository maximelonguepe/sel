package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_operation_change", schema = "sel", catalog = "")
public class E_TOperationChangeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_OPERATION_CHANGE")
    private int idOperationChange;
    @Basic
    @Column(name = "DATE_HEURE_OPERATION_CHANGE")
    private Timestamp dateHeureOperationChange;

    @Basic
    @Column(name = "MONTANT_OPERATION_CHANGE")
    private int montantOperationChange;
    @Basic
    @Column(name = "TYPE_OPERATION_CHANGE")
    private String typeOperationChange;
    @Basic
    @Column(name = "SOLDE_BANQUE")
    private Integer soldeBanque;
    @ManyToOne
    @JoinColumn(name = "ID_MEMBRE", referencedColumnName = "ID_MEMBRE")
    private E_TMembreEntity tMembreByIdMembre;

    public int getIdOperationChange() {
        return idOperationChange;
    }

    public void setIdOperationChange(int idOperationChange) {
        this.idOperationChange = idOperationChange;
    }

    public Timestamp getDateHeureOperationChange() {
        return dateHeureOperationChange;
    }

    public void setDateHeureOperationChange(Timestamp dateHeureOperationChange) {
        this.dateHeureOperationChange = dateHeureOperationChange;
    }


    public int getMontantOperationChange() {
        return montantOperationChange;
    }

    public void setMontantOperationChange(int montantOperationChange) {
        this.montantOperationChange = montantOperationChange;
    }

    public String getTypeOperationChange() {
        return typeOperationChange;
    }

    public void setTypeOperationChange(String typeOperationChange) {
        this.typeOperationChange = typeOperationChange;
    }

    public Integer getSoldeBanque() {
        return soldeBanque;
    }

    public void setSoldeBanque(Integer soldeBanque) {
        this.soldeBanque = soldeBanque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof E_TOperationChangeEntity)) return false;
        E_TOperationChangeEntity that = (E_TOperationChangeEntity) o;
        return idOperationChange == that.idOperationChange && montantOperationChange == that.montantOperationChange && Objects.equals(dateHeureOperationChange, that.dateHeureOperationChange) && Objects.equals(typeOperationChange, that.typeOperationChange) && Objects.equals(soldeBanque, that.soldeBanque) && Objects.equals(tMembreByIdMembre, that.tMembreByIdMembre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOperationChange, dateHeureOperationChange, montantOperationChange, typeOperationChange, soldeBanque, tMembreByIdMembre);
    }

    public E_TMembreEntity gettMembreByIdMembre() {
        return tMembreByIdMembre;
    }

    public void settMembreByIdMembre(E_TMembreEntity tMembreByIdMembre) {
        this.tMembreByIdMembre = tMembreByIdMembre;
    }
}
