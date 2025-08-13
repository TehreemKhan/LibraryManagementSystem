package com.universitylibrarysystem;

import java.util.Objects;

public class BookInventory {

	private Book book;
	private int quantity;

	public BookInventory(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void borrowBook() {
		if (quantity > 0) {
			quantity--;
		} else {
			throw new RuntimeException("Book not available!");
		}
	}

	public void returnBook() {
		quantity++;
	}
	
}
