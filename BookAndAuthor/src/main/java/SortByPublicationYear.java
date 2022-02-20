import java.util.Comparator;

public class SortByPublicationYear implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return a.getPublicationYear().compareTo(b.getPublicationYear());
    }
}
