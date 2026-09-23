import java.util.Scanner;
public class MyNewRepo {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.printIn("Hello, World");
            System.out.printIn("Enter Your Name:");
            String name = input.nextline();
            System.out.printIn("Nice to meet you, " + name + "!");
        }
    }
}
