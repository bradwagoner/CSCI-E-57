package wagoner.brad.harvard.crud.book;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import wagoner.brad.harvard.dao.impl.BookDaoImpl;
import wagoner.brad.harvard.domain.Book;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

public class CreateBookQuery extends SqlUpdate {

    private static final String query = "INSERT INTO book (category_id, isbn, title, price)" +
            " VALUES (:category_id, :isbn, :title, :price);";

    public CreateBookQuery(DataSource dataSource) {
        super(dataSource, CreateBookQuery.query);

        super.declareParameter(new SqlParameter("category_id", Types.BIGINT));
        super.declareParameter(new SqlParameter("isbn", Types.VARCHAR));
        super.declareParameter(new SqlParameter("title", Types.VARCHAR));
        super.declareParameter(new SqlParameter("price", Types.DECIMAL));

        super.setReturnGeneratedKeys(true);

        compile();
    }
}
