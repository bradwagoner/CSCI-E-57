package wagoner.brad.harvard.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import wagoner.brad.harvard.crud.book.CreateBookQuery;
import wagoner.brad.harvard.crud.book.DeleteBookQuery;
import wagoner.brad.harvard.crud.book.FindAllBooksByCategoryNameQuery;
import wagoner.brad.harvard.crud.book.GetAllBooksQuery;
import wagoner.brad.harvard.crud.book.GetBookByIdQuery;
import wagoner.brad.harvard.crud.book.UpdateBookQuery;
import wagoner.brad.harvard.dao.BookDao;
import wagoner.brad.harvard.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDaoImpl implements BookDao {

    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @Autowired
    private CreateBookQuery createBookQuery;
    @Autowired
    private DeleteBookQuery deleteBookQuery;
    @Autowired
    private FindAllBooksByCategoryNameQuery findAllBooksByCategoryNameQuery;
    @Autowired
    private GetAllBooksQuery getAllBooksQuery;
    @Autowired
    private GetBookByIdQuery getBookByIdQuery;
    @Autowired
    private UpdateBookQuery updateBookQuery;

    /**
     * Get a list of all of the persisted Books.
     *
     * @return
     */
    @Override
    public List<Book> getAllBooks() {
        logger.debug("Calling getAllBooks()");

        return this.getGetAllBooksQuery().execute();
    }

    /**
     * Get a list of books belonging to a category identified by its name.
     *
     * @param categoryName
     * @return
     */
    @Override
    public List<Book> getBooksByCategoryName(String categoryName) {
        logger.debug("Calling getBooksByCategoryName(" + categoryName + ")");

        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("categoryName", categoryName);

        return this.getFindAllBooksByCategoryNameQuery().executeByNamedParam(namedParameters);
    }

    /**
     * Get the persisted Book represented by the provided id.
     *
     * @param bookId
     * @return
     */
    @Override
    public Book getBookById(Long bookId) {
        logger.debug("Calling getBookById(" + bookId + ")");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bookId", bookId);

        return this.getGetBookByIdQuery().findObjectByNamedParam(parameters);
    }

    /**
     * Persist the provided Book and return the id assigned to it.
     *
     * @param book
     * @return
     */
    @Override
    public Long createBook(Book book) {
        logger.debug("Calling createBook(" + book + ")");

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("category_id", book.getCategoryId());
        parameters.put("isbn", book.getIsbn());
        parameters.put("title", book.getTitle());
        parameters.put("price", book.getPrice());

        this.getCreateBookQuery().updateByNamedParam(parameters, keyHolder);

        return keyHolder.getKey().longValue();
    }

    /**
     * Align the persisted Book with the Book provided.
     *
     * @param book
     */
    @Override
    public void updateBook(Book book) {
        logger.debug("Calling updateBook(" + book + ")");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", book.getId());
        parameters.put("category_id", book.getCategoryId());
        parameters.put("isbn", book.getIsbn());
        parameters.put("title", book.getTitle());
        parameters.put("price", book.getPrice());

        try {
            this.getUpdateBookQuery().updateByNamedParam(parameters);
        } catch (DataIntegrityViolationException dive) {
            logger.error("Caught exception calling updateByNamedParam");
            throw new RuntimeException(dive);
        }
    }

    /**
     * Delete the persisted book represented by the provided id.
     *
     * @param bookId
     */
    @Override
    public void deleteBook(Long bookId) {
        logger.debug("Calling deleteBook(" + bookId + ")");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", bookId);

        this.getDeleteBookQuery().updateByNamedParam(parameters);
    }

    public static Book getBookFromResultSet(ResultSet result) throws SQLException {
        Book book = new Book();
        book.setId(result.getLong("id"));
        book.setCategoryId(result.getLong("category_id"));
        book.setIsbn(result.getString("isbn"));
        book.setPrice(result.getFloat("price"));
        book.setTitle(result.getString("title"));

        return book;
    }

    /*
     * GETTERS AND SETTERS
     */

    public CreateBookQuery getCreateBookQuery() {
        return createBookQuery;
    }

    public void setCreateBookQuery(CreateBookQuery createBookQuery) {
        this.createBookQuery = createBookQuery;
    }

    public DeleteBookQuery getDeleteBookQuery() {
        return deleteBookQuery;
    }

    public void setDeleteBookQuery(DeleteBookQuery deleteBookQuery) {
        this.deleteBookQuery = deleteBookQuery;
    }

    public FindAllBooksByCategoryNameQuery getFindAllBooksByCategoryNameQuery() {
        return findAllBooksByCategoryNameQuery;
    }

    public void setFindAllBooksByCategoryNameQuery(FindAllBooksByCategoryNameQuery findAllBooksByCategoryNameQuery) {
        this.findAllBooksByCategoryNameQuery = findAllBooksByCategoryNameQuery;
    }

    public GetAllBooksQuery getGetAllBooksQuery() {
        return getAllBooksQuery;
    }

    public void setGetAllBooksQuery(GetAllBooksQuery getAllBooksQuery) {
        this.getAllBooksQuery = getAllBooksQuery;
    }

    public GetBookByIdQuery getGetBookByIdQuery() {
        return getBookByIdQuery;
    }

    public void setGetBookByIdQuery(GetBookByIdQuery getBookByIdQuery) {
        this.getBookByIdQuery = getBookByIdQuery;
    }

    public UpdateBookQuery getUpdateBookQuery() {
        return updateBookQuery;
    }

    public void setUpdateBookQuery(UpdateBookQuery updateBookQuery) {
        this.updateBookQuery = updateBookQuery;
    }
}

