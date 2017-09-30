package wagoner.brad.harvard.dao;

import wagoner.brad.harvard.domain.Book;

import java.util.List;

public interface BookDao {

    /**
     * Get a list of all of the persisted Books.
     *
     * @return
     */
    List<Book> getAllBooks();

    /**
     * Get a list of books belonging to a category identified by its name.
     *
     * @param categoryName
     * @return
     */
    List<Book> getBooksByCategoryName(String categoryName);

    /**
     * Get the persisted Book represented by the provided id.
     *
     * @param bookId
     * @return
     */
    Book getBookById(Long bookId);

    /**
     * Persist the provided Book and return the id assigned to it.
     *
     * @param book
     * @return
     */
    Long createBook(Book book);

    /**
     * Align the persisted Book with the Book provided.
     *
     * @param book
     */
    void updateBook(Book book);

    /**
     * Delete the persisted book represented by the provided id.
     *
     * @param bookId
     */
    void deleteBook(Long bookId);
}
