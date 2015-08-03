package controller;

/**
 * Created by HAMMAX on 18.07.2015.
 */
import model.SessionSaver;
import model.CheckLoginRequest;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import java.util.*;


@Controller
@SessionAttributes(types = SessionSaver.class)
public class UserController {

        @Autowired
        private UserService userServices;


        void checkSession(ModelAndView modelAndView ,SessionSaver sessionSaver, String setPage , String breakPage){
            if(sessionSaver.getLogin() == null){
                modelAndView.setViewName(breakPage);
            }else{
                modelAndView.addObject(sessionSaver);
                modelAndView.setViewName(setPage);
            }
        }

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView printWelcome(SessionSaver sessionSaver) {
            ModelAndView modelAndView  = new ModelAndView();
            checkSession(modelAndView,sessionSaver,"loginSuccess" , "home");
            return modelAndView;
        }


        @RequestMapping(value = "/auth", method = RequestMethod.POST)
        public ModelAndView login(@RequestParam(value = "login") String login,
                                  @RequestParam(value = "password") String pass) {
            SessionSaver sessionSaver = new SessionSaver();
            sessionSaver.setLogin(login);
            CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
            checkLoginRequest.setLogin(login);
            checkLoginRequest.setPassword(pass);
            ModelAndView model = new ModelAndView();
            if (userServices.checkForLogging(checkLoginRequest)){
                model.addObject(sessionSaver);
                model.setViewName("loginSuccess");
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
        public ModelAndView getLoginSuccessPage(SessionSaver sessionSaver){
            ModelAndView reg =  new ModelAndView();
            checkSession(reg, sessionSaver, "loginSuccess", "home");
            return reg;

        }



        @RequestMapping(value ="/log", method = RequestMethod.GET)
        public ModelAndView getLoginPage(SessionSaver sessionSaver){
            ModelAndView log = new ModelAndView();
            checkSession(log , sessionSaver ,"loginSuccess", "login");
            return log;
        }


        @RequestMapping(value = "/registrationStatus", method = RequestMethod.POST)
        public ModelAndView registrationPage(@RequestParam(value = "name")  String name,
                                         @RequestParam(value  = "login") String login,
                                         @RequestParam(value = "password") String password
        ){

            CheckLoginRequest request = new CheckLoginRequest();
            request.setLogin(login);
            System.out.println(request.getLogin());
            if(userServices.checkLogin(request)) {
                return new ModelAndView("error");

            } else {
                User user = new User();
                user.setLogin(login);
                user.setName(name);
                user.setPass(password.hashCode());
                userServices.save(user);
                return  new ModelAndView("regSuccess");

            }

        }


        @RequestMapping(value = "/users", method = RequestMethod.GET)
        public ModelAndView showListContact(ModelAndView model , SessionSaver sessionSaver){
            checkSession(model, sessionSaver, "list", "home");
            List<User> user = userServices.findAll();
            model.addObject("user", user);
            return model;
        }


         @RequestMapping(value ="/logdel", method = RequestMethod.GET)
         public ModelAndView showDeletePage(SessionSaver sessionSaver){
            ModelAndView logDel =  new ModelAndView("delete");
             checkSession(logDel, sessionSaver, "delete", "home");
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
        public ModelAndView showMessagePage(SessionSaver sessionSaver){
            ModelAndView writemessage =  new ModelAndView();
            checkSession(writemessage, sessionSaver, "writemessage", "home");
            return writemessage ;

    }

        @RequestMapping(value = "/write" , method = RequestMethod.POST)
        public ModelAndView sendMessage(@RequestParam(value = "receiver") String receiver ,
                                        @RequestParam(value = "message") String message,
                                        SessionSaver sessionSaver
                                        ){

            CheckLoginRequest request = new CheckLoginRequest();
            request.setLogin(receiver);
            if(!userServices.checkLogin(request)) {
                return new ModelAndView("error");

            } else {
                Message sending = new Message();
                sending.setSender(sessionSaver.getLogin());
                sending.setReceiver(receiver);
                sending.setMessage(message);
                userServices.sendMessage(sending);

                return  new ModelAndView("success");

            }

        }

        @RequestMapping(value ="/read", method = RequestMethod.GET)
        public ModelAndView showReadMessagePage(SessionSaver sessionSaver){
            ModelAndView model = new ModelAndView();
            checkSession(model , sessionSaver,"noMessages", "home" );
            List<Message> messages = userServices.getMessages(sessionSaver.getLogin());
            if(messages.isEmpty()){
                String status = "You don`t have messages!!!";
                model.addObject("status",status);
                model.addObject("log" , sessionSaver.getLogin());
                model.setViewName("noMessages");
                return model;
            }
            else {
                model.addObject("messages", messages);
                model.setViewName("readMessages");
                return  model;

            }

        }

        @RequestMapping(value = "/exit", method = RequestMethod.GET)
        public ModelAndView exit(SessionStatus sessionStatus){
            sessionStatus.setComplete();
            return new ModelAndView("exit");
        }


}
