import java.nio.file.*;
import java.io.IOException;

public class FileComparator {

    public static void main(String[] args) {
        String file1 = "Pong1.hack";
        String file2 = "Pong.hack";

        try {
            boolean isIdentical = compareFiles(file1, file2);
            if (isIdentical) {
                System.out.println("Identical");
            } else {
                System.out.println("wrong");
            }
        } catch (IOException e) {
            System.err.println("Check your path" + e.getMessage());
        }
    }

    public static boolean compareFiles(String path1, String path2) throws IOException {
        String content1 = Files.readString(Path.of(path1));
        String content2 = Files.readString(Path.of(path2));

        String clean1 = content1.replaceAll("\\s", "");
        String clean2 = content2.replaceAll("\\s", "");

        return clean1.equals(clean2);
    }
}