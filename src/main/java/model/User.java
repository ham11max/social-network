package model;

import java.util.List;

/**
 * Created by HAMMAX on 18.07.2015.
 */
public class User
{

    protected int id;
    protected String name;
    protected String pass;
    protected String login;
    List<String> friends;



    public String toString(){
        return "User{" + "id=" + id +"login=" + login + ", name=" + name +  '}';
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getLogin() {
        return login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }



}
