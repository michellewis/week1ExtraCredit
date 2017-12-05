package edu.mum.week1ExtraCredit.domain;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class Resource implements Serializable {
    @Basic(optional = false)
    private String description;
    @Basic(optional = false)
    private Integer quantity;
    private String requiredSquils;
    @Enumerated
    ResourceType type;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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
