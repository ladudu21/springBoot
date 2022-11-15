
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.laduduAT037.web;

import com.example.laduduAT037.model.Book;
import com.example.laduduAT037.service.BookService;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ladudu
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{id}")
    public String getBook(Model model, @PathVariable String id) {
        Book book = bookService.findBook(Integer.valueOf(id));
        model.addAttribute("book", book);
        return "book-details";
    }

//    @PutMapping("/books/{id}")
//    public String updateBook(Book book, @PathVariable String id) {
//        bookService.saveBook(book);
//        return "redirect:/";
//    }
    @PostMapping("/books/{id}")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult resuilt,
            @PathVariable String id, @RequestParam("coverImg") MultipartFile multipartFile) throws IOException {
        if (resuilt.hasErrors()) {
            return "book-details";
        }

        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            book.setCover(fileName);

            String uploadDir = "./coverImg/";
            Path uploadPath = Paths.get(uploadDir);

//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
            try {
                InputStream inputStream = multipartFile.getInputStream();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioe) {
                throw new IOException("Could not save image file: " + fileName, ioe);
            }
        }

        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(Book book, @PathVariable String id) {
        bookService.deleteBook(book);
        return "redirect:/";
    }
}
