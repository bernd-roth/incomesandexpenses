package at.co.netconsulting.incomesandexpenses.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IncomeOutgoDetailedListOrderByDayOfWeek {
    Date dayofweek;
    String person;
    String position;
    double income;
    double outgo;
}
