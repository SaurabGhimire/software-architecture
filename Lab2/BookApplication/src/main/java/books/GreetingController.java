package books;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class GreetingController {

    @GetMapping("/hello")
    @ResponseBody()
    public String sayHello(){
        return "Hello world";
    }
}
