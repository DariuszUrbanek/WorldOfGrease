package com.example.du.shop.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.du.shop.auth.ProductRepository;
import com.example.du.shop.form.ProductForm;
import com.example.du.shop.generated.Product;

@Secured("ROLE_USER")
@Controller
public class ApplicationController {
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserDetailsService userDetailsService;

	@GetMapping("/home")
	public ModelAndView getHome() {
		ModelAndView mav = new ModelAndView("home");
		for(GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
			if("ROLE_ADMIN".equals(authority.getAuthority()))
				mav.addObject("isAdmin","true");
		}
		return mav;
	}
	
	@GetMapping("/products")
	public ModelAndView getProducts() {
		
		ModelAndView mav = new ModelAndView("products");		
		
		mav.addObject("list", productRepository.findAll());
		
		return mav;		
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/addProducts")
	public ModelAndView getAddProducts() {
		
		ModelAndView mav = new ModelAndView("addProducts");
		mav.addObject("form", new ProductForm());
		
		return mav;		
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/addProducts")
	public String postAddProducts(@ModelAttribute ProductForm productForm, BindingResult bindingResult) {
		
		productRepository.save(productForm.convertToEntity());
		
		return "redirect:/products";		
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/editProducts")
	public ModelAndView getEditProducts() {

		ModelAndView mav = new ModelAndView("editProducts");
		
		List<ProductForm> forms = new ArrayList<>();
		for(Product product : productRepository.findAll()) {
			ProductForm form = new ProductForm(product);
			forms.add(form);
			mav.addObject(product.getPrId().toString(),form);
		}
		mav.addObject("forms", forms);
		
		return mav;		
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/editProducts")
	public String postEditProducts(@ModelAttribute ProductForm productForm, BindingResult bindingResult) {
		
		productRepository.save(productForm.convertToEntity());
		
		return "redirect:/products";		
	}
	
}
