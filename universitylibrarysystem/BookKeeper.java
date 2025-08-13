package com.universitylibrarysystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class BookKeeper {

	private static final int PERDAYFINE = 10;
	private User user;
	private Book book;
	private LocalDate borrowDate;
	private LocalDate dueDate;

	public BookKeeper(User user, Book book, LocalDate borrowDate, LocalDate dueDate) {
		this.user = user;
		this.book = book;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public long calculateFine(LocalDate returnDate) {
		long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
		return overdueDays > 0 ? overdueDays * PERDAYFINE : 0;
	}

}
