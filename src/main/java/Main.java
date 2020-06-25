import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "20612")) {
            DataBase.dataBase(connection);
        }
        ConsoleFactory consoleFactory = new SonyConsoleFactory();
        GameConsole gameConsole = consoleFactory.createConsole();
        gameConsole.addToDB();

        ConsoleFactory consoleFactory1 = new MSConsoleFactory();
        GameConsole gameConsole1 = consoleFactory1.createConsole();
        gameConsole1.addToDB();

        ConsoleFactory consoleFactory2 = new NintendoConsoleFactory();
        GameConsole gameConsole2 = consoleFactory2.createConsole();
        gameConsole2.addToDB();

    }
}
