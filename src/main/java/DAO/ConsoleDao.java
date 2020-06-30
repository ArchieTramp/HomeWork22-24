package DAO;

import Pojo.NewGameConsole;

import java.util.List;

public interface ConsoleDao {
    boolean addConsole(NewGameConsole newGameConsole);
    NewGameConsole getConsoleByID(Integer id);
    List<NewGameConsole> getAllConsole();
    NewGameConsole upgradeConsole(Integer id);
    NewGameConsole deleteConsole(Integer id);
}
