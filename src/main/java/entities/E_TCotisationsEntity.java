package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "t_cotisations", schema = "sel", catalog = "")
@NamedQuery(name="Find_cotisation_user", query="SELECT e from E_TCotisationsEntity e where e.tMembreByIdMembre.nomMembre=?1 and e.tMembreByIdMembre.prenomMembre=?2")

public class E_TCotisationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COTISATION")
    private int idCotisation;
    @Basic
    @Column(name = "DATE_COTISATION")
    private Date dateCotisation;


    @Basic
    @Column(name = "ID_TARIF")
    private int idTarif;
    @ManyToOne
    @JoinColumn(name = "ID_MEMBRE", referencedColumnName = "ID_MEMBRE", nullable = false)
    private E_TMembreEntity tMembreByIdMembre;

    public int getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(int idCotisation) {
        this.idCotisation = idCotisation;
    }

    public Date getDateCotisation() {
        return dateCotisation;
    }

    public void setDateCotisation(Date dateCotisation) {
        this.dateCotisation = dateCotisation;
    }

    public int getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(int idTarif) {
        this.idTarif = idTarif;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof E_TCotisationsEntity)) return false;
        E_TCotisationsEntity that = (E_TCotisationsEntity) o;
        return idCotisation == that.idCotisation && idTarif == that.idTarif && Objects.equals(dateCotisation, that.dateCotisation) && Objects.equals(tMembreByIdMembre, that.tMembreByIdMembre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCotisation, dateCotisation, idTarif, tMembreByIdMembre);
    }

    public E_TMembreEntity gettMembreByIdMembre() {
        return tMembreByIdMembre;
    }

    public void settMembreByIdMembre(E_TMembreEntity tMembreByIdMembre) {
        this.tMembreByIdMembre = tMembreByIdMembre;
    }
}
