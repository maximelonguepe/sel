package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRT")
public class E_TPrtEntity extends E_TMembreEntity {
    @Basic
    @Column(name = "ELU")
    private boolean elu;

    public E_TPrtEntity(String nomMembre, String prenomMembre, String mailMembre, String statut) {
        super(nomMembre, prenomMembre, mailMembre, statut);
    }

    public E_TPrtEntity() {
    }

    public E_TPrtEntity(String nomMembre, String prenomMembre, String mailMembre, String statut, boolean elu) {
        super(nomMembre, prenomMembre, mailMembre, statut);
        this.elu = elu;
    }
}
