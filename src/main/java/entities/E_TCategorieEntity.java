package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_categorie", schema = "sel", catalog = "")
public class E_TCategorieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CATEGORIE")
    private int idCategorie;
    @Basic
    @Column(name = "CATEGORIE")
    private String categorie;


    @OneToMany(mappedBy = "tCategorieByIdCategorie", cascade = CascadeType.ALL)
    private Collection<E_TCompetenceEntity> tCompetencesByIdCategorie;


    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_TCategorieEntity that = (E_TCategorieEntity) o;
        return idCategorie == that.idCategorie && Objects.equals(categorie, that.categorie);
    }

    @Override
    public String toString() {
        return "E_TCategorieEntity{" +
                "idCategorie=" + idCategorie +
                ", categorie='" + categorie + '\'' +
                ", tCompetencesByIdCategorie=" + tCompetencesByIdCategorie +
                '}';
    }

    public E_TCategorieEntity() {
        tCompetencesByIdCategorie = new ArrayList<E_TCompetenceEntity>();
    }

    public E_TCategorieEntity(String categorie) {
        this();
        this.categorie = categorie;
    }

    public int ajouteCompetence(String nomCompetence) {
        E_TCompetenceEntity e_tCompetenceEntity = new E_TCompetenceEntity(nomCompetence, this);
        if (!tCompetencesByIdCategorie.contains(e_tCompetenceEntity)) {
            tCompetencesByIdCategorie.add(e_tCompetenceEntity);
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, categorie);
    }

    public Collection<E_TCompetenceEntity> gettCompetencesByIdCategorie() {
        return tCompetencesByIdCategorie;
    }

    public void settCompetencesByIdCategorie(Collection<E_TCompetenceEntity> tCompetencesByIdCategorie) {
        this.tCompetencesByIdCategorie = tCompetencesByIdCategorie;
    }
}
