public class MSConsoleFactory implements ConsoleFactory{
    @Override
    public GameConsole createConsole() {
        return new MSConsole();
    }
}
