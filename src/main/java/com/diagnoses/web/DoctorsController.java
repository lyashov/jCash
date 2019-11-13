package com.diagnoses.web;

import com.diagnoses.model.DoctorsEntity;
import com.diagnoses.service.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DoctorsController {
    private DoctorsService doctorsService;

    @Autowired(required = true)
    public void setdoctorsService(DoctorsService doctorsService) {
        this.doctorsService = doctorsService;
    }

    @RequestMapping(value = "doctors", method = RequestMethod.GET)
    public String listDoctors(Model model){
        List<DoctorsEntity> list = doctorsService.getAllDoctors();
        model.addAttribute("doctors", list);
        return "doctors";
    }


    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Username") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}