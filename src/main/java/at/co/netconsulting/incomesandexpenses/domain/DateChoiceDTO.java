package at.co.netconsulting.incomesandexpenses.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DateChoiceDTO {
    @Temporal(TemporalType.DATE)
    Date dayofweek;
    String person;
    String position;
    double income;
    double outgo;
}