package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ex_cascade_fk", schema = "sel", catalog = "")
public class E_TExCascadeFkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_FK", nullable = false)
    private int idFk;
    @Basic
    @Column(name = "LIB_FK", nullable = true, length = 45)
    private String libFk;


    //@ManyToOne
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_REF", referencedColumnName = "ID_REF", nullable = false)
    private E_TExCascadeRefEntity tExCascadeRefEntity ;
    public E_TExCascadeFkEntity() {

    }



    public int getIdFk() {
        return idFk;
    }

    public void setIdFk(int idFk) {
        this.idFk = idFk;
    }

    public String getLibFk() {
        return libFk;
    }

    public void setLibFk(String libFk) {
        this.libFk = libFk;
    }

    public E_TExCascadeRefEntity gettExCascadeRefEntity() {
        return tExCascadeRefEntity;
    }

    public void settExCascadeRefEntity(E_TExCascadeRefEntity tExCascadeRefEntity) {
        this.tExCascadeRefEntity = tExCascadeRefEntity;
    }

    public E_TExCascadeFkEntity(String libFk, E_TExCascadeRefEntity tExCascadeRefEntity) {
        this.libFk = libFk;
        this.tExCascadeRefEntity = tExCascadeRefEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof E_TExCascadeFkEntity)) return false;
        E_TExCascadeFkEntity that = (E_TExCascadeFkEntity) o;
        return idFk == that.idFk && Objects.equals(libFk, that.libFk) && Objects.equals(tExCascadeRefEntity, that.tExCascadeRefEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFk, libFk, tExCascadeRefEntity);
    }

    @Override
    public String toString() {
        return "E_TExCascadeFkEntity{" +
                "idFk=" + idFk +
                ", libFk='" + libFk + '\'' +
                '}';
    }
}
