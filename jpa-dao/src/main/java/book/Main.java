package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;


public class Main {
    /* Készíts a book csomagban egy olyan Main osztályt, melynek main metódusa adott számú (például 1000)
     Book objektumot hoz létre a BookGenerator osztály segítségével, melyeket az adatbázisba ment.
     Az objektumok mentése után listázzuk a konzolra az adatbázisból az összes Book objektumot.*/


    private static void createBooks(BookGenerator gen,BookDao dao, int db){
        try
        {
            for (int i = 0; i < db; i++){
                dao.persist(gen.createBook());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PersistenceModule("jpa-dao-hw"));
        BookDao dao = injector.getInstance(BookDao.class);
        BookGenerator generator = new BookGenerator();

    //creation of random books
    createBooks(generator,dao,50);

    //printing out all books
    dao.findAll().stream().forEach(System.out::println);

    //testing the function
    System.out.println("findby_isbn result: \n"+dao.findByIsbn13(generator.faker.code().isbn13()));
    }

}
