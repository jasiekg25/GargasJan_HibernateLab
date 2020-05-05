package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class Company {
    @Id
    String companyName;

    private Address address;

    public Company() {
    }

    public Company(String companyName, Address address) {
        this.companyName = companyName;
        this.address = address;
    }
}
