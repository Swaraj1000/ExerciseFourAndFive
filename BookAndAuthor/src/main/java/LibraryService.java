import java.util.List;

///**
// * List all books written by an author using following criteria:
// * • alphabetical asc/desc,
// * • publication date asc/desc,
// * • rating asc/desc;
// * Given a book, know who is the author / are the authors;
// * How many books has an author written;
// * Given a Date, what are the books written in that year;
// * ... who is the most prolific author?
// */
public interface LibraryService {
    List<Book> getBooksByAuthor(String author, SortField sortField, SortOrder sortOrder);
    List getBooksByAuthor(String author);
     List<Author> getAuthorsByBook(String title) throws Exception;
     Integer getNumberOfBooks(String author);
     List<Book> getBooksByYear(Integer year);


}
