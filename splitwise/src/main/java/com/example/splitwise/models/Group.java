package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends BaseModel {
    private String name;
    @ManyToMany
    private List<User> participants;
    @ManyToMany
    private List<User> admins;
    private String description;
    @ManyToOne
    private User createdBy;
    @OneToMany
    private List<Expense> expenses;
    // G : E
    // 1   m
    // 1   1
    // 1 : m
    //   expenses
    //   |         | group_id
}
