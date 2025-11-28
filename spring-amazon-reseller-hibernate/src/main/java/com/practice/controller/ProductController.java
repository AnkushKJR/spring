package com.practice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.dao.ProductDao;
import com.practice.model.Product;
import com.practice.model.Reseller;



@Controller
public class ProductController {
	ProductDao dao = new ProductDao();

    @GetMapping("/addProduct")
    public String addForm() {
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String save(Product p, HttpSession session) {
        Reseller r = (Reseller) session.getAttribute("reseller");
        p.setResellerId(r.getId());
        dao.save(p);
        return "redirect:/listProducts";
    }

    @GetMapping("/listProducts")
    public String list(Model m, HttpSession session) {
        Reseller r = (Reseller) session.getAttribute("reseller");
        m.addAttribute("list", dao.list(r.getId()));
        return "listProducts";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        m.addAttribute("p", dao.get(id));
        return "editProduct";
    }

    @PostMapping("/update")
    public String update(Product p) {
        dao.update(p);
        return "redirect:/listProducts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/listProducts";
    }
}
