package com.account.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Account> accounts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(accounts, customer.accounts);
    }




}
