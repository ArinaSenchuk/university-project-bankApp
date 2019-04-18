package com.senchuk.project.controller;

import com.senchuk.project.model.Credit;
import com.senchuk.project.model.Deposit;
import com.senchuk.project.service.AccountingEntriesService;
import com.senchuk.project.service.CreditService;
import com.senchuk.project.service.CreditsAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/credits", produces = "application/json")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @Autowired
    private CreditsAccountsService creditsAccountsService;

    @Autowired
    private AccountingEntriesService accountingEntriesService;

    @PostMapping(value = "/save")
    public void saveCredit(@RequestBody Credit credit){

        creditService.save(credit);
        creditsAccountsService.createCreditAccounts(credit);

        //accountingEntriesService.startDepositProgram(deposit);
    }
}
