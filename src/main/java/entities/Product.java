package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;
    private String productName;
    private int unitsInStock;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Invoice> invoices;
    public void addInvoice(Invoice invoice) { this.invoices.add(invoice); }
    public Set<Invoice> getInvoices() { return invoices; }


    public Product() { }
    public Product(String productName, int unitsInStock) {
        this.productName = productName;
        this.unitsInStock = unitsInStock;
        this.invoices = new HashSet<>();
    }

    //    Getters & Setters
    public int getProductID() { return productID; }
    public void setProductID(int productID){ this.productID = productID;};


    public String getProductName() { return productName; }
    public void setProductName(String productName){ this.productName = productName;}


    public int getUnitsInStock() { return unitsInStock; }
    public void setUnitsInStock(int unitsInStock){ this.unitsInStock = unitsInStock;}


    public Supplier getSupplier() { return supplier; }
    protected void setSupplier(Supplier supplier) { this.supplier = supplier; }


    public Category getCategory() { return category; }
    protected void setCategory(Category category) { this.category = category; }

//    gui
    public void addCategory(Category category){ category.addProduct(this); }
    public void addSupplier(Supplier supplier){ supplier.addProduct(this); }





}
