import java.io.*;

public class HackAssembler {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java HackAssembler <filename.asm>");
            return;

        }

        String inputFileName = args[0];
        String outputFileName = inputFileName.endsWith(".asm")
                ? inputFileName.replace(".asm", ".hack")
                : inputFileName + ".hack";

        try {
            SymbolTable symbolTable = new SymbolTable();

            Parser firstPass = new Parser(inputFileName);
            int romAddress = 0;

            while (firstPass.hasMoreCommands()) {
                firstPass.advance();
                String type = firstPass.commandType();

                if (type.equals("L_COMMAND")) {
                    symbolTable.addEntry(firstPass.getSymbol(), romAddress);
                } else {
                    romAddress++;
                }
            }

            Parser secondPass = new Parser(inputFileName);
            PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
            int nextVarAddr = 16;

            while (secondPass.hasMoreCommands()) {
                secondPass.advance();
                String type = secondPass.commandType();

                if (type.equals("A_COMMAND")) {
                    String symbol = secondPass.getSymbol();
                    int address;

                    if (symbol.matches("\\d+")) {
                        address = Integer.parseInt(symbol);
                    } else {
                        if (!symbolTable.contains(symbol)) {
                            symbolTable.addEntry(symbol, nextVarAddr++);
                        }
                        address = symbolTable.getAddress(symbol);
                    }
                    writer.println(formatTo16Bit(address));

                } else if (type.equals("C_COMMAND")) {
                    String binary = "111"
                            + Code.comp(secondPass.comp())
                            + Code.dest(secondPass.dest())
                            + Code.jump(secondPass.jump());
                    writer.println(binary);
                }
            }

            writer.close();
            System.out.println("Successfully generated: " + outputFileName);

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + inputFileName);
        } catch (IOException e) {
            System.err.println("Error reading or writing file.");
            e.printStackTrace();
        }
    }

    private static String formatTo16Bit(int address) {
        String binary = Integer.toBinaryString(address);
        return String.format("%16s", binary).replace(' ', '0');
    }
}