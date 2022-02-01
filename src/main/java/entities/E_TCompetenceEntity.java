package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_competence", schema = "sel", catalog = "")
public class E_TCompetenceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COMPETENCE")
    private int idCompetence;
    @Basic
    @Column(name = "COMPETENCE")
    private String competence;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE", nullable = false)
    private E_TCategorieEntity tCategorieByIdCategorie;

    public E_TCompetenceEntity() {

    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof E_TCompetenceEntity)) return false;
        E_TCompetenceEntity that = (E_TCompetenceEntity) o;
        return idCompetence == that.idCompetence && Objects.equals(competence, that.competence) && Objects.equals(tCategorieByIdCategorie, that.tCategorieByIdCategorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompetence, competence, tCategorieByIdCategorie);
    }

    public E_TCategorieEntity gettCategorieByIdCategorie() {
        return tCategorieByIdCategorie;
    }

    @Override
    public String toString() {
        return "E_TCompetenceEntity{" +
                "idCompetence=" + idCompetence +
                ", competence='" + competence + '\'' +

                '}';
    }

    public E_TCompetenceEntity(String competence, E_TCategorieEntity tCategorieByIdCategorie) {
        this.competence = competence;
        this.tCategorieByIdCategorie = tCategorieByIdCategorie;
    }

    public void settCategorieByIdCategorie(E_TCategorieEntity tCategorieByIdCategorie) {
        this.tCategorieByIdCategorie = tCategorieByIdCategorie;
    }
}
