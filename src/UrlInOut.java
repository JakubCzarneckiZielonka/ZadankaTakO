import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlInOut {
    public static void main(String[] args) {

        String urlAddress = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            // Pobranie pierwszych trzech cyfr konta od użytkownika
            System.out.println("Enter the first three digits of the bank account:");
            String accountNumber = consoleReader.readLine().trim();

            // Wczytanie danych z URL
            try (BufferedReader urlReader = new BufferedReader(new InputStreamReader(new URL(urlAddress).openStream()))) {
                String line;
                boolean bankFound = false;

                System.out.println("Reading data from the file...");
                while ((line = urlReader.readLine()) != null) {
                    String[] words = line.split("\\t+");

                    if (words.length >= 2) {
                        String bankNumber = words[0].trim();
                        String bankName = words[1].trim();

                        if (bankNumber.equals(accountNumber)) {
                            System.out.println("Bank number: " + bankNumber);
                            System.out.println("Your bank name is: " + bankName);
                            bankFound = true;
                            break;
                        }
                    }
                }

                if (!bankFound) {
                    System.out.println("No matching bank found for the given account number.");
                }
            } catch (IOException e) {
                System.out.println("Error reading data from the URL: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error reading input from user: " + e.getMessage());
        }
    }
}

