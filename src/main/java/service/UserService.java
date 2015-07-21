package service;

import model.CheckLoginRequest;
import model.Message;
import model.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by HAMMAX on 19.07.2015.
 */
public interface UserService {

    boolean checkLogin(CheckLoginRequest request);

    User findByLogin(String login);

    List<User> findAll();

    void delete(String login);

    void save(User user);

    void sendMessage(Message message);

    @Transactional(isolation = Isolation.DEFAULT)
    boolean checkForLogining(String login , String password);


}
