package com.gametruck.web.controller;

import com.gametruck.service.ProductService;
import com.gametruck.vo.Category;
import com.gametruck.vo.Platform;
import com.gametruck.web.form.ProductForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

    @GetMapping
    public String home() {
        return "page/admin/home";
    }

    @GetMapping("/form")
    public String form(Model model) {
        List<Category> catList = productService.getAllCategories();
        List<Platform> platList = productService.getAllPlatforms();
        model.addAttribute("cat", catList);
        model.addAttribute("plat", platList);
        return "page/admin/form";
    }

    @PostMapping("/register")
    public String register(ProductForm productForm) {
        productService.registerProduct(productForm);
        return "redirect:/admin";
    }
}
