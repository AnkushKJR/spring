package com.practice.login.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.login.bean.Product;
import com.practice.login.bean.ResellerProfile;

@Controller
public class ProfileController {
	
	private static Map<String, String> users = new HashMap<>();
	
	@RequestMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping("/createResellerAcc")
	public String createResellerAcc() {
		return "createResellerAcc";
	}
	
	@PostMapping("/createResellerProfile")
	public String createResellerProfile(@ModelAttribute ResellerProfile resellerProfile,HttpSession httpSession, Model model) {
		String registeredCompanyName = resellerProfile.getRegisteredCompanyName();
		String gstNum = resellerProfile.getGstNum();
		String userId = registeredCompanyName + gstNum;
		
		resellerProfile.setUserId(userId);
		
		users.put(userId, resellerProfile.getPassword());
		
		model.addAttribute("userId", userId);
		
		System.out.println("Total users now: " + users.size());
		System.out.println("All users: " + users);
		
		return "login-success";
	}
	
	@PostMapping("/loginResellerProfile")
	public String loginResellerProfile(@RequestParam("userId") String userId, @RequestParam("password") String password,HttpSession httpSession, Model model) {
		
		if(users.containsKey(userId) && users.get(userId).equals(password)) {
			httpSession.setAttribute("loggedInUser", userId);
			return "resellerFunctions/home";
		}else {
			model.addAttribute("msg", "Invalid User ID or Password");
			return "login";
		}
		
	}
	
	private static Map<String, List<Product>> resellerProducts = new HashMap<>();
	
	@RequestMapping("/addProduct")
	public String showAddProductPage() {
		return "resellerFunctions/add-product";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute Product product, HttpSession httpSession) {
		
		String userid = (String) httpSession.getAttribute("loggedInUser");
		
		resellerProducts.putIfAbsent(userid, new ArrayList<>());
		
		resellerProducts.get(userid).add(product);
		
		return "redirect:/listProducts";
		
	}
	
	@GetMapping("/listProducts")
	public String listProducts(Model model, HttpSession httpSession) {
		String userId = (String) httpSession.getAttribute("loggedInUser");
		List<Product> list = resellerProducts.getOrDefault(userId, new ArrayList<>());
		model.addAttribute("products", list);
		return "resellerFunctions/product-list";
	}
	
	// ---------------- DELETE PRODUCT ----------------
    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") String id, HttpSession session) {

        String userId = (String) session.getAttribute("loggedInUser");

        resellerProducts.get(userId).removeIf(p -> p.getProductId().equals(id));

        return "redirect:/listProducts";
    }
    
    // ---------------- EDIT PRODUCT (SHOW FORM) ----------------
    @GetMapping("/editProduct")
    public String editProduct(@RequestParam("id") String id, Model model, HttpSession session) {

        String userId = (String) session.getAttribute("loggedInUser");

        Product product = resellerProducts.get(userId)
						                  .stream()
						                  .filter(p -> p.getProductId().equals(id))
						                  .findFirst()
						                  .orElse(null);

        model.addAttribute("product", product);

        return "resellerFunctions/edit-product";
    }
    
    // ---------------- UPDATE PRODUCT (SAVE CHANGES) ----------------
    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product, HttpSession session) {

        String userId = (String) session.getAttribute("loggedInUser");

        List<Product> list = resellerProducts.get(userId);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductId().equals(product.getProductId())) {
                list.set(i, product);
                break;
            }
        }

        return "redirect:/listProducts";
    }
    
    @GetMapping("/home-redirect")
    public String homeRedirect() {
    	return "resellerFunctions/home";
    }
    
}
