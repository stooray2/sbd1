package nz.ac.op.SpringAPIDemo1.resource;

import nz.ac.op.SpringAPIDemo1.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"John", "john@op.ac.nz"));
        users.add(new User(2,"Sara", "john@op.ac.nz"));
        users.add(new User(3,"Tiara", "john@op.ac.nz"));
        users.add(new User(4,"Ali", "john@op.ac.nz"));

        return users;

    }

}
