package DAO;

import Connections.ConnectionManager;
import Pojo.NewGameConsole;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@EJB
public class ConsoleDaoJDBC implements ConsoleDao {
    public static final String INSERT_INTO_CONSOLES = "INSERT INTO consoles values (DEFAULT, ?, ?, ?, ?, ?)";
    public static final String SELECT_FROM_CONSOLES = "SELECT * FROM consoles WHERE id = ?";
    public static final String SELECT_ALL_FROM_CONSOLES = "SELECT * FROM consoles";
    public static final String UPDATE_CONSOLES = "UPDATE consoles SET name=?, model=?, price=?, includeGames=?, company=? WHERE id=?";
    public static final String DELETE_FROM_CONSOLES = "DELETE FROM consoles WHERE id=?";
    public static final String CREATE_TABLE_CONSOLES
            = "DROP TABLE IF EXISTS consoles;\n"
            + "create table consoles\n"
            + "(\n"
            + "    id bigserial not null\n"
            + "        constraint consoles_pkey\n"
            + "            primary key,\n"
            + "    name varchar(100) not null, \n"
            + "    model varchar(100) not null,\n"
            + "    price integer not null,\n"
            + "    includeGames integer not null,\n"
            + "    company varchar(100) not null\n"
            + ");\n";

    private ConnectionManager connectionManager;

    @Inject
    public ConsoleDaoJDBC(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }


    @Override
    public boolean addConsole(NewGameConsole newGameConsole) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CONSOLES)) {
            preparedStatement.setString(1, newGameConsole.getName());
            preparedStatement.setString(2, newGameConsole.getModel());
            preparedStatement.setInt(3, newGameConsole.getPrice());
            preparedStatement.setInt(4, newGameConsole.getIncludeGames());
            preparedStatement.setString(5, newGameConsole.getCompany());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public NewGameConsole getConsoleByID(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CONSOLES)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new NewGameConsole(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getString(6));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public List<NewGameConsole> getAllConsole() {
        List<NewGameConsole> listconsoles = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_CONSOLES);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listconsoles.add(new NewGameConsole(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getString(6)));
            }
            return listconsoles;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void upgradeConsole(Integer id, NewGameConsole newGameConsole) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONSOLES)) {
            preparedStatement.setInt(6, id);
            preparedStatement.setString(1, newGameConsole.getName());
            preparedStatement.setString(2, newGameConsole.getModel());
            preparedStatement.setInt(3, newGameConsole.getPrice());
            preparedStatement.setInt(4, newGameConsole.getIncludeGames());
            preparedStatement.setString(5, newGameConsole.getCompany());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public NewGameConsole deleteConsole(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_CONSOLES)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


}

