package com.anarya.matrimony.service;

import com.anarya.matrimony.dto.LoginForm;
import com.anarya.matrimony.dto.RegistrationForm;
import com.anarya.matrimony.dto.UnlockForm;

public interface UserService {

	public String userRegistration(RegistrationForm registrationForm);

	public String unlockRegistration(UnlockForm unlockForm);

	public String userLogin(LoginForm loginForm);

	public String recoveryPwd(String email);

}
