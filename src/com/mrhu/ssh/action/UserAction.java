package com.mrhu.ssh.action;

import com.mrhu.ssh.model.User;
import com.mrhu.ssh.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport{

    private UserService userService;

    private String username;
    private String password;
    private String password2;

    @Override
    public String execute() {
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

    @Resource(name="userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
