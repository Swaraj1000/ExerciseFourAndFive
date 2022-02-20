import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryLibraryServiceImpl implements LibraryService {
    private List<Book> books = new ArrayList<>();

    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource("Books.csv");

    public InMemoryLibraryServiceImpl() throws FileNotFoundException {
        if (resource == null) {
            throw new FileNotFoundException("file is not found!");
        }
        try (Scanner scanner = new Scanner(new File(resource.getFile()))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                books.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Book getRecordFromLine(String line) {
        String[] columns = line.split(";");
        String title = columns[8];
        String authors = columns[6];
        String publicationYear = columns[7];
        String averageRating = columns[10];
        Book book = new Book(title, (int) Math.round(Double.parseDouble(publicationYear)), Double.parseDouble(averageRating));
        for (String authorName : authors.split(",")) {
            book.addAuthor(new Author(authorName));
        }
        return book;
    }

    @Override
    public List<Book> getBooksByAuthor(String author, SortField sortField, SortOrder sortOrder) {
        Comparator<Book> comparator = new SortByTitle();
        List<Book> results = new ArrayList<>();
        switch (sortField) {
            case PUBLICATION_YEAR -> comparator = new SortByPublicationYear();
            case AVERAGE_RATING -> comparator = new SortByAverageRating();
        }
        switch (sortOrder) {
            case ASC -> {
                return books.stream().filter((Book book) -> book.getAuthors().contains(new Author(author))).sorted(comparator).collect(Collectors.toList());
            }
            case DESC -> {
                return books.stream().filter((Book book) -> book.getAuthors().contains(new Author(author))).sorted(comparator.reversed()).collect(Collectors.toList());
            }
        }
        return results;
    }

    @Override
    public List getBooksByAuthor(String author) {
        return getBooksByAuthor(author, SortField.TITLE, SortOrder.ASC);
    }

    @Override
    public List<Author> getAuthorsByBook(String title) throws Exception {
        List<Book> bookList = books.stream().filter((Book book) -> book.getTitle().equals(title)).toList();
        if(bookList.isEmpty()) {
            throw new Exception("Book doesn't exists");
        }
        return bookList.get(0).getAuthors();
    }

    @Override
    public Integer getNumberOfBooks(String author) {
        return getBooksByAuthor(author, SortField.TITLE, SortOrder.ASC).size();
    }

    public List<Book> getBooksByYear(Integer year) {
        return books.stream().filter((Book book) -> book.getPublicationYear().equals(year)).collect(Collectors.toList());
    }
}
