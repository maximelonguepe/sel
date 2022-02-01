package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRO")
public class E_TProEntity extends E_TMembreEntity {
    @Basic
    @Column(name = "SIRET")
    private String SIRET;

    public String getSIRET() {
        return SIRET;
    }

    public void setSIRET(String SIRET) {
        this.SIRET = SIRET;
    }


    public E_TProEntity(String nomMembre, String prenomMembre, String mailMembre, String statut, String SIRET) {
        super(nomMembre, prenomMembre, mailMembre, statut);
        this.SIRET = SIRET;
    }

    public E_TProEntity(String nomMembre, String prenomMembre, String mailMembre, String statut) {
        super(nomMembre, prenomMembre, mailMembre, statut);
    }

    public E_TProEntity(String SIRET) {
        this.SIRET = SIRET;
    }

    public E_TProEntity() {
    }
}
