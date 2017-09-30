package wagoner.brad.harvard.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import wagoner.brad.harvard.dao.BookDao;
import wagoner.brad.harvard.dao.CategoryDao;
import wagoner.brad.harvard.domain.Book;
import wagoner.brad.harvard.domain.Category;

/**
 * Vitale's CSCI E-57 Assignment-1.2 Spring JDBC
 */
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/app-context.xml", "classpath:META-INF/spring/*-config.xml");
        context.refresh();

        logger.info("App context is loaded.");

        // Load a BookDao implementation and exercise its methods.
        BookDao bookDao = context.getBean("bookDao", BookDao.class);
        logger.debug("App loaded bookDao bean: " + bookDao);

        // Load a CategoryDao implementation and exercise its methods.
        CategoryDao categoryDao = context.getBean("categoryDao", CategoryDao.class);
        logger.debug("App loaded categoryDao: " + categoryDao);


        /**
         * FIND BOOKS BY CATEGORY NAME
         */
        logger.info("\n");
        logger.info("==== Finding Books by Category('Romance') Start ====");
        bookDao.getBooksByCategoryName("Romance").forEach(book ->
                logger.info(book.toString())
        );
        logger.info("==== Finding Books by Category('Romance') End ====");

        logger.info("\n");
        logger.info("==== Finding Books by Category('Drama') Start ====");
        bookDao.getBooksByCategoryName("Drama").forEach(book ->
                logger.info(book.toString())
        );
        logger.info("==== Finding Books by Category('Drama') End ====");


        /**
         * FIND ALL CATEGORIES
         */
        logger.info("\n");
        logger.info("==== Finding all Categories Start ====");
        categoryDao.getAllCategories().forEach(category ->
            logger.info(category.toString())
        );
        logger.info("==== Finding all Categories End ====");


        /**
         * FIND ALL BOOKS
         */
        logger.info("\n");
        logger.info("==== Testing Find All Books Start ====");
        bookDao.getAllBooks().forEach(book -> logger.info(book.toString()));
        logger.info("==== Testing Find All Books End ====");

        /**
         * INSERT ONE BOOK
         */
        Book book = new Book();
        book.setIsbn("000111000");
        book.setTitle("This is a new book!");
        book.setPrice(6.99F);
        book.setCategoryId(2L);
        Long newBookId = bookDao.createBook(book);

        logger.info("\n");
        logger.info("==== Testing Create A New Book Start ====");
        logger.info("Creating new book: " + book);
        logger.info("Looked up book by id(" + newBookId + "): " + bookDao.getBookById(newBookId));
        logger.info("==== Testing Creating A New Book End ====");


        /**
         * UPDATE THE NEW BOOK
         */
        book.setTitle("This is a much better title.");
        book.setPrice(99.99F);
        book.setIsbn("0000000000");
        book.setCategoryId(2L);
        book.setId(newBookId);

        bookDao.updateBook(book);

        logger.info("\n");
        logger.info("==== Testing Update Book Start ====");
        logger.info("Updating book: " + book);
        logger.info("Looked up updated book: " + bookDao.getBookById(newBookId));
        logger.info("==== Testing Update Book End ====");


        /**
         * DELETE THE NEW BOOK
         */
        logger.info("\n");
        logger.info("==== Testing Delete Book Start ====");
        logger.info("Deleting book by id: " + newBookId);

        bookDao.deleteBook(newBookId);

        logger.info("Lookup by deleted book id(" + newBookId + "): '" + bookDao.getBookById(newBookId) + "'");
        logger.info("==== Testing Delete Book End ====");

        /**
         * CREATE A NEW CATEGORY (OPTIONAL)
         */
        Category category = new Category();
        category.setName("New Category");

        Long newCategoryId = categoryDao.createCategory(category);

        Category lookedUpCategory = categoryDao.getCategoryById(newCategoryId);

        logger.debug("\n");
        logger.debug("==== Testing Create Category Begin ====");
        logger.debug("Creating category: " + category);
        logger.debug("New category id: " + newCategoryId);
        logger.debug("Looked up new category:" + lookedUpCategory);
        logger.debug("==== Testing Create Category End ====");

        /**
         * Edit a Category (OPTIONAL)
         */
        category.setId(newCategoryId);
        category.setName("This is a way better name.");

        categoryDao.updateCategory(category);

        lookedUpCategory = categoryDao.getCategoryById(newCategoryId);

        logger.debug("\n");
        logger.debug("==== Testing Edit Category Begin ====");
        logger.debug("Updating category: " + category);
        logger.debug("Looked up updated category:" + lookedUpCategory);
        logger.debug("==== Testing Edit Category End ====");

        /**
         * Testing Delete a Category (OPTIONAL)
         */
        categoryDao.deleteCategory(newCategoryId);

        lookedUpCategory = categoryDao.getCategoryById(newCategoryId);

        logger.debug("\n");
        logger.debug("==== Testing Delete Category Begin ====");
        logger.debug("Looked up deleted category:" + lookedUpCategory);
        logger.debug("==== Testing Delete Category End ====");

    }
}
