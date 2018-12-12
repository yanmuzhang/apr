#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
${symbol_pound}set(${symbol_dollar}symbol_pound='${symbol_pound}')
${symbol_pound}set(${symbol_dollar}symbol_dollar='${symbol_dollar}')
${symbol_pound}set(${symbol_dollar}symbol_escape='${symbol_escape}' )
package ${symbol_dollar}{package}.context;
 
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient 
@MapperScan("${symbol_dollar}{package}.context.repository")
@ComponentScans({
        @ComponentScan("${symbol_dollar}{package}.context.repository")
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}