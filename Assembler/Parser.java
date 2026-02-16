import java.io.*;
import java.util.Scanner;

public class Parser {
    private Scanner scanner;
    private String currentCommand;
    public String getCurrentCommand() {
        return this.currentCommand;
    }
    public String commandType() {
        if (currentCommand.startsWith("@")) {
            return "A_COMMAND";
        } else if (currentCommand.startsWith("(")) {
            return "L_COMMAND";
        } else {
            // لو مش بيبدأ بـ @ ولا بـ ( يبقى أكيد C-instruction
            return "C_COMMAND";
        }
    }
    public Parser(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new File(fileName));
    }

    public boolean hasMoreCommands() { return scanner.hasNextLine(); }

    public void advance() {
        String line = scanner.nextLine();
        int commentIndex = line.indexOf("//");
        if (commentIndex != -1) line = line.substring(0, commentIndex);
        currentCommand = line.trim().replaceAll("\\s", "");

        if (currentCommand.isEmpty() && hasMoreCommands()) advance();
    }

    public String getSymbol() {
        return currentCommand.replace("@", "").replace("(", "").replace(")", "");
    }

    public String dest() {
        if (currentCommand.contains("=")) return currentCommand.split("=")[0];
        return null;
    }
    public String comp() {
        String temp = currentCommand;
        if (temp.contains("=")) temp = temp.split("=")[1];
        if (temp.contains(";")) temp = temp.split(";")[0];
        return temp;
    }
    public String jump() {
        if (currentCommand.contains(";")) return currentCommand.split(";")[1];
        return null;
    }
}