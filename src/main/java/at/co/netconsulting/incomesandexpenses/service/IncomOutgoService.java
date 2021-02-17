package at.co.netconsulting.incomesandexpenses.service;

import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgo;
import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgoTotal;
import at.co.netconsulting.incomesandexpenses.persistence.IncomeOutgoRepository;
import at.co.netconsulting.incomesandexpenses.persistence.IncomeOutgoTotalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly=true)
public class IncomOutgoService {

    private final IncomeOutgoRepository incomeOutgoRepository;
    private final IncomeOutgoTotalRepository incomeOutgoTotalRepository;

    public List<IncomeOutgo> getIncomeOutgoList() {
        return incomeOutgoRepository.findAll();
    }

    @Transactional
    public void addIncomeOutgo(IncomeOutgo incomeOutgo) {
        incomeOutgoRepository.save(incomeOutgo);
    }

    public List<IncomeOutgoTotal> getTotal() {
        return incomeOutgoTotalRepository.getTotal();
    }

}
