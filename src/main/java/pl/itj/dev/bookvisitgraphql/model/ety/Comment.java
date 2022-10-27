package pl.itj.dev.bookvisitgraphql.model.ety;

import java.util.Objects;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import pl.itj.dev.bookvisitgraphql.model.ety.base.BaseEntity;

@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
public class Comment extends BaseEntity {

  private Double rating;

  @ManyToOne(fetch = FetchType.LAZY)
  private Patient author;

  @ManyToOne(fetch = FetchType.LAZY)
  private Doctor doctor;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Comment comment = (Comment) o;
    return getId() != null && Objects.equals(getId(), comment.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
