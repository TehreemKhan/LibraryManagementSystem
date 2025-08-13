package com.universitylibrarysystem;
abstract class User {
    private String name;
    private String libraryCardId;

    public User(String name, String libraryCardId) {
        this.name = name;
        this.libraryCardId = libraryCardId;
    }

    public String getName() {
        return name;
    }

    public String getLibraryCardId() {
        return libraryCardId;
    }

    public abstract int getMaxBooks();
    public abstract int getBorrowDays();
    
}