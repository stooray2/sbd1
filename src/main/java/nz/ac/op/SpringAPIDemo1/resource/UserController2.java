package nz.ac.op.SpringAPIDemo1.resource;

import nz.ac.op.SpringAPIDemo1.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users2")
public class UserController2 {
    List<User> users;

    public UserController2(){
        users = new ArrayList<>();
        users.add(new User(1,"John", "john@op.ac.nz"));
        users.add(new User(2,"Sara", "sara@op.ac.nz"));
        users.add(new User(3,"Tiara", "tiara@op.ac.nz"));
        users.add(new User(4,"Ali", "ali@op.ac.nz"));
    }

    @GetMapping
    public List<User> getUsers(){
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        for(User u : users){
            if(u.getId() == id)
                return u;
        }
        return null; // Consider throwing an exception for better error handling
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        users.add(user);
        return "User added successfully";
    }
    @PutMapping
    public String updateUser(@RequestBody User user){
        int id =user.getId();
        for(User u:users){
            if(u.getId()==id){
                u.setEmail(user.getEmail());
                u.setName(user.getName());
                return "User updated successfully";
            }
        }

        return "User not found";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){

        for(User u:users){
            if(u.getId()== id){
                users.remove(u);
                return "User removed successfully";
            }
        }
        return "User not found";
    }


}
