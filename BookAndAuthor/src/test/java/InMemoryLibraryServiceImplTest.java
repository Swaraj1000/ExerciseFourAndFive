import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryLibraryServiceImplTest {
    LibraryService libraryService;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        libraryService = new InMemoryLibraryServiceImpl();
    }

    @Test
    void testBooksByAuthor() {
        List books = libraryService.getBooksByAuthor("Mark Twain");
        assertEquals(books.size(), 1);
    }

    @Test
    void testAuthorsByBook() throws Exception {
        List authors = libraryService.getAuthorsByBook("To Kill a Mockingbird");
        System.out.println(authors);
    }

    @Test
    void testNumberOfBooks() {
        assertEquals(1,libraryService.getNumberOfBooks("Harper Lee"));
    }

    @Test
    void testBooksByDate() {
        List books = libraryService.getBooksByYear(1960);
        assertEquals(books.size(), 1);
    }
}