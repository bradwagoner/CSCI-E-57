package wagoner.brad.harvard.crud.book;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import wagoner.brad.harvard.dao.impl.BookDaoImpl;
import wagoner.brad.harvard.domain.Book;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class DeleteBookQuery extends SqlUpdate {

    public static String query = "DELETE FROM book WHERE id = :id";

    public DeleteBookQuery(DataSource dataSource) {
        super(dataSource, DeleteBookQuery.query);
        super.declareParameter(new SqlParameter("id", Types.BIGINT));
        compile();
    }
}
