package pl.itj.dev.bookvisitgraphql.model.ety.base;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
  @Id @GeneratedValue private UUID id;

  public boolean isNew() {
    return this.id == null;
  }
}
