package at.co.netconsulting.incomesandexpenses.presentation;

import at.co.netconsulting.incomesandexpenses.domain.*;
import at.co.netconsulting.incomesandexpenses.service.IncomOutgoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Validated
@RequestMapping(value = "/incomeoutgo")
public class IncomeOutgoController {

    private static final String INCOMEOUTGO_VIEW = "incomeoutgo";
    private static final String INCOMEOUTGO_TOTAL = "incomeoutgototal";
    private static final String OUTGO_GROUPED_BY_POSITION = "outgoGroupedByPosition";
    private static final String INCOME_GROUPED_BY_POSITION = "incomeGroupedByPosition";
    private static final String INCOME_OUTGO_DETAILED_LIST_ORDER_BY_DAYOFWEEK = "incomeOutgoOrderByDayOfWeek";
    private static final String SUM_INCOME_OUTGO = "sumincomeoutgo";

    private final IncomOutgoService incomeoutgoService;

    @GetMapping
    public String showIncome(Model model) {
        List<IncomeOutgo> incomeOutgoList = incomeoutgoService.getIncomeOutgoList();
        model.addAttribute(INCOMEOUTGO_VIEW, incomeOutgoList);
        model.addAttribute("page", new IncomeOutgo());

        List<OutgoListGrouped> outgoListGroupedByPosition = incomeoutgoService.getAllPositionsSumUpByOutgo();
        model.addAttribute(OUTGO_GROUPED_BY_POSITION, outgoListGroupedByPosition);
        model.addAttribute("outgoListGrouped", new OutgoListGrouped());

        List<IncomeListGrouped> incomeList = incomeoutgoService.getAllPositionsSumUpByIncome();
        model.addAttribute(INCOME_GROUPED_BY_POSITION, incomeList);
        model.addAttribute("outgoListGrouped", new IncomeListGrouped());

        List<IncomeOutgoDetailedListOrderByDayOfWeek> detailedListOfIncomeOutgo = incomeoutgoService.getIncomeOutgoDetailedListOrderByDayOfWeek();
        model.addAttribute(INCOME_OUTGO_DETAILED_LIST_ORDER_BY_DAYOFWEEK, detailedListOfIncomeOutgo);
        model.addAttribute("outgoListGrouped", new IncomeOutgoDetailedListOrderByDayOfWeek());

        List<SumIncomeOutgo> sumListIncomeOutgo = incomeoutgoService.getSumIncomeOutgo();
        model.addAttribute(SUM_INCOME_OUTGO, sumListIncomeOutgo);
        model.addAttribute("outgoListGrouped", sumListIncomeOutgo);

        return INCOMEOUTGO_VIEW;
    }

    @PostMapping(value="/submitFields")
    public String submitFields(@ModelAttribute("incomeoutgo") @Valid IncomeOutgo incomeoutgo, Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return INCOMEOUTGO_VIEW;
        }
        incomeoutgoService.addIncomeOutgo(incomeoutgo);
        List<IncomeOutgo> incomeOutgoList = incomeoutgoService.getIncomeOutgoList();
        model.addAttribute(INCOMEOUTGO_VIEW, incomeOutgoList);
        model.addAttribute("page", new IncomeOutgo());

        List<OutgoListGrouped> outgoListGroupedByPosition = incomeoutgoService.getAllPositionsSumUpByOutgo();
        model.addAttribute(OUTGO_GROUPED_BY_POSITION, outgoListGroupedByPosition);
        model.addAttribute("outgoListGrouped", new OutgoListGrouped());

        List<IncomeListGrouped> incomeList = incomeoutgoService.getAllPositionsSumUpByIncome();
        model.addAttribute(INCOME_GROUPED_BY_POSITION, incomeList);
        model.addAttribute("outgoListGrouped", new IncomeListGrouped());

        List<IncomeOutgoDetailedListOrderByDayOfWeek> detailedListOfIncomeOutgo = incomeoutgoService.getIncomeOutgoDetailedListOrderByDayOfWeek();
        model.addAttribute(INCOME_OUTGO_DETAILED_LIST_ORDER_BY_DAYOFWEEK, detailedListOfIncomeOutgo);
        model.addAttribute("outgoListGrouped", new IncomeOutgoDetailedListOrderByDayOfWeek());

        List<SumIncomeOutgo> sumListIncomeOutgo = incomeoutgoService.getSumIncomeOutgo();
        model.addAttribute(SUM_INCOME_OUTGO, sumListIncomeOutgo);
        model.addAttribute("outgoListGrouped", sumListIncomeOutgo);

        return INCOMEOUTGO_VIEW;
    }

    @PostMapping(value="/selectDateRange")
    public String selectDateRange(@DateTimeFormat(pattern = "yyyy-MM-dd") Date selectionDate, @ModelAttribute("incomeoutgoDate") @Valid DateChoiceDTO dateChoice, Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return INCOMEOUTGO_VIEW;
        }

        List<IncomeOutgo> incomeOutgoList = incomeoutgoService.getIncomeOutgoList();
        model.addAttribute(INCOMEOUTGO_VIEW, incomeOutgoList);
        model.addAttribute("page", new IncomeOutgo());

        List<OutgoListGrouped> outgoListGroupedByPosition = incomeoutgoService.getAllPositionsSumUpByOutgo();
        model.addAttribute(OUTGO_GROUPED_BY_POSITION, outgoListGroupedByPosition);
        model.addAttribute("outgoListGrouped", new OutgoListGrouped());

        List<IncomeListGrouped> incomeList = incomeoutgoService.getAllPositionsSumUpByIncome();
        model.addAttribute(INCOME_GROUPED_BY_POSITION, incomeList);
        model.addAttribute("outgoListGrouped", new IncomeListGrouped());

        List<DateChoiceDTO> detailedListOfIncomeOutgo = incomeoutgoService.getAllForDateChoice(selectionDate);
        model.addAttribute(INCOME_OUTGO_DETAILED_LIST_ORDER_BY_DAYOFWEEK, detailedListOfIncomeOutgo);
        model.addAttribute("outgoListGrouped", new IncomeOutgoDetailedListOrderByDayOfWeek());

        List<SumIncomeOutgo> sumListIncomeOutgo = incomeoutgoService.getSumIncomeOutgo();
        model.addAttribute(SUM_INCOME_OUTGO, sumListIncomeOutgo);
        model.addAttribute("outgoListGrouped", sumListIncomeOutgo);

        return INCOMEOUTGO_VIEW;
    }
}