package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_ex_cascade_ref", schema = "sel", catalog = "")
public class E_TExCascadeRefEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REF", nullable = false)
    private int idRef;
    @Basic
    @Column(name = "LIB_REF", nullable = true, length = 45)
    private String libRef;


    //@OneToMany(mappedBy = "tExCascadeRefEntity", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "tExCascadeRefEntity")
    private Collection<E_TExCascadeFkEntity> tExCascadeFkEntities;

    public E_TExCascadeRefEntity() {

    }


    public int getIdRef() {
        return idRef;
    }

    public void setIdRef(int idRef) {
        this.idRef = idRef;
    }

    public String getLibRef() {
        return libRef;
    }

    public void setLibRef(String libRef) {
        this.libRef = libRef;
    }

    public E_TExCascadeRefEntity(String libRef) {
        tExCascadeFkEntities=new ArrayList<E_TExCascadeFkEntity>();
        this.libRef = libRef;
    }
    public boolean ajouteFK(E_TExCascadeFkEntity e_tExCascadeFkEntity){
        if(!tExCascadeFkEntities.contains(e_tExCascadeFkEntity)){
            tExCascadeFkEntities.add(e_tExCascadeFkEntity);
            return true;
        }

        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_TExCascadeRefEntity that = (E_TExCascadeRefEntity) o;
        return idRef == that.idRef && Objects.equals(libRef, that.libRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRef, libRef);
    }

    @Override
    public String toString() {
        return "E_TExCascadeRefEntity{" +
                "idRef=" + idRef +
                ", libRef='" + libRef + '\'' +
                ", tExCascadeFkEntities=" + tExCascadeFkEntities +
                '}';
    }
}
