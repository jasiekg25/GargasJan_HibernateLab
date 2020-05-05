package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceID;

    private int invoiceNumber;
    private int quantity;
    @ManyToMany(mappedBy = "invoices", cascade = CascadeType.PERSIST)
    private Set<Product> products;

    public Invoice() { }
    public Invoice(int invoiceNumber, int quantity) {
        this.invoiceNumber = invoiceNumber;
        this.quantity = quantity;
        this.products = new HashSet<>();
    }

//    Getters & Setters

    public int getInvoiceID() { return invoiceID; }
    public void setInvoiceID(int invoiceID) { this.invoiceID = invoiceID; }


    public int getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(int invoiceNumber) { this.invoiceNumber = invoiceNumber; }


    public int getUnitsInStock() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }


    public Set<Product> getProducts() { return products; }
    public void setProducts(Set<Product> products) { this.products = products; }


    public void addProduct(Product product) {
        this.products.add(product);
        product.addInvoice(this);
    }


}
