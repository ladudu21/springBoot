/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.laduduAT037.web;

import com.example.laduduAT037.model.Book;
import com.example.laduduAT037.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ladudu
 */
@Controller
public class MainController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = {"/"})
    public String homepage(Model model) {
        List<Book> books = bookService.selectAllBook();
        model.addAttribute("books", books);
        return "home";
    }
}
