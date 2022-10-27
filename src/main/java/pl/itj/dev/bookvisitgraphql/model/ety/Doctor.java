package pl.itj.dev.bookvisitgraphql.model.ety;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
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

  @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude
  private Set<Comment> comments = new HashSet<>();

  @OneToOne(fetch = FetchType.LAZY)
  @ToString.Exclude
  private Schedule schedule;

  public void addComment(Comment comment) {
    comments.add(comment);
    comment.setDoctor(this);
  }

  public void removeComment(Comment comment) {
    comments.remove(comment);
    comment.setDoctor(null);
  }

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
