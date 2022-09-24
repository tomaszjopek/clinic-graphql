package pl.itj.dev.bookvisitgraphql.model.ety;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import pl.itj.dev.bookvisitgraphql.model.ety.base.Person;

@Entity
@Table(name = "DOCTORS")
@Getter
@Setter
@ToString
public class Doctor extends Person {

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Doctor doctor = (Doctor) o;
    return getId() != null && Objects.equals(getId(), doctor.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
