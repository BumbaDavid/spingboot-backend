package com.example.demo.model;

import javax.persistence.Entity;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.validation.annotation.Validated;

import net.bytebuddy.agent.builder.AgentBuilder.Listener;

@Entity
@Table(name = "orders")
public class AddToCart{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice(){
        double sum =0;
        List<OrderProduct> orderProducts = getTotalProducts();

        for(orderProducts op : orderProducts){
            sum += op.getTotalPrice();
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts(){
        return this.orderProducts.size();
    }
    
}
