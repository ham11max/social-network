package controller;

/**
 * Created by HAMMAX on 18.07.2015.
 */
import DAO.UserDAOImp;
import model.CheckLoginRequest;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class UserController {

        @Autowired
        private UserService userServices;
        private String mainlogin ="qq";




        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView printWelcome(ModelMap model) {
            ModelAndView a  = new ModelAndView("home");
            return a;

        }


        @RequestMapping(value = "/auth", method = RequestMethod.POST)
        public ModelAndView login(
                @ModelAttribute@RequestParam(value = "login") String login,
                @ModelAttribute@RequestParam(value = "password") String pass) {
            mainlogin = login;
            CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
            checkLoginRequest.setLogin(login);
            checkLoginRequest.setPassword(pass);
            ModelAndView model = new ModelAndView();
            model.addObject("login",login);
            if (userServices.checkForLogging(checkLoginRequest)){
                model.setViewName("loginSucces");
                System.out.println(login);
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

        @RequestMapping(value ="/auth", method = RequestMethod.GET)
        public ModelAndView getLoginSuccessPage(){
            ModelAndView reg =  new ModelAndView("loginSucces");
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
            if(!userServices.checkLogin(request)) {
                return new ModelAndView("error");

            } else {
                User user = new User();
                user.setLogin(login);
                user.setName(name);
                user.setPass(password);
                userServices.save(user);
                return  new ModelAndView("success");

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
            if(userServices.checkLogin(request)){
                userServices.delete(login);
                return new ModelAndView("success");
            }
            else{
                return new ModelAndView("error");
            }


        }
        @RequestMapping(value ="/write", method = RequestMethod.GET)
        public ModelAndView showMessagePage(){
            ModelAndView logDel =  new ModelAndView("writemessage");
                return logDel ;

    }
        @RequestMapping(value = "/write" , method = RequestMethod.POST)
        public ModelAndView sendMessage(@RequestParam(value = "login") String login ,
                                        @RequestParam(value = "message") String message){

            CheckLoginRequest request = new CheckLoginRequest();
            request.setLogin(login);
            if(!userServices.checkLogin(request)) {
                return new ModelAndView("error");

            } else {
                Message sending = new Message();
                sending.setSender(mainlogin);
                sending.setReceiver(login);
                sending.setMessage(message);
                userServices.sendMessage(sending);

                return  new ModelAndView("success");

            }

        }

        @RequestMapping(value ="/read", method = RequestMethod.GET)
        public ModelAndView showReadMessagePage(ModelAndView model){
            List<Message> messages = userServices.getMessages(mainlogin);
            if(messages.isEmpty()){
                String status = "You don`t have messages!!!";
                model.addObject("status",status);
                model.addObject("log" , mainlogin);
                model.setViewName("noMessages");
                return model;
            }
            else {
                model.addObject("messages", messages);
                model.setViewName("readMessages");
                return  model;

            }

        }


}
