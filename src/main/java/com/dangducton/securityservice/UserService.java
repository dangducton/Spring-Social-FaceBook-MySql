package com.dangducton.securityservice;

import com.dangducton.model.UserInfo;

public interface UserService {

	UserInfo save(UserInfo userInfo);

	UserInfo findByEmail(String email);

	void update(UserInfo dbUser);

}
