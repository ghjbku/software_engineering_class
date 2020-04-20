package person;

import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;

public class Main {
    private static EntityManagerFactory emf;
    private static Faker faker = new Faker();

    private static void createPersons(int db){
        emf = Persistence.createEntityManagerFactory("jpa-hw");
        EntityManager em = emf.createEntityManager();



            try
            {
                for (int i=0;i<db;i++) {
                    em.getTransaction().begin();
                    em.persist(randomPerson());
                    em.getTransaction().commit();
                }
            }
            finally
            {
                em.close();
            }
    }

    private static Person randomPerson(){
        Person person = Person.builder()
                .name(faker.name().fullName())
                .dob(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .gender(faker.options().option(Person.Gender.class))
                .address(new Address(faker.address().country(),faker.address().state(),faker.address().city(),faker.address().streetAddress(),faker.address().zipCode()))
                .email(faker.internet().emailAddress())
                .profession(faker.company().profession())
                .build();
        System.out.println(person);
        return person;

    }


    public static void main(String[] args) {
        createPersons(10);




    }
}
