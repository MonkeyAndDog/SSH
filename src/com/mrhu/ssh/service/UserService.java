package com.mrhu.ssh.service;

import com.mrhu.ssh.model.User;

public interface UserService {
    void save(User user);
    boolean exist(User user);
}
