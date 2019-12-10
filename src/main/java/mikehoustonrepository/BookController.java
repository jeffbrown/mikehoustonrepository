package mikehoustonrepository;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.Optional;

@Controller("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Get("/")
    public Iterable<Book> index() {
        return bookRepository.findAll();
    }

    @Post("/{title}/{author}")
    public Book create(String title, String author) {
        return bookRepository.save(new Book(title, author));
    }

    @Get("/find/{title}")
    public Optional<Book> findByTitle(String title) {
        return bookRepository.find(title);
    }
}