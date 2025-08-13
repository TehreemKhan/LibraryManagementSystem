package com.universitylibrarysystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<BookInventory> bookInventoryList = new ArrayList<>();
	private List<BookKeeper> bookKeeperList = new ArrayList<>();

	public void addBook(BookInventory bookInventory) {
		bookInventoryList.add(bookInventory);
	}

	public void borrowBook(User user, Book book) {

		BookInventory inventory = bookInventoryList.stream().filter(inv -> inv.getBook().equals(book)).findFirst()
				.orElse(null);

		if (inventory == null) {
			System.out.println("Book doesn't exists.");
			return;
		}

		if (inventory.getQuantity() <= 0) {
			System.out.println("Book's quantity not available.");
			return;
		}

		long borrowedCount = bookKeeperList.stream().filter(r -> r.getUser().equals(user)).count();

		if (borrowedCount >= user.getMaxBooks()) {
			System.out.println(user.getName() + " has reached the borrow limit.");
			return;
		}

		inventory.borrowBook();

		LocalDate borrowDate = LocalDate.now();
		LocalDate dueDate = borrowDate.plusDays(user.getBorrowDays());
		bookKeeperList.add(new BookKeeper(user, book, borrowDate, dueDate));

		System.out.println(user.getName() + " borrowed \"" + book.getTitle() + "\" due on " + dueDate);
	}

	public void returnBook(User user, Book book, LocalDate returnDate) {
		BookKeeper record = bookKeeperList.stream().filter(r -> r.getUser().equals(user) && r.getBook().equals(book))
				.findFirst().orElse(null);

		if (record == null) {
			System.out.println("No borrow record found for this book.");
			return;
		}

		long fine = record.calculateFine(returnDate);
		if (fine > 0) {
			System.out.println("Late fee: Rs " + fine);
		} else {
			System.out.println("Book returned on time.");
		}

		BookInventory inventory = bookInventoryList.stream().filter(inv -> inv.getBook().equals(book)).findFirst()
				.orElse(null);

		if (inventory != null) {
			inventory.returnBook();
		}

		bookKeeperList.remove(record);
	}

}
