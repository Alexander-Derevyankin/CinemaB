package cinema.cronc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CinemaProjectCourseWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaProjectCourseWorkApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfig(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
//                .allowedOrigins("http://localhost:3000")
                        .allowedMethods("PUT", "DELETE", "GET", "POST")
                        .allowedHeaders("Access-Control-Allow-Origin", " $http_origin", "Origin", "Content-Type", "Accept")
                        .exposedHeaders("Access-Control-Allow-Origin", " $http_origin", "Origin", "Content-Type", "Accept")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }

}
