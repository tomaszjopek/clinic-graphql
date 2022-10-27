package pl.itj.dev.bookvisitgraphql.model.ety.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
  @Id @GeneratedValue private UUID id;
// dsadasd sadasdasdasd
  @LastModifiedDate private LocalDateTime lastUpdated;

  @CreatedDate private LocalDateTime createdDate;

  public boolean isNew() {
    return this.id == null;
  }
}
