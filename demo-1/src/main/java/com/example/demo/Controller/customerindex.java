
package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/product")
public class customerindex {
	@Autowired
	private ProductRepo productrepo;
	@Autowired
	private CategoryRepo catrepo;
	

	@GetMapping("/Home")
	public String ViewProducts(Model model,HttpSession session) {
		System.out.println(session.getId());
		System.out.println("User id "+session.getAttribute("user_id"));
		List<Product> products = productrepo.findAll();
		model.addAttribute("products", products);
		List<Category> categories=catrepo.findAll(); 
		model.addAttribute("categories",categories);

		// itr.forEach(t -> {System.out.println(t);});
		return "customer/index";
	}
	
	


	
}



