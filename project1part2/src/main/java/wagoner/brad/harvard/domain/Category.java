package wagoner.brad.harvard.domain;

import java.util.Set;

public class Category {

    Long id;

    String name;

    Set<Book> booksSet;

    public Category() {
    }

    @Override
    public String toString() {
        String toString = "";

        toString += "Id: " + this.getId() + ", Name: " + this.getName();

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
}
