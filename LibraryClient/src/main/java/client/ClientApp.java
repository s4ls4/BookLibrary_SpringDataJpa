package client;

import client.config.ClientConfig;
import client.ui.Console;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import web.dto.BookDto;
import web.dto.BooksDto;

public class ClientApp {

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(
//                        "client.config"
//                );
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(ClientConfig.class);
        context.refresh();


        Console console = context.getBean(Console.class);
        console.miniRunConsole();

    }
}
