package wagoner.brad.harvard.crud.category;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Types;

public class CreateCategoryQuery extends SqlUpdate {

    private static final String query = "INSERT INTO category (name) VALUES (:name)";

    public CreateCategoryQuery(DataSource dataSource) {
        super(dataSource, CreateCategoryQuery.query);

        super.declareParameter(new SqlParameter("name", Types.VARCHAR));

        super.setReturnGeneratedKeys(true);

        compile();
    }
}
