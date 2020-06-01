package cn.yqd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationMain.class).profiles(args[0]).run(args);
    }

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/getName")
    public String getName() {
        return context.getEnvironment().getProperty("book.another");
    }
}
