package com.dangducton.securityservice;

import javax.servlet.http.HttpServletRequest;

public interface SercurityService {

	void autoLogin(String email, String password, String role, HttpServletRequest request);

}
