package model;

import java.time.LocalDate;

public class Loan {
    private Book book;
 private Member member;
 private LocalDate loanDate;
 private LocalDate dueDate;
 private LocalDate returnedDate;
 public Loan(Book book, Member member, LocalDate loanDate, LocalDate dueDate) {
 this.book = book;
 this.member = member;
 this.loanDate = loanDate;
 this.dueDate = dueDate;
 }
 public Book getBook() { return book; }
 public Member getMember() { return member; }
 public LocalDate getLoanDate() { return loanDate; }
 public LocalDate getDueDate() { return dueDate; }
 public LocalDate getReturnedDate() { return returnedDate; }
 public void markReturned() {
    this.returnedDate = LocalDate.now();
 }
 @Override
 public String toString() {
 return member.getName() + " borrowed \"" + book.getTitle() + "\" on " + loanDate +
 " (Due: " + dueDate + ")" +
 (returnedDate != null ? " - Returned on: " + returnedDate : "");
 }
}