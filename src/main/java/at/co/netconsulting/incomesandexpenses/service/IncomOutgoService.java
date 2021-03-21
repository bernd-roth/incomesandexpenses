package at.co.netconsulting.incomesandexpenses.service;

import at.co.netconsulting.incomesandexpenses.domain.*;
import at.co.netconsulting.incomesandexpenses.persistence.IncomeOutgoRepository;
import at.co.netconsulting.incomesandexpenses.persistence.IncomeOutgoTotalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    public List<OutgoListGrouped> getAllPositionsSumUpByOutgo() {
        return incomeOutgoTotalRepository.getAllPositionsSumUpByOutgo();
    }

    public List<IncomeListGrouped> getAllPositionsSumUpByIncome() {
        return incomeOutgoTotalRepository.getAllPositionsSumUpByIncome();
    }

    public List<IncomeOutgoDetailedListOrderByDayOfWeek> getIncomeOutgoDetailedListOrderByDayOfWeek() {
        return incomeOutgoTotalRepository.getIncomeOutgoDetailedListOrderByDayOfWeek();
    }

    public List<SumIncomeOutgo> getSumIncomeOutgo() {
        return incomeOutgoTotalRepository.getSumIncomeOutgo();
    }

    public List<DateChoiceDTO> getAllForDateChoice(Date start_dayofmonth) {
        return incomeOutgoTotalRepository.findAllByDate(start_dayofmonth, start_dayofmonth);
    }
}
