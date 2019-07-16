package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({

        @NamedNativeQuery(
                name = "Company.retrieveCompaniesWithNamesPrefix",
                query = "SELECT * FROM COMPANIES WHERE SUBSTRING(COMPANY_NAME,1,3 )= :PREFIX",
                resultClass = Company.class
        ),
        @NamedNativeQuery(
                name = "Company.retrieveCompaniesWithNamesPhrase",
                query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE :ARG",
                resultClass = Company.class
        )

})

@Entity
@Table(name = "COMPANIES")
public class Company {
    private Integer id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public Integer getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(mappedBy = "companies", fetch = FetchType.EAGER)
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}
