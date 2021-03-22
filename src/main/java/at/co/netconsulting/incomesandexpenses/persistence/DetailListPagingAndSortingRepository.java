package at.co.netconsulting.incomesandexpenses.persistence;

import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailListPagingAndSortingRepository extends PagingAndSortingRepository<IncomeOutgo, Long> {
}
