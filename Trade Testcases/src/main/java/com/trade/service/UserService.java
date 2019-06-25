package com.trade.service;

import java.util.List;

import com.trade.model.User;

public interface UserService {

	User save(User user);

	List<User> getUserList();

	User getUser(int id);

}
