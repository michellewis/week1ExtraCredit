package edu.mum.week1ExtraCredit.domain;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

@Embeddable
public class Resource {
    private String description;
    private int quantity;
    private String requiredSquils;
    @Enumerated
    ResourceType type;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRequiredSquils() {
        return requiredSquils;
    }

    public void setRequiredSquils(String requiredSquils) {
        this.requiredSquils = requiredSquils;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
