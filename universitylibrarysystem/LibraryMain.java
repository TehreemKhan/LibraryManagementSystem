package com.universitylibrarysystem;

import java.time.LocalDate;
import java.util.Arrays;

public class LibraryMain {

	public static void main(String[] args) {
		
		Library library = new Library();
		
		Book book1 = new Book("English", "Author 1");
		Book book2 = new Book("Math", "Author 2");
		Book book3 = new Book("Java", "Author 3");
		Book book4 = new Book("AWS", "Author 3");
		//not added in inventory list
		Book book5 = new Book("afdgds", "segse");

		
		
		library.addBook(new BookInventory(book1, 10));
		library.addBook(new BookInventory(book2, 1));
		library.addBook(new BookInventory(book3, 2));
		library.addBook(new BookInventory(book4, 3));

		

		User std1 = new Student("Student 1", "card");
		User teacher1 = new Teacher("Teacher1", "card");
		
		library.borrowBook(std1, book1);
		library.borrowBook(std1, book2);
		library.borrowBook(std1, book3);
		library.borrowBook(std1, book4);
		library.borrowBook(teacher1, book2);
		library.returnBook(std1, book4, LocalDate.of(2025, 10, 30));
		library.borrowBook(std1, book5);



	}
}
