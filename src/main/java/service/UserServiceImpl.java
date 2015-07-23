package service;

import DAO.UserDao;
import model.CheckLoginRequest;
import model.Message;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAMMAX on 19.07.2015.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public void delete(String login) {

        userDao.delete(login);
    }

    @Override
    public void save(User user) {

        userDao.save(user);
    }

    @Override
    public boolean checkForLogging(CheckLoginRequest request){

        if(userDao.findByLogin(request.getLogin()) == null){
            return false;
        }else if(userDao.findByLogin(request.getLogin()).getPass().equals(request.getPassword())){
            return true;
        }
       return false;
    }

    public boolean checkLogin(CheckLoginRequest request){

            if (userDao.findByLogin(request.getLogin()) == null) {
                return false;
            }
        return true;
    }

    public void sendMessage(Message message){
        userDao.sendMessage(message);
    }

    public List<Message> getMessages(String receiver) {
        if (receiver.isEmpty()) {
            return null;
        }else{
            List<Message> userMessages  = new ArrayList<Message>();
            for(Message message :userDao.getMessages()){
                String receivers = message.getReceiver();
                if(receiver.equals(receivers)){
                    userMessages.add(message);
                }
            }
            return userMessages;
        }

    }


}
