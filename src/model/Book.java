package model;

public class Book {
    private int id;
 private String title;
 private String author;
 private int copiesAvailable;
 public Book(int id, String title, String author, int copiesAvailable) {
 this.id = id;
 this.title = title;
 this.author = author;
 this.copiesAvailable = copiesAvailable;
}

public int getId() { return id; }

public String getTitle() { return title; }
 public String getAuthor() { return author; }
 public int getCopiesAvailable() { return copiesAvailable; }
 public void borrowBook() {
 if (copiesAvailable > 0) {
 copiesAvailable--;
 } else {
 throw new IllegalStateException("No copies available.");
 }
 }

 public void returnBook() {
 copiesAvailable++;
 }
 @Override
 public String toString() {
 return id + " - " + title + " by " + author + " (Available: " + copiesAvailable + ")";
 }
}
