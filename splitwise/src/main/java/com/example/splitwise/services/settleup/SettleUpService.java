package com.example.splitwise.services.settleup;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.ExpenseOwingUser;
import com.example.splitwise.models.ExpensePayingUser;
import com.example.splitwise.models.Group;
import com.example.splitwise.repositories.ExpenseOwingUserRepository;
import com.example.splitwise.repositories.ExpensePayingUserRepository;
import com.example.splitwise.repositories.GroupRepository;
import com.example.splitwise.services.settleup.strategies.SettleUpTransactionsCalculatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    @Autowired
    @Qualifier("giveToNextSettleUpStrategy")
    private SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy;

    @Autowired
    private SettleUpTransactionsCalculatorStrategy minMaxSettleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseOwingUserRepository expenseOwingUserRepository;
    private ExpensePayingUserRepository expensePayingUserRepository;

    @Autowired
    public SettleUpService(SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy) {
        this.settleUpTransactionsCalculatorStrategy = settleUpTransactionsCalculatorStrategy;
    }

    public List<Transaction> settleUpUser(Long userId) {
        return null;
    }

    public List<Transaction> settleUpGroup(Long groupId, String method) {

        // Algo:
        // settleUp(group_id) {
        //    1. Get all epu and eou for the group
        //    2. Do calculation to compute the transaction
        // }

        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (!groupOptional.isPresent()) {
            // throw some exception
            System.out.println("No group with that id");
        }

        Group group = groupOptional.get();

        List<ExpensePayingUser> expensePayingUsers = new ArrayList<>();
        List<ExpenseOwingUser> expenseOwingUsers = new ArrayList<>();

        for (Expense expense: group.getExpenses()) {
            expensePayingUsers.addAll(expensePayingUserRepository.findAllByExpense(expense));
            expenseOwingUsers.addAll(expenseOwingUserRepository.findAllByExpense(expense));
        }

        if (method == "minMax") {
            return minMaxSettleUpStrategy.getTransactions(
                    expensePayingUsers,
                    expenseOwingUsers
            );
        }

        return settleUpTransactionsCalculatorStrategy.getTransactions(
                expensePayingUsers,
                expenseOwingUsers
        );
    }
}
