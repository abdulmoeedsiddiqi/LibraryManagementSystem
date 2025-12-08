package controller;
import service.LibraryService;
import model.Book;
import model.Member;
public class LibraryController {
 private LibraryService service;
 public LibraryController(LibraryService service) {
 this.service = service;
 }
 public void addSampleData() {
 service.addBook(new Book(1, "Java Programming", "John Doe", 3));
 service.addBook(new Book(2, "Design Patterns", "Erich Gamma", 2));
 service.addMember(new Member(1, "Alice", "alice@example.com"));
 service.addMember(new Member(2, "Bob", "bob@example.com"));
 }
 public void borrowBook(int memberId, int bookId) {
 service.borrowBook(memberId, bookId);
 System.out.println("Book borrowed successfully.");
 }
 public void returnBook(int memberId, int bookId) {
 service.returnBook(bookId, memberId);
 System.out.println("Book returned successfully.");
 }
 public void displayBooks() {
 service.getBooks().forEach(System.out::println);
 }
 public void displayLoans() {
 service.getLoans().forEach(System.out::println);
 }
}
