package com.mrhu.ssh.action;

import com.mrhu.ssh.model.User;
import com.mrhu.ssh.service.UserService;
import com.mrhu.ssh.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class UserAction extends ActionSupport{

    private UserService userService;

    private String username;
    private String password;
    private String password2;


    @Override
    public String execute() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(userService.exist(user)) {
            return ERROR;
        } else {
            userService.save(user);
            return SUCCESS;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
