import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        LibraryService libraryService = new InMemoryLibraryServiceImpl();
        List books = libraryService.getBooksByAuthor("Harper Lee");
        System.out.println(books);
        List authors = libraryService.getAuthorsByBook("To Kill a Mockingbird");
        System.out.println(authors);
        System.out.println(libraryService.getNumberOfBooks("Harper Lee"));
        books = libraryService.getBooksByYear(1996);
        System.out.println(books);
    }
}
