package com.mrhu.ssh.action;

import com.mrhu.ssh.model.User;
import com.mrhu.ssh.service.UserService;
import com.mrhu.ssh.vo.UserDto;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<UserDto>{

    private UserService userService;
    private UserDto userDto = new UserDto();

    @Override
    public String execute() {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        if(userService.exist(user) || !userDto.getPassword().equals(userDto.getPassword2())) {
            return ERROR;
        } else {
            userService.save(user);
            return SUCCESS;
        }
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource(name="userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public UserDto getModel() {
        return userDto;
    }
}
