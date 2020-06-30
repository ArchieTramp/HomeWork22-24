package Factory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    public static void dataBase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("-- Database: postgres\n "
                    + "DROP TABLE IF EXISTS consoles;"
                    + "\n"
                    + "CREATE TABLE consoles (\n"
                    + "id bigserial primary key,\n"
                    + "name varchar(100) NOT NULL, \n"
                    + "model varchar(100) NOT NULL, \n"
                    + "price integer NOT NULL, \n"
                    + "includeGames integer NOT NULL, \n"
                    + "company varchar(100) NOT NULL);"
                    + "\n"
                    + "INSERT INTO consoles (name, model, price, includeGames, company)\n"
                    + "VALUES\n"
                    + "('PS', '4', 20000, 2, 'Sony'),\n"
                    + "('XBOX', 'One', 18000, 1, 'MS'),\n"
                    + "('Switch', 'Lite', 12000, 0, 'Nintendo'),\n"
                    + "('PS', '5', 40000, 3, 'Sony');"
                    + "\n");
        }
    }
}
