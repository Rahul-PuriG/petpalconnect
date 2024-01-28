package ca.sheridancolllege.purirah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.sheridancolllege.purirah.Repositories.SecurityRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SecurityController {
	
	private SecurityRepository secRepo;
	
	@GetMapping("/denied")
	public String deny() {
		return "access-denied.html";
	}

	
	@GetMapping("/login")
	public String login() {
		return "LoginSignup.html";
	}

	@GetMapping("/register")
	public String register() {
		return "LoginSignup.html";
	}
		
	@PostMapping("/register")
	public String processRegister(@RequestParam String username,
			@RequestParam String password, 
			@RequestParam String email,
			@RequestParam (required=false)String role) {
		secRepo.register(username,password,email);
		long uid =secRepo.findUserByUsername(username).getUserId();
		
		role = "guest";
		
		if(role.equals("admin")) {
			secRepo.assignRoles(uid, 2);
		}else {
			secRepo.assignRoles(uid, 1);
		}
		return "redirect:/login";
	}
}
