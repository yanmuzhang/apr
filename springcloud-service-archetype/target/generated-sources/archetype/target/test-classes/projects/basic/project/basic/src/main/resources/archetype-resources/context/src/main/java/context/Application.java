#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.context;
 
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient 
@MapperScan("${package}.context.repository")
@ComponentScans({
        @ComponentScan("${package}.context.repository")
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}