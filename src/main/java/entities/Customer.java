package entities;

import javax.persistence.Entity;

@Entity
public class Customer extends Company {
    private double discount;

    public Customer() {
        super();
    }

    public Customer(String companyName,Address address, double discount) {
        super(companyName, address);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
