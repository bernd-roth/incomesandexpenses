package at.co.netconsulting.incomesandexpenses.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name="incomeoutgo", schema = "public")
public class IncomeOutgo extends AbstractPersistable<Long> {

    //@Version
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @NotNull
    @Column(name="dayofweek")
    private Date dayofweek;

    @NotNull
    @Size(min= 2, max= 100)
    @Column(name="position")
    private String position;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(name ="person")
    private String person;

/*    @NotNull
    @Min(0)
    @Column(name ="version")
    private Integer version;
*/
    @NotNull
    @Size(min= 1)
    @Column(name="income")
    private double income;

    @NotNull
    @Size(min= 2)
    @Column(name="outgo")
    private double outgo;

}