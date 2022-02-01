package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VAC")
public class E_TVacEntity extends E_TMembreEntity {
    @Basic
    @Column(name = "MODE_LOGEMENT")
    private String mode_logement;
    public E_TVacEntity(String nomMembre, String prenomMembre, String mailMembre, String statut) {
        super(nomMembre, prenomMembre, mailMembre, statut);
    }

    public E_TVacEntity(String nomMembre, String prenomMembre, String mailMembre, String statut, String mode_logement) {
        super(nomMembre, prenomMembre, mailMembre, statut);
        this.mode_logement = mode_logement;
    }

    public E_TVacEntity() {
    }
}
