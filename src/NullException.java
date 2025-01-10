public class NullException {

    public static Integer generateException() {
        return null;
    }
}

class ThrowException {
    public static void main(String[] args) {
        try {
            Integer result = NullException.generateException();
            System.out.println("Wynik: " + result.toString());
        } catch (NullPointerException e) {

            System.out.println("Błąd: próba operacji na obiekcie o wartości null.");
            System.out.println("\nSzczegóły wyjątku:");
            System.out.println(e.toString());
            System.out.println("\nStos wywołań:");
            e.printStackTrace();
        }
    }
}
