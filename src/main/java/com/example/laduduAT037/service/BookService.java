/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.laduduAT037.service;

import com.example.laduduAT037.model.Book;
import com.example.laduduAT037.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ladudu
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> selectAllBook() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Book findBook(int id) {
        Book book = bookRepository.findById(id);
        if (book == null){
            Book tmpBook = new Book();
            tmpBook.setId(-1);
            return tmpBook;
        }
        return book;
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }
}
