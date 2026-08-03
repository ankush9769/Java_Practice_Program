package AddressMain;
import entites.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class Insert {
    public static void main(String[] args) throws IOException {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Address address = new Address();

        FileInputStream file = new FileInputStream("src/img/catimg.jpg");
        byte[] data = new byte[file.available()];
        file.read(data);
        address.setImage(data);

        address.setStreep("lalaroad");
        address.setCity("mumbai");
        address.setIsopen(Boolean.parseBoolean("true"));
        address.setDate(LocalDate.of(2026,1,23));
        address.setImage(data);
        address.setX(10.2);

        session.persist(address);
        tx.commit();

    }
}
