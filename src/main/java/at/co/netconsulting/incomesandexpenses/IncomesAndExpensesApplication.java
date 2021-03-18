package at.co.netconsulting.incomesandexpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication
//public class IncomesAndExpensesApplication extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
//    {
//        return application.sources(IncomesAndExpensesApplication.class);
//    }
//    public static void main(String[] args) {
//        SpringApplication.run(IncomesAndExpensesApplication.class, args);
//    }
//}

//when using it remotely, use this part
@SpringBootApplication
public class IncomesAndExpensesApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(IncomesAndExpensesApplication.class, args);
    }
}