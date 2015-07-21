package DAO;

import model.Message;
import model.User;
import org.springframework.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by HAMMAX on 19.07.2015.
 */

@Repository
public class UserDAOImp implements UserDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private DataSource dataSourceForUser;

    @Autowired
    private  DataSource dataSourceForLogin;


    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public boolean checkForLogining(String login, String password){
        //boolean status = false;
        String query = "select  login , password from users";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = dataSourceForUser.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                if ((login.equals(rs.getString("login")))&&(password.equals(rs.getString("password")))){
                    return true;
                }
            }
            return false;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean checkLogin(String login){
        String query = "select  login  from users";


        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = dataSourceForUser.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                if (login.equals(rs.getString("login"))){
                    return true;
                }
            }
            return false;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public User findByLogin(String login) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", login);

        String query = "SELECT * FROM users WHERE login=:login";

        User result = null;
        try {
            result = namedParameterJdbcTemplate.queryForObject(query, params, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            System.out.println("User does not exist");
        }
        return result;
    }

    @Override
    public List<User> findAll() {

        String sql = "SELECT * FROM users";
        List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());

        return result;
    }
    @Override
    public List<Message> getMessages(){
        String query =  "SELECT * FROM messages";
        List<Message> result = namedParameterJdbcTemplate.query(query, new MessageMapper());
        System.out.println(result);
        return result;
    }

    @Override
    public void sendMessage(Message message){
        String query = "INSERT INTO messages ( sender, receiver, message ) "
                + "VALUES (:sender , :receiver , :message)";
        namedParameterJdbcTemplate.update(query, getSqlParameterByModel(message));

    }

    @Override
    public void save(User user) {

        String query = "INSERT INTO users (name , login ,password ) "
                + "VALUES (:name , :login , :password)";
        namedParameterJdbcTemplate.update(query, getSqlParameterByModel(user));
    }


    @Override
    public void delete(String login) {

        String query = "DELETE FROM users WHERE login =:login";
        namedParameterJdbcTemplate.update(query, new MapSqlParameterSource("login", login));
    }

    private SqlParameterSource getSqlParameterByModel(User user) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", user.getId());
        paramSource.addValue("name", user.getName());
        paramSource.addValue("login", user.getLogin());
        paramSource.addValue("password" , user.getPass());

        return paramSource;
    }
    private SqlParameterSource getSqlParameterByModel(Message message) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", message.getId());
        paramSource.addValue("receiver", message.getReceiver());
        paramSource.addValue("sender", message.getSender());
        paramSource.addValue("message" , message.getMessage());

        return paramSource;
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setLogin(rs.getString("login"));
            user.setPass(rs.getString("password"));

            return user;
        }
    }
    private static final class MessageMapper implements RowMapper<Message> {

        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Message message = new Message();
            message.setId(rs.getInt("id"));
            message.setSender(rs.getString("sender"));
            message.setReceiver(rs.getString("receiver"));
            message.setMessage(rs.getString("message"));

            return message;
        }
    }
}
