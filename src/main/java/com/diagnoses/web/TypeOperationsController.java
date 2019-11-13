package com.diagnoses.web;

import com.diagnoses.model.DiagnosesEmptity;
import com.diagnoses.service.TypeOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        List<DiagnosesEmptity> list = tService.getAllTypeOperations();
        model.addAttribute("type", list);
        return "type";
    }

}