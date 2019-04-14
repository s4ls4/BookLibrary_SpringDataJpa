import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ui.Console;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(
                        "ro.ubb.springjpa.config"
                );

        Console console=context.getBean(Console.class);
        console.runConsole();

        System.out.println("hello");
    }
}
