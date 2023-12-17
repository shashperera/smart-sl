package com.esad.smartsl.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CARD_PACKAGE")
public class CardPackage extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4442170467511681099L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", updatable = false, nullable = false)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DESCRIPTION")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}