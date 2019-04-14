package springjpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springjpa.ui.Console;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(
                        "springjpa/config"
                );

        Console console=context.getBean(Console.class);
        console.miniRunConsole();
    }
}
