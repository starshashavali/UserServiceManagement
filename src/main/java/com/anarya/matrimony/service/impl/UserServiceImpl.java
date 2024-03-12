package com.anarya.matrimony.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarya.matrimony.domain.UserEntity;
import com.anarya.matrimony.dto.LoginForm;
import com.anarya.matrimony.dto.RegistrationForm;
import com.anarya.matrimony.dto.UnlockForm;
import com.anarya.matrimony.repo.UserRepo;
import com.anarya.matrimony.service.UserService;
import com.anarya.matrimony.utils.EmailUtils;
import com.anarya.matrimony.utils.PwdUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private PwdUtils pwdUtils;

	@Override
	public String userRegistration(RegistrationForm registrationForm) {

		UserEntity entity = userRepo.findByEmail(registrationForm.getEmail());
		if (entity != null) {
			if ("Locked".equalsIgnoreCase(entity.getUserAccStatus())) {

				return "Your account need to be unlocked";
			} else if ("Unlocked".equalsIgnoreCase(entity.getUserAccStatus())) {
				return "Email already exists ,Please login !";
			}
		}

		BeanUtils.copyProperties(registrationForm, entity);
		entity.setUserAccStatus("Locked");

		String pwd = pwdUtils.generatePwd(6);

		StringBuffer sb = new StringBuffer("");

		sb.append("<h1>Hey, " + registrationForm.getUserName() + "</h1>");

		sb.append("<h3>Unlock your account with this temporary password</h3>");

		sb.append("<br>");

		sb.append("<p>Temporary password : <B>" + pwd + "</B> </p>");

		sb.append("<br>");

		sb.append("<a href=\"http://localhost:9091/unlock?mail=" + registrationForm.getEmail()
				+ "\">Click here to unlock your account </a>");

		emailUtils.sendEmail(registrationForm.getEmail(), "Unlock your account ", String.valueOf(sb));

		entity.setUserAccStatus("Locked");
		entity.setPwd(pwd);

		userRepo.save(entity);

		return "Mail sent to " + registrationForm.getEmail();
	}

	@Override
	public String unlockRegistration(UnlockForm unlockForm) {

		UserEntity user = userRepo.findByEmail(unlockForm.getEmail());

		if (!unlockForm.getTempPassword().equals(user.getPwd())) {
			return "Temporary Password is not matching";
		}
		if (!unlockForm.getNewPassword().equals(unlockForm.getConfirmPassword())) {
			return "Password not matching";
		}
		user.setPwd(unlockForm.getNewPassword());
		user.setUserAccStatus("Unlocked");

		userRepo.save(user);
		return "Account unlocked";
	}

	@Override
	public String userLogin(LoginForm loginForm) {
		UserEntity entity = userRepo.findByEmailAndPwd(loginForm.getEmail(), loginForm.getPwd());
		if (entity == null) {
			return "Invalid credentials";
		}
		if ("Locked".equalsIgnoreCase(entity.getUserAccStatus())) {
			return "Your account need to be unlocked";
		}
		return "success";
	}

	@Override
	public String recoveryPwd(String email) {
		UserEntity user = userRepo.findByEmail(email);
		if (user == null) {
			return "User not found for email: " + email;
		}

		String currentPassword = user.getPwd();

		// Send an email with the current password
		StringBuffer sb = new StringBuffer("");
		sb.append("<h1>Password Recovery</h1>");
		sb.append("<p>Your current password is: <strong>" + currentPassword + "</strong></p>");
		sb.append("<p>Please change your password after logging in for security reasons.</p>");

		emailUtils.sendEmail(user.getEmail(), "Password Recovery", sb.toString());

		return "Mail sent to " + user.getEmail() + " with the current password.";
	}
}
