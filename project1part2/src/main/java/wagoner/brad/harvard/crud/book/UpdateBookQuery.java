package wagoner.brad.harvard.crud.book;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.transaction.annotation.Transactional;
import wagoner.brad.harvard.dao.impl.BookDaoImpl;
import wagoner.brad.harvard.domain.Book;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class UpdateBookQuery extends SqlUpdate {

    public static String query = "UPDATE book "
            + " SET category_id = :category_id,"
            + "isbn = :isbn,"
            + "title = :title,"
            + "price = :price "
            + "WHERE id = :id";

    public UpdateBookQuery(DataSource dataSource) {
        super(dataSource, UpdateBookQuery.query);
        super.declareParameter(new SqlParameter("category_id", Types.BIGINT));
        super.declareParameter(new SqlParameter("isbn", Types.VARCHAR));
        super.declareParameter(new SqlParameter("title", Types.VARCHAR));
        super.declareParameter(new SqlParameter("price", Types.DECIMAL));
        super.declareParameter(new SqlParameter("id", Types.BIGINT));
        compile();
    }
}
