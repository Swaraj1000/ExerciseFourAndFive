import java.util.Comparator;

public class SortByAverageRating implements Comparator<Book> {

    @Override
    public int compare(Book a, Book b) {
        return a.getAverageRating().compareTo(b.getAverageRating());
    }

}
