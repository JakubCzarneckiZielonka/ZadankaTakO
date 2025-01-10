import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileAutoClose {
    public static void main(String[] args) {
        // Pliki źródłowy i docelowy
        String sourceFile = "kods.txt";
        String targetFile = "XPP.txt";

        // Mechanizm automatycznego zarządzania zasobami (try-with-resources)
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile)) {

            int bajt;

            while ((bajt = fis.read()) != -1) {
                if (bajt == ' ') {
                    bajt = '-';
                }
                fos.write(bajt);
            }
            System.out.println("File copied successfully from " + sourceFile + " to " + targetFile);

        } catch (IOException e) {

            System.out.println("An error occurred while processing files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
