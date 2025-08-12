import java.io.*;
import java.util.*;

class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

public class LibraryManagementSystem {
    private static final String FILE_NAME = "library.ser";
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        loadBooks();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Save & Exit");
            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addBook(sc);
                case 2 -> viewBooks();
                case 3 -> issueBook(sc);
                case 4 -> returnBook(sc);
                case 5 -> { saveBooks(); System.out.println("Exiting..."); }
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    private static void addBook(Scanner sc) {
        System.out.print("Enter book title: ");
        String title = sc.nextLine().trim();
        System.out.print("Enter author: ");
        String author = sc.nextLine().trim();
        if(title.isEmpty() || author.isEmpty()){
            System.out.println("Title and author cannot be empty.");
            return;
        }
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n--- Library Books ---");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    private static void issueBook(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("No books to issue.");
            return;
        }
        viewBooks();
        System.out.print("Enter book number to issue: ");
        int bookNum = readInt(sc);
        if (bookNum > 0 && bookNum <= books.size()) {
            Book book = books.get(bookNum - 1);
            if (!book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book is already issued!");
            }
        } else {
            System.out.println("Invalid book number!");
        }
    }

    private static void returnBook(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("No books to return.");
            return;
        }
        viewBooks();
        System.out.print("Enter book number to return: ");
        int bookNum = readInt(sc);
        if (bookNum > 0 && bookNum <= books.size()) {
            Book book = books.get(bookNum - 1);
            if (book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("This book was not issued.");
            }
        } else {
            System.out.println("Invalid book number!");
        }
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int v = sc.nextInt();
        sc.nextLine();
        return v;
    }

    private static void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(new ArrayList<>(books));
            System.out.println("Library saved to file '" + FILE_NAME + "'.");
        } catch (IOException e) {
            System.out.println("Error saving library: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadBooks() {
        File f = new File(FILE_NAME);
        if (!f.exists()) {
            System.out.println("No existing library file found. Starting with an empty library.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            books = (ArrayList<Book>) ois.readObject();
            System.out.println("Loaded " + books.size() + " books from '" + FILE_NAME + "'.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading library: " + e.getMessage());
        }
    }
}
