package pl.itj.dev.bookvisitgraphql.model.ety;

import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import pl.itj.dev.bookvisitgraphql.model.ety.base.BaseEntity;

@Entity
@Table(name = "SCHEDULES")
@Getter
@Setter
public class Schedule extends BaseEntity {

  @OneToOne(mappedBy = "schedule")
  private Doctor doctor;

  private LocalTime startTime;

  private LocalTime endTime;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Schedule schedule = (Schedule) o;
    return getId() != null && Objects.equals(getId(), schedule.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
