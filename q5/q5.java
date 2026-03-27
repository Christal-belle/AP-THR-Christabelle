package q5;

import java.util.Scanner;
import java.util.Stack;

class Book {
    String title;
    String author;
    int yearofpub;

    public Book (String title, String author, int yearofpub) {
        if (title.length() >= 255) {
            throw new IllegalArgumentException("Title must be under 255 characters");
        }
        if (author.length() >= 50) {
            throw new IllegalArgumentException("Author name must be under 50 characters");
        }
        if (yearofpub <= 1800 || yearofpub >= 2026) {
            throw new IllegalArgumentException("Year of Publication must be between 1800 and 2026");
        }
        this.title = title;
        this.author = author;
        this.yearofpub = yearofpub;
    }

    public void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + yearofpub);
    }
}

class GeneralBooks extends Book {
    String genre;

    public GeneralBooks(String title, String author, int yearofpub, String genre) {
        super (title, author, yearofpub);
        if (genre.length() >= 30) {
            throw new IllegalArgumentException("Genre must be under 30 characters");
        }
        this.genre = genre;
    }
    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Genre: " + genre);
    }
}

class ChildrenBooks extends Book {
    int minAge;
    boolean hasVisualisation;

    public ChildrenBooks(String title, String author, int yearofpub, int minAge, boolean hasVisualisation) {
        super (title, author, yearofpub);
        if (minAge <= 3 || minAge >= 12) {
            throw new IllegalArgumentException("Minimum Age must be between 3 and 12");
        }
        if (!hasVisualisation) {
           throw new IllegalArgumentException("Children books must have visualisation");
        }
        this.minAge = minAge;
        this.hasVisualisation = hasVisualisation;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Minimum Age: " + minAge);
        System.out.println("Has Visualisation: yes");
    }
}


public class q5 {
    static Stack<Book> perpus = new Stack<>(); //pke static biar setiap objek dlm stack yg sama
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        perpus.push(new Book("Why Black Moves First", "Wesley So", 2025));
        perpus.push(new GeneralBooks("Inside Black Mesa", "Dr. Isaac Kleiner", 1997, "Documentary"));
        perpus.push(new ChildrenBooks("Got Science?", "Rachel Dawes", 2015, 5, true));
    
        int choice;
        do {
            System.out.println("\n=== Books Menu ===");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit Library");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    ViewBooks();
                    break;
                
                case 2:
                    AddBook();
                    break;
                
                case 3:
                    DeleteBook();
                    break;

            }
        }
        while (choice != 4);
    
    }

    public static void ViewBooks() {
        if (perpus.isEmpty()) {
            System.out.println("No Book Available");
            return;
        }
        for (int i = 0; i < perpus.size(); i++) {
            System.out.println("Books Number: " + (i + 1));
            perpus.get(i).getInfo();
        }
    }
    public static void AddBook() {
        System.out.println("Choose Book Type: ");
        System.out.println("1. Book");
        System.out.println("2. General Book");
        System.out.println("3. Children Book");

        int type = sc.nextInt();
        sc.nextLine();

        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Author: ");
        String author = sc.nextLine();
        System.out.println("Year of Publication: ");
        int yearofpub = sc.nextInt();
        sc.nextLine();
        
        if(type == 1) {
            perpus.push(new Book(title, author, yearofpub));
            System.out.println("Book added!");
        }
        else if(type == 2) {
            System.out.println("Genre: ");
            String genre = sc.nextLine();
            perpus.push(new GeneralBooks(title, author, yearofpub, genre));
            System.out.println("Book added!");
        }
        else if(type == 3) {
            System.out.println("Minimum Age: ");
            int minAge = sc.nextInt();
            sc.nextLine();
            System.out.println("Has Visualisation: ");
            boolean hasVisualisation = sc.nextBoolean();
            sc.nextLine();
            if (!hasVisualisation) {
                System.out.println("Childrens book must have visualisation");
                return;
            }
            perpus.push(new ChildrenBooks(title, author, yearofpub, minAge, hasVisualisation));
            System.out.println("Book added!");
        }
        else {
            System.out.println("Invalid Number!");
        }
    }
    public static void DeleteBook() {
        ViewBooks();
        if (perpus.isEmpty()) {
            return;
        }
        System.out.println("Choose the book number to delete: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index < 1 || index > perpus.size()) {
            System.out.println("Invalid Number!");
            return;
        }
        perpus.remove(index - 1);
        
        System.out.println("Book deleted!");
    }
     
    
}
