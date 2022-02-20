import java.util.Comparator;

public class SortByTitle implements Comparator<Book> {

    // Method
    // Sorting in ascending order of title
    public int compare(Book a, Book b) {

        return a.getTitle().compareTo(b.getTitle());
    }
}
