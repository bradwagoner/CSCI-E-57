package wagoner.brad.harvard.crud.book;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import wagoner.brad.harvard.dao.impl.BookDaoImpl;
import wagoner.brad.harvard.domain.Book;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class FindAllBooksByCategoryNameQuery extends MappingSqlQuery<Book> {

    public static String query = "SELECT book.id, book.category_id, book.isbn, book.title, book.price"
            + " FROM book "
            + " JOIN category ON book.category_id = category.id "
            + "WHERE category.name = :categoryName;";

    public FindAllBooksByCategoryNameQuery(DataSource dataSource) {
        super(dataSource, FindAllBooksByCategoryNameQuery.query);
        super.declareParameter(new SqlParameter("categoryName", Types.VARCHAR));
        compile();
    }

    @Override
    protected Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return BookDaoImpl.getBookFromResultSet(rs);
    }
}
