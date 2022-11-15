/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.laduduAT037.repository;

import com.example.laduduAT037.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ladudu
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Book findById(int id);
}
