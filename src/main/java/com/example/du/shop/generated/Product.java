package com.example.du.shop.generated;
// Generated 01-Sep-2018 16:53:30 by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,schema="dbo"
    ,catalog="shop"
)
public class Product  implements java.io.Serializable {


     private Integer prId;
     private String prName;
     private String prDescription;
     private Long prPrice;
     private Integer prStock;
     private Set basketItems = new HashSet(0);

    public Product() {
    }

    public Product(String prName, String prDescription, Long prPrice, Integer prStock, Set basketItems) {
       this.prName = prName;
       this.prDescription = prDescription;
       this.prPrice = prPrice;
       this.prStock = prStock;
       this.basketItems = basketItems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="pr_id", unique=true, nullable=false)
    public Integer getPrId() {
        return this.prId;
    }
    
    public void setPrId(Integer prId) {
        this.prId = prId;
    }
    
    @Column(name="pr_name", length=100)
    public String getPrName() {
        return this.prName;
    }
    
    public void setPrName(String prName) {
        this.prName = prName;
    }
    
    @Column(name="pr_description")
    public String getPrDescription() {
        return this.prDescription;
    }
    
    public void setPrDescription(String prDescription) {
        this.prDescription = prDescription;
    }
    
    @Column(name="pr_price", precision=18, scale=0)
    public Long getPrPrice() {
        return this.prPrice;
    }
    
    public void setPrPrice(Long prPrice) {
        this.prPrice = prPrice;
    }
    
    @Column(name="pr_stock")
    public Integer getPrStock() {
        return this.prStock;
    }
    
    public void setPrStock(Integer prStock) {
        this.prStock = prStock;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="product")
    public Set getBasketItems() {
        return this.basketItems;
    }
    
    public void setBasketItems(Set basketItems) {
        this.basketItems = basketItems;
    }




}

