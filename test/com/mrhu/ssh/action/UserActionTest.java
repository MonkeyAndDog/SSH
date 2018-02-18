package com.mrhu.ssh.action;

import com.mrhu.ssh.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* UserAction Tester. 
* 
* @author mrhu
* @since <pre>02/18/2018</pre> 
* @version 1.0 
*/ 
public class UserActionTest { 

    @Test
    public void testExecute() throws Exception {
        UserAction userAction = new UserAction();
        String result = userAction.execute();
        Assert.assertEquals("success", result);
    }

    @Test
    public void testList() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserAction userAction = (UserAction) applicationContext.getBean("userAction");
        userAction.getUserList();
        Assert.assertTrue(userAction.getUsers().size() > 0);
    }

} 
