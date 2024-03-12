package com.anarya.matrimony.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anarya.matrimony.dto.LoginForm;
import com.anarya.matrimony.dto.RegistrationForm;
import com.anarya.matrimony.dto.UnlockForm;
import com.anarya.matrimony.service.UserService;

@RestController
@RequestMapping("/matrimony/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUserDtls(@RequestBody RegistrationForm form) {
		String status = userService.userRegistration(form);
		return ResponseEntity.status(HttpStatus.CREATED).body(status);
	}

	@PostMapping("/unlockUser")
	public ResponseEntity<?> unlockUserAcc(@RequestBody UnlockForm unlockForm) {
		String unlockStatus = userService.unlockRegistration(unlockForm);
		return ResponseEntity.status(HttpStatus.OK).body(unlockStatus);
	}

	@PostMapping("/userLogin")
	public ResponseEntity<?> loginUser(@RequestBody LoginForm loginForm) {
		String login = userService.userLogin(loginForm);
		return ResponseEntity.status(HttpStatus.OK).body(login);
	}

	@GetMapping("/{email}")
	public ResponseEntity<?> recoveryPwdthrEmail(@PathVariable String email) {
		String recoveryPwd = userService.recoveryPwd(email);
		return ResponseEntity.status(HttpStatus.OK).body(recoveryPwd);
	}

}
