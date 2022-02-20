import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void addAuthor() {
        Book book = new Book("War and peace", Integer.valueOf(1869), Double.valueOf(5));
        Author author = new Author("Leo Tolstoy");
        book.addAuthor(author);
        assertEquals(book.getAuthors().size(), 1);
        assertEquals(book.getAuthors().get(0), author);
    }

}