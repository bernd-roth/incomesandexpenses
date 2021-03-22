package at.co.netconsulting.incomesandexpenses.service;

import at.co.netconsulting.incomesandexpenses.domain.*;
import at.co.netconsulting.incomesandexpenses.persistence.IncomeOutgoRepository;
import at.co.netconsulting.incomesandexpenses.persistence.IncomeOutgoTotalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
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

    public List<DateChoiceDTO> getAllForDateChoice(Date firstDayOfMonth) {
        Date lastDayOfMonth = getLastDayOfMonth();
        return incomeOutgoTotalRepository.findAllByDate(firstDayOfMonth, lastDayOfMonth);
    }

    public List<SumDateChoiceDTO> sumByDate(Date firstDayOfMonth) {
        Date lastDayOfMonth = getLastDayOfMonth();
        return incomeOutgoTotalRepository.sumByDate(firstDayOfMonth, lastDayOfMonth);
    }

    private Date getLastDayOfMonth() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

}
