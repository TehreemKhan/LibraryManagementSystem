package com.universitylibrarysystem;
class Teacher extends User {
    public Teacher(String name, String libraryCardId) {
        super(name, libraryCardId);
    }

    @Override
    public int getMaxBooks() {
        return 5;
    }

    @Override
    public int getBorrowDays() {
        return 180;
    }
}