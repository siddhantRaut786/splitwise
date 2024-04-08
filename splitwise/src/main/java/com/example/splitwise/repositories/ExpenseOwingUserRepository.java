package com.example.splitwise.repositories;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.ExpenseOwingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseOwingUserRepository
        extends JpaRepository<ExpenseOwingUser, Long> {
    List<ExpenseOwingUser> findAllByExpense(Expense expense);
}
