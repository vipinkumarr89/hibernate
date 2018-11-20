package MyPackage.app;
import MyPackage.config.HibernateUtils;
import MyPackage.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class StudentDAOImpl {
    public static void main(String[] args) throws Exception{
        SessionFactory sf = HibernateUtils.getSessionFactory(); // Creating connection
        Session session = sf.openSession();                     // Opening session
        Transaction tx = session.beginTransaction();            // Starting Transaction
        Scanner sc = new Scanner(System.in);                    // taking input from client
        String req = "Y";
        while (req.equalsIgnoreCase("Y")) {          // take input while input is N
            System.out.println("enter sname, smarks:");
            String sname = sc.next();
            int smarks = sc.nextInt();
            MyPackage.domain.Student st = new MyPackage.domain.Student(sname, smarks);
            session.save(st);
            System.out.print("Do you want to add new student [Y/N]? ");
            req = sc.next();
        }
        System.out.println("------------------------------------------------------------------------");
        tx.commit();                                              //a - loading student record is completed
        session.close();

        Thread.sleep(2000);
        session = sf.openSession();
        tx = session.beginTransaction();
        Student st = new Student(1, "Vipin Kumar", 92);
        session.update(st);
        System.out.println("------------------------------------------------------------------------");
        tx.commit();                                              //b -  Student update record is completed
        session.close();

        // Creating student object again to delete a record
        Thread.sleep(2000);
        session = sf.openSession();
        tx = session.beginTransaction();
        st = session.get(Student.class, new Integer(2));
        if (st != null) {
            System.out.println(st);
            session.delete(st);
        } else
            System.out.println("No Match found");
        System.out.println("------------------------------------------------------------------------");
        tx.commit();                                               //c - Deleting a record is completed
        session.close();

        // Listing all the records of studentdb table
        Thread.sleep(2000);
        session = sf.openSession();
        TypedQuery <Student> query = session.createQuery("from MyPackage.domain.Student");
        List <Student> studentList = query.getResultList();
        for (Student student : studentList) {
            System.out.println(student);
        }                                                           //d -  Listing all records is completed
        System.out.println("------------------------------------------------------------------------");
        session.close();
        sf.close();
    }
}
