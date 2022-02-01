package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_mouvement_compte_ecu", schema = "sel", catalog = "")
public class E_TMouvementCompteEcuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MOUVEMENT_COMPTE_ECU")
    private int idMouvementCompteEcu;
    @Basic
    @Column(name = "ID_MEMBRE")
    private int idMembre;
    @Basic
    @Column(name = "MONTANT_MOUVEMENT")
    private BigDecimal montantMouvement;
    @Basic
    @Column(name = "TYPE_MOUVEMENT")
    private String typeMouvement;
    @Basic
    @Column(name = "DATE_HEURE_MOUVEMENT_COMPTE_ECU")
    private Timestamp dateHeureMouvementCompteEcu;
    @Basic
    @Column(name = "NATURE_MOUVEMENT")
    private String natureMouvement;
    @Basic
    @Column(name = "ID_REFERENCE_MOUVEMENT")
    private Integer idReferenceMouvement;

    public int getIdMouvementCompteEcu() {
        return idMouvementCompteEcu;
    }

    public void setIdMouvementCompteEcu(int idMouvementCompteEcu) {
        this.idMouvementCompteEcu = idMouvementCompteEcu;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public BigDecimal getMontantMouvement() {
        return montantMouvement;
    }

    public void setMontantMouvement(BigDecimal montantMouvement) {
        this.montantMouvement = montantMouvement;
    }

    public String getTypeMouvement() {
        return typeMouvement;
    }

    public void setTypeMouvement(String typeMouvement) {
        this.typeMouvement = typeMouvement;
    }

    public Timestamp getDateHeureMouvementCompteEcu() {
        return dateHeureMouvementCompteEcu;
    }

    public void setDateHeureMouvementCompteEcu(Timestamp dateHeureMouvementCompteEcu) {
        this.dateHeureMouvementCompteEcu = dateHeureMouvementCompteEcu;
    }

    public String getNatureMouvement() {
        return natureMouvement;
    }

    public void setNatureMouvement(String natureMouvement) {
        this.natureMouvement = natureMouvement;
    }

    public Integer getIdReferenceMouvement() {
        return idReferenceMouvement;
    }

    public void setIdReferenceMouvement(Integer idReferenceMouvement) {
        this.idReferenceMouvement = idReferenceMouvement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_TMouvementCompteEcuEntity that = (E_TMouvementCompteEcuEntity) o;
        return idMouvementCompteEcu == that.idMouvementCompteEcu && idMembre == that.idMembre && Objects.equals(montantMouvement, that.montantMouvement) && Objects.equals(typeMouvement, that.typeMouvement) && Objects.equals(dateHeureMouvementCompteEcu, that.dateHeureMouvementCompteEcu) && Objects.equals(natureMouvement, that.natureMouvement) && Objects.equals(idReferenceMouvement, that.idReferenceMouvement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMouvementCompteEcu, idMembre, montantMouvement, typeMouvement, dateHeureMouvementCompteEcu, natureMouvement, idReferenceMouvement);
    }
}
