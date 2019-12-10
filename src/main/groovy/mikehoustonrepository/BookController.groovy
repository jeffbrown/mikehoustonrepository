package mikehoustonrepository

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/books")
class BookController {

    private BookRepository bookRepository

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    @Get("/")
    Iterable<Book> index() {
        bookRepository.findAll()
    }

    @Post("/{title}/{author}")
    Book create(String title, String author) {
        bookRepository.save new Book(title, author)
    }

    @Get("/find/{title}")
    Optional<Book> findByTitle(String title) {
        bookRepository.find title
    }
}