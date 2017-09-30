package wagoner.brad.harvard.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Map;
import java.util.Set;

@ComponentScan
public class Category {
    private static Logger logger = LoggerFactory.getLogger(Category.class);

    Long id;

    String name;

    Set<Book> booksSet;

    List<Book> booksList;

    Map<String, Book> booksMap;

    public Category() {
    }

    @Override
    public String toString() {
        String toString = "";

        if (this.getBooksSet() != null) {
            toString += "=================== Books Set Output Start ===================\n";
            toString += "Category -- Id: " + this.getId() + ", Name: " + this.getName() + ": \nBooks Set: " + this.getBooksSet() + "\n";
            toString += "=================== Books Set Output Start ===================" + "\n";
        }

        if (this.getBooksList() != null) {
            toString += "=================== Books List Output Start ===================" + "\n";
            toString += "Category -- Id: " + this.getId() + ", Name: " + this.getName() + ": \nBooks List: " + this.getBooksList() + "\n";
            toString += "=================== Books List Output Start ===================" + "\n";
        }

        if (this.getBooksMap() != null) {
            toString += "=================== Books Map Output Start ===================" + "\n";
            toString += "Category -- Id: " + this.getId() + ", Name: " + this.getName() + ": \nBooks Map: " + this.getBooksMap() + "\n";
            toString += "=================== Books Map Output Start ===================" + "\n";
        }

        return toString;
    }

    /*
     * GETTERS AND SETTERS
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooksSet() {
        return booksSet;
    }

    public void setBooksSet(Set<Book> booksSet) {
        this.booksSet = booksSet;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public Map<String, Book> getBooksMap() {
        return booksMap;
    }

    public void setBooksMap(Map<String, Book> booksMap) {
        this.booksMap = booksMap;
    }
}
