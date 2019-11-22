package com.jCash.web;

import com.jCash.exception.RecordNotFoundException;
import com.jCash.model.TypeOperationsEntity;
import com.jCash.model.OperationsEntity;
import com.jCash.model.UsersEntity;
import com.jCash.service.OperationsService;
import com.jCash.service.UsersService;
import com.jCash.service.TypeOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    private void renderPageOperations(Model model) throws RecordNotFoundException {
        UsersEntity usersEntity = usersService.getUserByName(getCurrentUsername());
        List<OperationsEntity> list = operationsService.getAllByUser(usersEntity);
        model.addAttribute("operations", list);

        List<TypeOperationsEntity> listDebit = typeOperationsService.getAllTypeOperationsByDeditCredit(0);
        model.addAttribute("typeoperationsdebit", listDebit);

        List<TypeOperationsEntity> listCredit = typeOperationsService.getAllTypeOperationsByDeditCredit(1);
        model.addAttribute("typeoperationscredit", listCredit);
    }

    @PostMapping("/operations")
    public String listPostTypeOperationsDebit(
            @RequestParam(name="sellist1", required=false) String sellistDebit,
            @RequestParam(name="sumDebit", required=false) String sumDebit,
            @RequestParam(name="sellist1", required=false) String sellistCredit,
            @RequestParam(name="sumDebit", required=false) String sumCredit,
            Model model) throws RecordNotFoundException {

        OperationsEntity operationsEntity= new OperationsEntity();

       /* operationsEntity.setCard_cash();
        operationsEntity.setComment();
        operationsEntity.setData_operation();
        operationsEntity.setDebit_credit();
        operationsEntity.setSum();
        operationsEntity.setTypeOperation();
        operationsEntity.setUser();*/

        operationsService.addOperation(operationsEntity);

        renderPageOperations(model);
        return "operations";
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String listUserOperations(Model model) throws RecordNotFoundException {
        renderPageOperations(model);
        return "operations";
    }

    @RequestMapping(value = "/typeoperationscredit", method = RequestMethod.GET)
    public String listTypeOperationsCredit(Model model) {
        List<TypeOperationsEntity> list = typeOperationsService.getAllTypeOperationsByDeditCredit(1);
        model.addAttribute("typeoperationscredit", list);
        return "typeoperationscredit";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String IndexUserOperations(Model model) throws RecordNotFoundException {
        renderPageOperations(model);
        return "operations";
    }

}