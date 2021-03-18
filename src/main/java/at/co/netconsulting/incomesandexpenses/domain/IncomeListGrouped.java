package at.co.netconsulting.incomesandexpenses.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IncomeListGrouped {
    String position;
    double income;
}
