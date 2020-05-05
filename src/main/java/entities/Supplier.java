package entities;

import entities.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier extends Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierID;
    public String bankAccountNumber;

    @OneToMany(mappedBy = "supplier")
    private Set<Product> products;

    public Supplier() { super(); }
    public Supplier(String companyName, Address address, String bankAccountNumber) {
        super(companyName, address);
        products = new HashSet<>();
        this.bankAccountNumber = bankAccountNumber;

    }
    public void addProduct(Product product) {
        products.add(product);
        product.setSupplier(this);
    }
//    Getters & Setters
    public int getSupplierID() { return supplierID; }
    public void setSupplierID(int supplierID) { this.supplierID = supplierID; }


    public Set<Product> getProducts() { return products; }
    public void setProducts(Set<Product> products) { this.products = products; }


    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }






}
