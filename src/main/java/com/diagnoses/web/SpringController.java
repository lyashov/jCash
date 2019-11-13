package com.diagnoses.web;

import com.diagnoses.model.DiagnosesEmptity;
import com.diagnoses.model.DoctorsEntity;
import com.diagnoses.model.PacientsEntity;
import com.diagnoses.model.VisitsEntity;
import com.diagnoses.service.DiagnosesService;
import com.diagnoses.service.DoctorsService;
import com.diagnoses.service.PacientsService;
import com.diagnoses.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpringController {
    private DoctorsService doctorsService;
    private PacientsService pacientsService;
    private DiagnosesService diagnosesService;
    private VisitsService visitsService;

    @Autowired(required = true)
    public void setDiagnosesService(DiagnosesService diagnosesService) {
        this.diagnosesService = diagnosesService;
    }

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

    @Autowired(required = true)
    public void setPacientsService(PacientsService pacientsService) {
        this.pacientsService = pacientsService;
    }

    @RequestMapping(value = "pacients", method = RequestMethod.GET)
    public String listPacients(Model model){
        List<PacientsEntity> list = pacientsService.getAllPacients();
        model.addAttribute("pacients", list);
        return "pacients";
    }

    @RequestMapping(value = "visits", method = RequestMethod.GET)
    public String listVisits(Model model){
        List<VisitsEntity> list = visitsService.getAllVisits();
        model.addAttribute("visits", list);
        return "visits";
    }


    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Username") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}