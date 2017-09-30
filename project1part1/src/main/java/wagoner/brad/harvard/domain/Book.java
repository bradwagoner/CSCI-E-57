package wagoner.brad.harvard.domain;

public class Book {

    Long id;

    String isbn;

    String title;

    Float price;

    public Book() {
    }

    @Override
    public String toString() {
        String toString = "";

        toString += "Book - Id: " + this.getId();
        toString += ", ISBN: " + this.getIsbn();
        toString += ", Title: " + this.getTitle();
        toString += ", Price: " + this.getPrice();

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
