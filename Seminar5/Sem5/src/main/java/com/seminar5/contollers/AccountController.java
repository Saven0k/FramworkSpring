package com.seminar5.contollers;

import com.seminar5.dto.TransferRequest;
import com.seminar5.model.Account;
import com.seminar5.services.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class AccountController {
    private final TransferService transferService;

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam (required = false) String name){
        if (name == null) {
            return transferService.getAllAccounts();
        } else {
            return transferService.findAccountByName(name);
        }
    }
}
