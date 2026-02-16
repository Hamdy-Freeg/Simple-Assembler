public class Code {
    public static String dest(String mnemonic) {
        int d1 = (mnemonic != null && mnemonic.contains("A")) ? 1 : 0;
        int d2 = (mnemonic != null && mnemonic.contains("D")) ? 1 : 0;
        int d3 = (mnemonic != null && mnemonic.contains("M")) ? 1 : 0;
        return "" + d1 + d2 + d3;
    }

    public static String jump(String mnemonic) {
        if (mnemonic == null) return "000";
        switch (mnemonic) {
            case "JGT": return "001"; case "JEQ": return "010"; case "JGE": return "011";
            case "JLT": return "100"; case "JNE": return "101"; case "JLE": return "110";
            case "JMP": return "111"; default: return "000";
        }
    }

    public static String comp(String mnemonic) {


        switch (mnemonic) {
            case "0":   return "0101010";
            case "1":   return "0111111";
            case "-1":  return "0111010";
            case "D":   return "0001100";
            case "A":   return "0110000";
            case "!D":  return "0001101";
            case "!A":  return "0110001";
            case "-D":  return "0001111";
            case "-A":  return "0110011";
            case "D+1": return "0011111";
            case "A+1": return "0110111";
            case "D-1": return "0001110";
            case "A-1": return "0110010";
            case "D+A": return "0000010";
            case "D-A": return "0010011";
            case "A-D": return "0000111";
            case "D&A": return "0000000";
            case "D|A": return "0010101";

            case "M":   return "1110000";
            case "!M":  return "1110001";
            case "-M":  return "1110011";
            case "M+1": return "1110111";
            case "M-1": return "1110010";
            case "D+M": return "1000010";
            case "D-M": return "1010011";
            case "M-D": return "1000111";
            case "D&M": return "1000000";
            case "D|M": return "1010101";

            default: return "0000000";
        }
    }}
