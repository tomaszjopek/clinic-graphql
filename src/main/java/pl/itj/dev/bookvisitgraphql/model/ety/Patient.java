package pl.itj.dev.bookvisitgraphql.model.ety;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import pl.itj.dev.bookvisitgraphql.model.ety.base.Person;

@Entity
@Table(name = "PATIENTS")
@Getter
@Setter
@ToString
public class Patient extends Person {

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude
  private Set<Comment> comments = new HashSet<>();

  public void addComment(Comment comment) {
    comments.add(comment);
    comment.setAuthor(this);
  }

  public void removeComment(Comment comment) {
    comments.remove(comment);
    comment.setAuthor(null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Patient patient = (Patient) o;
    return getId() != null && Objects.equals(getId(), patient.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
