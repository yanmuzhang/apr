#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.context.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @GetMapping
    public String hello(){
        return "hello";
    }


}
