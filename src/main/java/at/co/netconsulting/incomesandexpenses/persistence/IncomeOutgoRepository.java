package at.co.netconsulting.incomesandexpenses.persistence;

import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeOutgoRepository extends JpaRepository<IncomeOutgo, Long> {
}