import entities.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        final Transaction transaction = session.beginTransaction();

        try {
            Product product01 = new Product("product01", 20);
            Product product02 = new Product("product02", 20);
            Product product03 = new Product("product03", 0);
            Product product04 = new Product("product04", 100);

            Address address01 = new Address("-", "Wielogłowy", "Polska");
            Address address02 = new Address("Poznańska", "Kraków", "Polska");

            Supplier supplier01 = new Supplier("supplier01", address01, "0123");
            Supplier supplier02 = new Supplier("supplier02", address02, "3210");
            supplier01.addProduct(product01);
            supplier01.addProduct(product02);
            supplier02.addProduct(product03);
            supplier02.addProduct(product04);

            Category category01 = new Category("category01");
            Category category02 = new Category("category02");
            category01.addProduct(product01);
            category01.addProduct(product02);
            category02.addProduct(product03);
            category02.addProduct(product04);

            Invoice invoice01 = new Invoice(1, 5);
            Invoice invoice02 = new Invoice(2, 3);
            invoice01.addProduct(product01);
            invoice01.addProduct(product02);
            invoice02.addProduct(product03);
            invoice02.addProduct(product04);

            session.save(product01);
            session.save(product02);
            session.save(product03);
            session.save(product04);
            session.save(supplier01);
            session.save(supplier02);
            session.save(category01);
            session.save(category02);
                        session.save(address01);
            session.save(address02);
            session.save(invoice01);
            session.save(invoice02);






        } finally {
            transaction.commit();

            Query products = session.createQuery("from Product");
            Query suppliers = session.createQuery("from Supplier");
            System.out.println(suppliers.list().toString());
            System.out.println(products.list());

            session.close();
        }
    }
}
