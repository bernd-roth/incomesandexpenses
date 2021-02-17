package at.co.netconsulting.incomesandexpenses.presentation;

import at.co.netconsulting.incomesandexpenses.domain.IncomeOutgo;
import at.co.netconsulting.incomesandexpenses.service.IncomOutgoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Validated
@RequestMapping(value = "/incomeoutgo")
public class IncomeOutgoController {

    private static final String INCOMEOUTGO_VIEW = "incomeoutgo";
    private final IncomOutgoService incomeoutgoService;

    @GetMapping
    public String showIncome(Model model) {
        List<IncomeOutgo> incomeOutgoList = incomeoutgoService.getIncomeOutgoList();
        model.addAttribute(INCOMEOUTGO_VIEW, incomeOutgoList);
        model.addAttribute("page", new IncomeOutgo());
        return INCOMEOUTGO_VIEW;
    }

    @PostMapping
    public String addUser(@ModelAttribute("incomeoutgo") @Valid IncomeOutgo incomeoutgo, Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return INCOMEOUTGO_VIEW;
        }
        incomeoutgoService.addIncomeOutgo(incomeoutgo);
        List<IncomeOutgo> incomeOutgoList = incomeoutgoService.getIncomeOutgoList();
        model.addAttribute(INCOMEOUTGO_VIEW, incomeOutgoList);
        model.addAttribute("page", new IncomeOutgo());
        return INCOMEOUTGO_VIEW;
    }
}