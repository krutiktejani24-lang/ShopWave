package com.shopwave.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Double price;

    private Double oldPrice;
    private Double rating;
    private String emoji;
    private Integer discount;
    private Boolean premium;
    private Boolean isNew;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldPrice() {
    return oldPrice;
}

public void setOldPrice(Double oldPrice) {
    this.oldPrice = oldPrice;
}

public Double getRating() {
    return rating;
}

public void setRating(Double rating) {
    this.rating = rating;
}

public String getEmoji() {
    return emoji;
}

public void setEmoji(String emoji) {
    this.emoji = emoji;
}

public Integer getDiscount() {
    return discount;
}

public void setDiscount(Integer discount) {
    this.discount = discount;
}

public Boolean getPremium() {
    return premium;
}

public void setPremium(Boolean premium) {
    this.premium = premium;
}

public Boolean getIsNew() {
    return isNew;
}

public void setIsNew(Boolean isNew) {
    this.isNew = isNew;
}
}