package com.example.superbank;

import com.example.superbank.model.TransferBalance;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

//
//
//


@RestController("/balance")
@AllArgsConstructor
public class BalanceController {

    private final BankService bankService;

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) {
        return BankService.getBalance(accountId);
    }


    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance amount) {

    }

    @PostMapping("/transfer")
    public BigDecimal transfer(@RequestBody BigDecimal amount) {

    }

}
