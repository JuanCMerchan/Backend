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
}
