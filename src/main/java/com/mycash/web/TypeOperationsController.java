package com.mycash.web;

import com.mycash.model.TypeOperationsEntity;
import com.mycash.model.UsersEntity;
import com.mycash.service.TypeOperatorService;
import com.mycash.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeOperationsController {
    private TypeOperatorService tService;

    @Autowired(required = true)
    public void setUsersService(TypeOperatorService tService) {
        this.tService = tService;
    }

    @RequestMapping(value = "type", method = RequestMethod.GET)
    public String listBooks(Model model){
        List<TypeOperationsEntity> list = tService.getAllTypeOperations();
        model.addAttribute("type", list);
        return "type";
    }

}