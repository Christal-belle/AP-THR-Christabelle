package q4;

class Item {
    String title;
    int releasedyear;
    double price;

    public Item (String title, int releasedyear, double price) {
        if (title.length() >= 255)  {
            throw new IllegalArgumentException("Ga boleh lebih dari 255");
        }
        
        if (releasedyear <= 1800 || releasedyear >= 2026) {
            throw new IllegalArgumentException("Ga boleh di bawah 1800 atau di atas 2026");
        }

        this.title = title;
        this.releasedyear = releasedyear;
        this.price = price;
    }    

    public void getDescription() {
        System.out.println("Title: " + title);
        System.out.println("releasedYear: " + releasedyear);
        System.out.println("Price: " + price);
    }
}

class DVD extends Item {
    private int runtime;

    public DVD (String title, int releasedyear, double price, int runtime) {
        super (title, releasedyear, price);
        if (runtime >= 720) {
            return;
        }
        this.runtime = runtime;
    }
     @Override
     public void getDescription() {
        super.getDescription();
        System.out.println("Runtime: " + runtime + " minutes");
     }
}

class Magazine extends Item {
    private String author;
    private int numpage;

    public Magazine (String title, int releasedyear, double price, String author, int numpage) {
        super (title, releasedyear, price);
        if (author.length() >= 50) {
            return;
        }
        this.author = author;
        this.numpage = numpage;
    }
    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Author: " + author);
        System.out.println("Number of Page: " + numpage);
    }
}

class Vinyl extends Item {
    private int size;

    public Vinyl (String title, int releasedyear, double price, int size) {
        super (title, releasedyear, price);
        if (size > 12) {
            return;
        }
        this.size = size;
    }
    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Size: " + size);
    }
}

public class q4 {
    public static void main(String[] args) {
        DVD dvd = new DVD ("Baby be Mine", 1982, 50000, 4);
        Magazine magazine = new Magazine ("Nintendo Power #82", 1997, 25000, "Nintendo", 36);
        Vinyl vinyl = new Vinyl ("Song of The Wind",1967, 350000, 12);

        dvd.getDescription(); 
        magazine.getDescription();
        vinyl.getDescription();
    
    }
}

