package com.jCash.web;

import com.jCash.model.TypeOperationsEntity;
import com.jCash.model.OperationsEntity;
import com.jCash.model.UsersEntity;
import com.jCash.service.OperationsService;
import com.jCash.service.UsersService;
import com.jCash.service.TypeOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    private UsersService usersService;
    private TypeOperationsService typeOperationsService;
    private OperationsService operationsService;

    @Autowired(required = true)
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired(required = true)
    public void setTypeOperationsService(TypeOperationsService typeOperationsService) {
        this.typeOperationsService = typeOperationsService;
    }

    @Autowired(required = true)
    public void setOperationsService(OperationsService operationsService) {
        this.operationsService = operationsService;
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model){
        List<UsersEntity> list = usersService.getAllUsers();
        model.addAttribute("users", list);
        return "users";
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String listOperations(Model model){
        List<OperationsEntity> list = operationsService.getAllOperations();
        model.addAttribute("operations", list);
        return "operations";
    }

    @RequestMapping(value = "/typeoperations", method = RequestMethod.GET)
    public String listTypeOperations(Model model) {
        List<TypeOperationsEntity> list = typeOperationsService.getAllTypeOperations();
        model.addAttribute("typeoperations", list);
        return "typeoperations";
    }

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Username") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}