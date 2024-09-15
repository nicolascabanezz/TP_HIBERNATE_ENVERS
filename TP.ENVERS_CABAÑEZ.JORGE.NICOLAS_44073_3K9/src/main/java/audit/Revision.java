package audit;

import config.CustomRevisionListener;
import lombok.*;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data //@Data de Lombok para obtener los métodos Getter, Setter y demás.
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "REVISION_INFO")
@RevisionEntity(CustomRevisionListener.class)

public class Revision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_req")
    //@SequenceGenerator(name = "revision_req", sequenceName = "rbac.seq_revision_id")
    @SequenceGenerator(name = "revision_req")
    @RevisionNumber
    private int id;

    @Column(name = "REVISION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date date;
}
