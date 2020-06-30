package Factory;

public class SonyConsoleFactory implements ConsoleFactory {

    @Override
    public GameConsole createConsole() {
        return new SonyConsole();
    }
}
