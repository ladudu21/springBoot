/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.laduduAT037.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author ladudu
 */
@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotBlank(message = "Khong duoc de trong")
    private String title;

    @Column(name = "author")
    @NotBlank(message = "Khong duoc de trong")
    private String author;

    @Column(name = "category")
    private String category;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "n_o_p")
    private int nOP;

    @Column(name = "cover", nullable = true)
    private String cover;
    
    @Transient
    public String getCoverImg() {
        if (cover == null) return null;
        return "/coverImg/" + cover;
    }
}
