package org.innovation.day;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by kondrak on 8/24/17.
 */
@SpringBootApplication/*(exclude = MessageSourceAutoConfiguration.class)*/
public class SpringServletInitializer extends SpringBootServletInitializer {

   /*public static void main(String[] args) {
      SpringApplication.run(ServletInitializer.class, args);
   }*/

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringServletInitializer.class);
    }
}
