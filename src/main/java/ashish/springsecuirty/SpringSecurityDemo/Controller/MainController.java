package ashish.springsecuirty.SpringSecurityDemo.Controller;

import ashish.springsecuirty.SpringSecurityDemo.Entity.users;
import ashish.springsecuirty.SpringSecurityDemo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public String demo(){
        logger.debug("Testing API hit");
        return "testing API";
    }

    @GetMapping("/getUser")
    public List<users> getusers(){
        logger.debug("Fetching All Users");
        return userService.getUsers();
    }

    @PostMapping("/post")
    public ResponseEntity<String> adduser(@RequestBody users user){
        logger.debug("Adding user:"+user.getUsername());
        String response=userService.addUser(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/userbyid/{id}")
    public Optional<users> findbyid(@PathVariable int id){
        Optional<users> user=userService.getUserbyid(id);
        return user;
    }
}
