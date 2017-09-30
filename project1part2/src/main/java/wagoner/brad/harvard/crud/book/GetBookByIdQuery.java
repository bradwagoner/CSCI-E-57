package wagoner.brad.harvard.crud.book;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import wagoner.brad.harvard.dao.impl.BookDaoImpl;
import wagoner.brad.harvard.domain.Book;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class GetBookByIdQuery extends MappingSqlQuery<Book> {

    public static String query = "SELECT book.id, book.category_id, book.isbn, book.title, book.price"
            + " FROM book "
            + "WHERE book.id = :bookId;";

    public GetBookByIdQuery(DataSource dataSource) {
        super(dataSource, GetBookByIdQuery.query);
        super.declareParameter(new SqlParameter("bookId", Types.BIGINT));
        compile();
    }

    @Override
    protected Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return BookDaoImpl.getBookFromResultSet(rs);
    }
}
