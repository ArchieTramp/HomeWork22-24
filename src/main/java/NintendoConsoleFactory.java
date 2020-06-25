public class NintendoConsoleFactory implements ConsoleFactory{
    @Override
    public GameConsole createConsole() {
        return new NintendoConsole();
    }
}
