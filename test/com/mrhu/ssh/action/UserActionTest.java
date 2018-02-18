package com.mrhu.ssh.action;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

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

} 
