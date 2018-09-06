package ma.craft.boomer.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ma.craft.boomer.model.Book;
import ma.craft.boomer.repository.BookRepository;

@Component
public class Database implements CommandLineRunner {
    private BookRepository repository;
    @Autowired
    public Database(BookRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
    	   List<Book> books = new ArrayList<Book>();
    	//   books.add(new Book(1,"Antigone" , "jolie", "Jean Anouil"));
    	  // books.add(new Book(2,"Le dernier jour d'un condamné" , "prison", "Victor Hugo"));
    	   //books.add(new Book(3,"La boite à merveille" , "la vie au maroc", "Ahmed Sefrioui"));
    	   repository.saveAll(books);
        
      //TODO remolace ca un fichier sql de test
    }
}
