package service;

import DAO.UserDao;
import model.CheckLoginRequest;
import model.Message;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
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

    @Transactional()
    public boolean checkForLogining(String login , String password){
        return userDao.checkForLogining(login, password);
    }

    public boolean checkLogin(CheckLoginRequest request){
        return userDao.checkLogin(request.getLogin());
    };

    public void sendMessage(Message message){
        userDao.sendMessage(message);
    }

}
