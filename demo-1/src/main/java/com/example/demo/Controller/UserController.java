package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.Entity.User;
import com.example.demo.repo.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserRepo userRepo;
	@GetMapping("/accountinfo")
	public String accInfo(Model model,HttpSession session) {
		if(session.getAttribute("session_id")!=null) {
		int id=(int)session.getAttribute("user_id");
		User user=userRepo.getById(id);
		model.addAttribute(user);
		return "customer/account";
		}
		return "redirect:/login";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute User user,HttpSession session) {
		int id=(int)session.getAttribute("user_id");
		User foundUser=userRepo.getById(id);
		foundUser.setAddress(user.getAddress());
		foundUser.setContact_no(user.getContact_no());
		foundUser.setEmail(user.getEmail());
		foundUser.setName(user.getName());
		userRepo.save(foundUser);
		return "redirect:/accountinfo";
	}
}
