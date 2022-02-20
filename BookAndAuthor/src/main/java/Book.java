import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private final String title;

    private final Integer publicationYear;

    private final Double averageRating;

    private List<Author> authors = new ArrayList<>();

    public Book(String title, Integer publicationYear, Double averageRating) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.averageRating = averageRating;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public String getTitle() {

        return title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", publicationYear=" + publicationYear + ", averageRating=" + averageRating + ", authors=" + authors + '}';
    }
}

