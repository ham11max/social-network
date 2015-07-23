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

    List<User> findAll();

    void delete(String login);

    void save(User user);

    List<Message> getMessages(String receiver);

    void sendMessage(Message message);

    boolean checkForLogging(CheckLoginRequest request);


}
