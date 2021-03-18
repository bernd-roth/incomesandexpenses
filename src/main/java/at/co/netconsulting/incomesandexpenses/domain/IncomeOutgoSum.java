package at.co.netconsulting.incomesandexpenses.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IncomeOutgoSum {
    double income;
    double outgo;
    double savings;
}
