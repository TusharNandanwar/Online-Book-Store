package com.tushar.onlinebookstore.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.onlinebookstore.dao.BookRepository;
import com.tushar.onlinebookstore.dao.BookUserRepository;
import com.tushar.onlinebookstore.entity.Book;
import com.tushar.onlinebookstore.entity.BookUser;
import com.tushar.onlinebookstore.entity.Customer;

@Service
public class BookUserServiceImpl implements BookUserService {

	@Autowired
	private BookUserRepository bookUserRepos;
	
	@Autowired
	private BookRepository bookRepos;
	
	@Override
	@Transactional
	public Set<Book> getBooksPurchasedBy(Customer customer) {
		
		Set<Integer> bookIds = bookUserRepos.getPurchasedBooks(customer.getUsername());
		
		Set<Book> books = new HashSet<Book>();
		
		for(int id : bookIds) {
			Optional<Book> obj = bookRepos.findById(id);
			if(obj.isPresent()) {
				books.add(obj.get());
			}
		}
		customer.setBooks(books);
		
		return books;
	}

}
