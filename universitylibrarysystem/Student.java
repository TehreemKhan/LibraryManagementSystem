package com.universitylibrarysystem;
class Student extends User {
    public Student(String name, String libraryCardId) {
        super(name, libraryCardId);
    }

    @Override
    public int getMaxBooks() {
        return 3;
    }

    @Override
    public int getBorrowDays() {
        return 90;
    }
}