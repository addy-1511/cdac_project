package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VendorController {
	@GetMapping("/vendor-login")
	public String vendorLogin() {
		return "vendor/login";
	}
	
	@GetMapping("/register-vendor")
	public String vendorRegister() {
		return "vendor/register";
	}
}
