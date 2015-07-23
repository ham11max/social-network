package DAO;

import model.Message;
import model.User;
import java.util.List;

/**
 * Created by HAMMAX on 19.07.2015.
 */

public interface UserDao {
	User findByLogin(String login);

	List<User> findAll();

	void save(User user);

	void delete(String login);

	void sendMessage(Message message);

	List <Message> getMessages();

}