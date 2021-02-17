package at.co.netconsulting.incomesandexpenses.persistence;

import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgo;
import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgoTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeOutgoTotalRepository extends CrudRepository<IncomeOutgo, Long> {
    @Query(value = "select new at.co.netconsulting.incomesandexpenses.domain.IncomeOutgoTotal (person, SUM(income)-SUM(outgo) as gesamt, location) from IncomeOutgo where location = 'Food' group by person, location")
    List<IncomeOutgoTotal> getTotal();
}