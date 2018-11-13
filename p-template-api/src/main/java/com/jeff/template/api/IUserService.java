package com.jeff.template.api;

import com.jeff.template.model.base.User;

import java.util.List;

public interface IUserService {

    int insert(User user);

    List<User> queryUserList();
}
