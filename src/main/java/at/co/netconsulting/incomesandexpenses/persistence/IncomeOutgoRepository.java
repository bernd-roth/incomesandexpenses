package at.co.netconsulting.incomesandexpenses.persistence;

import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgo;
import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgoTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IncomeOutgoRepository extends JpaRepository<IncomeOutgo, Long> { }