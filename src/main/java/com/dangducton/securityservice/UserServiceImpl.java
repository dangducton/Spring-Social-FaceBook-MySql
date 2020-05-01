package com.dangducton.securityservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dangducton.model.UserInfo;
import com.dangducton.repository.UserRepository;
import com.dangducton.util.PassWordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserInfo save(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfo.setEnabled(true);
		if(StringUtils.hasText(userInfo.getPassword())) {
			userInfo.setPassword(PassWordUtil.getEncoderPassword(userInfo.getPassword()));
		}
		return userRepository.save(userInfo);
	}

	@Override
	public UserInfo findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public void update(UserInfo dbUser) {
		// TODO Auto-generated method stub
		userRepository.save(dbUser);
	}

}
