package main;
import java.util.Scanner;
import controller.LibraryController;
import service.LibraryService;
public class LibraryApp {
 public static void main(String[] args) {
 LibraryService service = new LibraryService();
 LibraryController controller = new LibraryController(service);
 controller.addSampleData();
 Scanner sc = new Scanner(System.in);
 while (true) {
 System.out.println("\n=== Library Menu ===");
 System.out.println("1. List Books");
 System.out.println("2. Borrow Book");
 System.out.println("3. Return Book");
 System.out.println("4. View Loans");
 System.out.println("5. Exit");
 System.out.print("Choose option: ");
 int choice = sc.nextInt();
 switch (choice) {
 case 1 -> controller.displayBooks();
 case 2 -> {
 System.out.print("Enter Member ID: ");
 int mId = sc.nextInt();
 System.out.print("Enter Book ID: ");
 int bId = sc.nextInt();
 controller.borrowBook(mId, bId);
 }
 case 3 -> {
 System.out.print("Enter Member ID: ");
 int mId = sc.nextInt();
 System.out.print("Enter Book ID: ");
 int bId = sc.nextInt();
 controller.returnBook(mId, bId);
 }
 case 4 -> controller.displayLoans();
 case 5 -> {
 System.out.println("Exiting...");
 sc.close();
 return;
 }
 default -> System.out.println("Invalid option.");
 }
 }
 }
 }