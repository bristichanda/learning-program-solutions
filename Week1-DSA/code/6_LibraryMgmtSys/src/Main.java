import java.util.*;

public class Main {

    static class Book {
        int bookId;
        String title;
        String author;

        public Book(int id, String title, String author) {
            this.bookId = id;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return bookId + " - \"" + title + "\" by " + author;
        }
    }

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        title = title.toLowerCase();

        while (left <= right) {
            int mid = (left + right) / 2;
            String midTitle = books[mid].title.toLowerCase();

            if (midTitle.equals(title)) {
                return books[mid];
            } else if (midTitle.compareTo(title) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void printBooks(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1));
            System.out.print("Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            books[i] = new Book(id, title, author);
        }

        System.out.print("\nEnter book title to search: ");
        String searchTitle = sc.nextLine();

        // Linear Search
        System.out.println("\nLinear Search Result:");
        Book foundLinear = linearSearch(books, searchTitle);
        System.out.println(foundLinear != null ? foundLinear : "Book not found");

        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        // Binary Search
        System.out.println("\nBinary Search Result:");
        Book foundBinary = binarySearch(books, searchTitle);
        System.out.println(foundBinary != null ? foundBinary : "Book not found");

        sc.close();
    }
}
