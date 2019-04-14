import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ui.Console;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(
                        "config"
                );

        Console console=context.getBean(Console.class);
        console.miniRunConsole();
    }
}
