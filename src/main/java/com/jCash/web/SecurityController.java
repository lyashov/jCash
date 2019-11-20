package com.jCash.web;

import com.jCash.exception.RecordNotFoundException;
import com.jCash.model.UsersEntity;
import com.jCash.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SecurityController {


    @GetMapping("/login")
    public String login(@RequestParam(name="name", required=false, defaultValue="Username") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @Autowired
    private UsersRepository usersRepo;

    @GetMapping("/registration")
    public String registration() {
      //  UsersEntity userFromDB = usersService.getUserByName(usersEntity.getUsername());
     //   if(userFromDB != null){
           // model.
     //   }
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam(name="username", required=false, defaultValue="Username") String name, Model model) throws RecordNotFoundException {

        UsersEntity usr = usersRepo.findByUsername("Vasua");
        if(usr != null){
            model.addAttribute("message", "User exists!");
            return "registration";
        }
     //   usr.setActive(true);
     //   usr.setRoles(Collections.singleton(Role.USER));
      //  usr.
        return "redirect:/login";
    }
}
