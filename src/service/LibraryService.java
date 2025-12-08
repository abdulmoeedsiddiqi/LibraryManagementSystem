package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Member;
import model.Loan;
public class LibraryService {
 private List<Book> books = new ArrayList<>();
 private List<Member> members = new ArrayList<>();
 private List<Loan> loans = new ArrayList<>();
 public void addBook(Book book) { books.add(book); }
 public void addMember(Member member) { members.add(member); }
 public List<Book> getBooks() { return books; }
 public List<Member> getMembers() { return members; }
 public List<Loan> getLoans() { return loans; }
 public void borrowBook(int memberId, int bookId) {
 Member member = members.stream().filter(m -> m.getId() == memberId).findFirst()
 .orElseThrow(() -> new IllegalArgumentException("Member not found."));
 Book book = books.stream().filter(b -> b.getId() == bookId).findFirst()
 .orElseThrow(() -> new IllegalArgumentException("Book not found."));
 book.borrowBook();
 loans.add(new Loan(book, member, LocalDate.now(), LocalDate.now().plusDays(14)));
 }
 public void returnBook(int bookId, int memberId) {
 Loan loan = loans.stream()
 .filter(l -> l.getBook().getId() == bookId && l.getMember().getId() == memberId &&
l.getReturnedDate() == null)
 .findFirst()
 .orElseThrow(() -> new IllegalArgumentException("No active loan found."));
 loan.markReturned();
 loan.getBook().returnBook();
 }
}