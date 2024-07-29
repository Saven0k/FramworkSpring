package com.seminar5.services;

import com.seminar5.exception.AccountNotFoundException;
import com.seminar5.model.Account;
import com.seminar5.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class TransferService {
    private final AccountRepository accountRepository;

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws AccountNotFoundException {
        Account sender = accountRepository.findById(idSender)
                .orElseThrow(AccountNotFoundException::new);
        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }
    public Iterable<Account> getAllAccounts(){return accountRepository.findAll();}

    public List<Account> findAccountByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}
