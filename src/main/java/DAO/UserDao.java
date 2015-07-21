package DAO;

import model.Message;
import model.User;
import java.util.List;

/**
 * Created by HAMMAX on 19.07.2015.
 */

public interface UserDao {

	boolean checkLogin(String login);

	User findByLogin(String login);

	List<User> findAll();

	void save(User user);

	void delete(String login);

	boolean checkForLogining(String user, String password);

	void sendMessage(Message message);

}