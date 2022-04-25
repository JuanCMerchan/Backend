package com.desarrolloweb.proyecto.jpa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Purchase> listPurchases;
    private Integer priceTotal;

    @Temporal(TemporalType.DATE)
    private Date date;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Purchase> getListPurchases() {
        return this.listPurchases;
    }

    public void setListPurchases(List<Purchase> listPurchases) {
        this.listPurchases = listPurchases;
    }

    public Integer getPriceTotal() {
        return this.priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
