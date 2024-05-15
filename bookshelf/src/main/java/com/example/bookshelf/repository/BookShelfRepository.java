package com.example.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookshelf.model.BookDetails;

@Repository
public interface BookShelfRepository extends JpaRepository<BookDetails, Integer>{

}
