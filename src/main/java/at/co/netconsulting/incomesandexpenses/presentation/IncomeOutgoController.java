package at.co.netconsulting.incomesandexpenses.presentation;

import at.co.netconsulting.incomesandexpenses.domain.*;
import at.co.netconsulting.incomesandexpenses.service.IncomOutgoService;
import at.co.netconsulting.incomesandexpenses.service.IncomeOutgoPagingAndSortingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static final String SUM_DETAILED_LIST_OF_INCOME_OUTGO = "sumDetailedListOfIncomeOutgo";

    private final IncomOutgoService incomeoutgoService;
    private final IncomeOutgoPagingAndSortingService incomeOutgoPagingAndSortingService;

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
//    @GetMapping
//    public String showIncome(@PageableDefault(size = 10) Pageable pageable, @RequestParam(name="pagingNosorting", required = false) Integer pagingNosorting, Model model) {
//
//        if (pagingNosorting == null) {
//            Pageable pageable1 = PageRequest.of(0, 5, Sort.by("dayofweek").descending());
//            Page<IncomeOutgo> page = incomeOutgoPagingAndSortingService.getAllDetailsPaging(pageable1);
//            model.addAttribute("pagingNosorting", page);
//
//            List<IncomeOutgo> incomeOutgoList = incomeoutgoService.getIncomeOutgoList();
//            model.addAttribute(INCOMEOUTGO_VIEW, incomeOutgoList);
//            model.addAttribute("page", new IncomeOutgo());
//
//            List<OutgoListGrouped> outgoListGroupedByPosition = incomeoutgoService.getAllPositionsSumUpByOutgo();
//            model.addAttribute(OUTGO_GROUPED_BY_POSITION, outgoListGroupedByPosition);
//            model.addAttribute("outgoListGrouped", new OutgoListGrouped());
//
//            List<IncomeListGrouped> incomeList = incomeoutgoService.getAllPositionsSumUpByIncome();
//            model.addAttribute(INCOME_GROUPED_BY_POSITION, incomeList);
//            model.addAttribute("outgoListGrouped", new IncomeListGrouped());
//
//            List<IncomeOutgoDetailedListOrderByDayOfWeek> detailedListOfIncomeOutgo = incomeoutgoService.getIncomeOutgoDetailedListOrderByDayOfWeek();
//            model.addAttribute(INCOME_OUTGO_DETAILED_LIST_ORDER_BY_DAYOFWEEK, detailedListOfIncomeOutgo);
//            model.addAttribute("outgoListGrouped", new IncomeOutgoDetailedListOrderByDayOfWeek());
//
//            List<SumIncomeOutgo> sumListIncomeOutgo = incomeoutgoService.getSumIncomeOutgo();
//            model.addAttribute(SUM_INCOME_OUTGO, sumListIncomeOutgo);
//            model.addAttribute("outgoListGrouped", sumListIncomeOutgo);
//
//            return INCOMEOUTGO_VIEW;
//        } else {
//            Pageable pageable1 = PageRequest.of(pagingNosorting, 5, Sort.by("dayofweek").descending());
//            Page<IncomeOutgo> page = incomeOutgoPagingAndSortingService.getAllDetailsPaging(pageable1);
//            model.addAttribute("pagingNosorting", page);
//
//            List<IncomeOutgo> incomeOutgoList = incomeoutgoService.getIncomeOutgoList();
//            model.addAttribute(INCOMEOUTGO_VIEW, incomeOutgoList);
//            model.addAttribute("page", new IncomeOutgo());
//
//            List<OutgoListGrouped> outgoListGroupedByPosition = incomeoutgoService.getAllPositionsSumUpByOutgo();
//            model.addAttribute(OUTGO_GROUPED_BY_POSITION, outgoListGroupedByPosition);
//            model.addAttribute("outgoListGrouped", new OutgoListGrouped());
//
//            List<IncomeListGrouped> incomeList = incomeoutgoService.getAllPositionsSumUpByIncome();
//            model.addAttribute(INCOME_GROUPED_BY_POSITION, incomeList);
//            model.addAttribute("outgoListGrouped", new IncomeListGrouped());
//
//            List<IncomeOutgoDetailedListOrderByDayOfWeek> detailedListOfIncomeOutgo = incomeoutgoService.getIncomeOutgoDetailedListOrderByDayOfWeek();
//            model.addAttribute(INCOME_OUTGO_DETAILED_LIST_ORDER_BY_DAYOFWEEK, detailedListOfIncomeOutgo);
//            model.addAttribute("outgoListGrouped", new IncomeOutgoDetailedListOrderByDayOfWeek());
//
//            List<SumIncomeOutgo> sumListIncomeOutgo = incomeoutgoService.getSumIncomeOutgo();
//            model.addAttribute(SUM_INCOME_OUTGO, sumListIncomeOutgo);
//            model.addAttribute("outgoListGrouped", sumListIncomeOutgo);
//
//            return INCOMEOUTGO_VIEW;
//        }
//    }

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
    public String selectDateRange(@DateTimeFormat(pattern = "yyyy-MM-dd") Date selectionDate, @ModelAttribute("incomeoutgoDate") @Valid DateChoiceDTO dateChoice, @Valid SumDateChoiceDTO sumDateChoiceDTO, Model model, BindingResult bindingResult) {
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

        //sum detailed list between date1 and date2
        List<SumDateChoiceDTO> sumDetailedListOfIncomeOutgo = incomeoutgoService.sumByDate(selectionDate);
        model.addAttribute(SUM_DETAILED_LIST_OF_INCOME_OUTGO, sumDetailedListOfIncomeOutgo);
        model.addAttribute("outgoListGrouped", new SumDateChoiceDTO());

        return INCOMEOUTGO_VIEW;
    }

    @GetMapping("/incomeoutgo")
    public String getEmployees(@PageableDefault(size = 10) Pageable pageable,
                               Model model) {
        Page<IncomeOutgo> page = incomeOutgoPagingAndSortingService.getAllDetailsPaging(pageable);
        model.addAttribute("page", page);
        return INCOMEOUTGO_VIEW;
    }
}