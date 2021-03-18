package at.co.netconsulting.incomesandexpenses.persistence;

import at.co.netconsulting.incomesandexpenses.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeOutgoTotalRepository extends CrudRepository<IncomeOutgo, Long> {
    @Query(value = "SELECT new at.co.netconsulting.incomesandexpenses.domain.OutgoListGrouped (position, SUM(outgo) as gesamt) from IncomeOutgo where outgo > 0 group by position")
    List<OutgoListGrouped> getAllPositionsSumUpByOutgo();

    @Query(value = "SELECT new at.co.netconsulting.incomesandexpenses.domain.IncomeListGrouped (position, SUM(income) as gesamt) from IncomeOutgo where income > 0 group by position")
    List<IncomeListGrouped> getAllPositionsSumUpByIncome();

    @Query(value = "SELECT new at.co.netconsulting.incomesandexpenses.domain.IncomeOutgoDetailedListOrderByDayOfWeek (dayofweek, person, position, income, outgo) from IncomeOutgo ORDER BY dayofweek")
    List<IncomeOutgoDetailedListOrderByDayOfWeek> getIncomeOutgoDetailedListOrderByDayOfWeek();

//    @Query(value = "SELECT new at.co.netconsulting.incomesandexpenses.domain.SumIncomeOutgo( SUM(income) AS income, SUM(outgo) as outgo, SUM(income)-SUM(outgo) AS savings) from IncomeOutgo where (income > 0 or outgo > 0) and (dayofweek >= date_trunc('month', current_date)) and (dayofweek <= date_trunc('month', CURRENT_DATE) + '1 month - 1 day'::interval)", nativeQuery = true)
//    List<SumIncomeOutgo> getSumIncomeOutgo();

    @Query(value = "SELECT new at.co.netconsulting.incomesandexpenses.domain.SumIncomeOutgo( SUM(income) AS income, SUM(outgo) as outgo, SUM(income)-SUM(outgo) AS savings) from IncomeOutgo where (income > 0 or outgo > 0)")
    List<SumIncomeOutgo> getSumIncomeOutgo();
}