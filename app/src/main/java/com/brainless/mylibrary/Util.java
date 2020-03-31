package com.brainless.mylibrary;

import java.util.ArrayList;


public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;

    private static int id = 0;

    public Util() {
        if (allBooks == null) {
            allBooks = new ArrayList<>();
            initAllBooks();
        }

        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }

        if (wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<>();
        }

        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }
    }



    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurrentlyReadingBook (Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean addWantToReadBook (Book book) {
        return wantToReadBooks.add(book);
    }

    public boolean addAlreadyReadBook (Book book) {
        return alreadyReadBooks.add(book);
    }

    public boolean removeCurrentlyReadingBook(Book book) {
        return currentlyReadingBooks.remove(book);
    }

    public boolean removeWantToReadBook(Book book) {
        return wantToReadBooks.remove(book);
    }

    public boolean removeAlreadyReadBook(Book book) {
        return alreadyReadBooks.remove(book);
    }

    private static void initAllBooks() {

        String name = "";
        String author = "";
        int pages = 0;
        String imageUrl = "";
        String description = "";


        id++;
        name = "Rich Dad Poor Dad";
        author = "Robert Kiyosaki";
        pages = 258;
        imageUrl = "https://www.mrdhukkad.com/wp-content/uploads/2019/06/8.jpg";
        description = "A book on Financial Intellegence";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Half Girlfriend";
        author = "Chetan Bhagat";
        pages = 250;
        imageUrl = "https://images-eu.ssl-images-amazon.com/images/I/51LxEF0TmgL.jpg";
        description = "Love Story of a Bihari Boy";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "How to Win Friends and Influence People";
        author = "Dale Carnegie";
        pages = 274;
        imageUrl = "https://n4.sdlcdn.com/imgs/b/z/5/How-To-Win-Friends-and-SDL308697817-1-60268.jpg";
        description = "A book for improving your communication Skills";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Think And Grow rich";
        author = "Napolean Hill";
        pages = 245;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/51Uw5tYiqsL.jpg";
        description = "A book for your financial genius";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "The Girl in Room 105";
        author = "Chetan Bhagat";
        pages = 267;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1535967599l/41639186._SY475_.jpg";
        description = "An Unlove Story";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "The Alchemist";
        author = "Paulo Coelho";
        pages = 182;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/51kzw2xeAQL._SX371_BO1,204,203,200_.jpg";
        description = " This story, dazzling in its powerful simplicity and soul-stirring wisdom, " +
                "is about an Andalusian shepherd boy named Santiago who travels from his homeland in Spain " +
                "to the Egyptian desert in search of a treasure buried near the Pyramids. ";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Zero To One";
        author = "Peter Theil";
        pages = 195;
        imageUrl = "https://images-eu.ssl-images-amazon.com/images/I/51JkDEpHUQL.jpg";
        description = "A Book for Entrepreneurs";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "The Mind in the Making";
        author = " James Robinson";
        pages = 204;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1404959086l/9118225.jpg";
        description = "This vintage book contains a fascinating essay on the most important of all matters of human concern the human mind";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

    }





}
