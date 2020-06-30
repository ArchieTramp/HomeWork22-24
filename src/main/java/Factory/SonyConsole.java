package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SonyConsole implements GameConsole {
    @Override
    public void addToDB() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "20612")) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO consoles (name, model, price, includeGames, company)\n" +
                    "VALUES \n" +
                    "('PS', '5 PRO', 60000, 2, 'Sony')");
        }
        System.out.println("Inserted new PS");
    }
}
