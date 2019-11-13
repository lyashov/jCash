package com.diagnoses.web;

import com.diagnoses.model.DoctorsEntity;
import com.diagnoses.model.PacientsEntity;
import com.diagnoses.service.DoctorsService;
import com.diagnoses.service.PacientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PacientsController {
    private PacientsService pacientsService;

    @Autowired(required = true)
    public void setPacientsService(PacientsService pacientsService) {
        this.pacientsService = pacientsService;
    }

    @RequestMapping(value = "pacients", method = RequestMethod.GET)
    public String listDoctors(Model model){
        List<PacientsEntity> list = pacientsService.getAllPacients();
        model.addAttribute("pacients", list);
        return "pacients";
    }


    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Username") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}