package com.mrhu.ssh.dao;

import com.mrhu.ssh.model.User;

public interface UserDao {
    void add(User user);
    boolean exist(User user);
}
