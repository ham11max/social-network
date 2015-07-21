package controller;

/**
 * Created by HAMMAX on 18.07.2015.
 */
import model.CheckLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import java.util.*;


@Controller
public class UserController {

        @Autowired
        private UserService userServices;

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView printWelcome(ModelMap model) {
            ModelAndView a  = new ModelAndView("home");
            return a;

        }


        @RequestMapping(value = "/auth", method = RequestMethod.POST)
        public ModelAndView login(
                @ModelAttribute@RequestParam(value = "login") String login,
                @ModelAttribute@RequestParam(value = "password") String pass) {
            System.out.println("controller login: " + login);
            System.out.println("controller password: " + pass);
            ModelAndView model = new ModelAndView();
            model.addObject("login",login);
            if (userServices.checkForLogining(login,pass)){
                model.setViewName("loginSucces");
            } else {
                model.setViewName("error");
            }
            return model;

        }


        @RequestMapping(value ="/reg", method = RequestMethod.GET)
        public ModelAndView getRegPage(){
            ModelAndView reg =  new ModelAndView("registration");
            return reg;

        }


        @RequestMapping(value ="/log", method = RequestMethod.GET)
        public ModelAndView getLoginPage(){
            ModelAndView log =  new ModelAndView("login");
            return log ;

        }


        @RequestMapping(value = "/registrationStatus", method = RequestMethod.POST)
        public ModelAndView registrationPage(@RequestParam(value = "name")  String name,
                                         @RequestParam(value  = "login") String login,
                                         @RequestParam(value = "password") String password
        ){

            CheckLoginRequest request = new CheckLoginRequest();
            request.setLogin(login);
            if(userServices.checkLogin(request) == true) {
                return new ModelAndView("error");

            } else {
                User user = new User();
                user.setLogin(login);
                user.setName(name);
                user.setPass(password);
                userServices.save(user);
                return  new ModelAndView("registrationSuccess");

            }

        }


        @RequestMapping(value = "/users", method = RequestMethod.GET)
        public ModelAndView showListContact(ModelAndView model){

            List<User> user = userServices.findAll();
            model.addObject("user", user);
            model.setViewName("list");

            return model;
        }


         @RequestMapping(value ="/logdel", method = RequestMethod.GET)
         public ModelAndView showDeletePage(){
            ModelAndView logDel =  new ModelAndView("delete");
            return logDel ;

    }


        @RequestMapping(value = "/del" , method = RequestMethod.POST)
        public ModelAndView delUser(@RequestParam(value = "login" ) String login){
             CheckLoginRequest request = new CheckLoginRequest();
            request.setLogin(login);
            if(userServices.checkLogin(request)== true){
                userServices.delete(login);
                return new ModelAndView("deleteSuccess");
            }
            else{
                return new ModelAndView("error");
            }


        }
}
