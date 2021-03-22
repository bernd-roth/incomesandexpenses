package at.co.netconsulting.incomesandexpenses.service;

import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgo;
import at.co.netconsulting.incomesandexpenses.persistence.DetailListPagingAndSortingRepository;
import at.co.netconsulting.incomesandexpenses.persistence.IncomeOutgoRepository;
import at.co.netconsulting.incomesandexpenses.persistence.IncomeOutgoTotalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class IncomeOutgoPagingAndSortingService {
    private final DetailListPagingAndSortingRepository detailListPagingAndSortingRepository;

    public Page<IncomeOutgo> getAllDetailsPaging(Pageable pageable) {
        return detailListPagingAndSortingRepository.findAll(pageable);
    }

    //public Page<IncomeOutgo> findAll(Pageable pageable) {
    //    return detailListPagingAndSortingRepository.findAll(pageable);
    //}
}