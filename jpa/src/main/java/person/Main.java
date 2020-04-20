package person;

import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;

public class Main {
    //private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
    private static Faker faker = new Faker();

   /* private void createPersons(){
        EntityManager em = emf.createEntityManager();

            try {
                em.getTransaction().begin();
               // em.persist();

                em.getTransaction().commit();
            } finally {
                em.close();
            }

    }*/

    private static Person randomPerson(){
        Person person = Person.builder()
                .name(faker.name().fullName())
                .dob(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .gender(faker.options().option(Person.Gender.class))
                .address(faker.address())
                .email(faker.internet().emailAddress())
                .profession(faker.company().profession())
                .build();
        System.out.println(person);
        return person;

    }


    public static void main(String[] args) {
        randomPerson();

      /*  for (int i=0;i<db;i++) {

        }
      */




    }
}
