import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MSConsole implements GameConsole {
    @Override
    public void addToDB() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "20612")) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO consoles (name, model, price, includeGames, company)\n" +
                    "VALUES \n" +
                    "('XBOX', 'SeriesX', 50000, 3, 'MS')");
        }
        System.out.println("Inserted new XBOX");
    }
}
