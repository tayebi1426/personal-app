package me.dev.entity;



import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//import org.hibernate.annotations.Immutable;
@MappedSuperclass
//@Immutable
public abstract class ImmutableEntity<PK extends Number> {

    private PK id;

    @Id
    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

}
