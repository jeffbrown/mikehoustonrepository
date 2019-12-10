package mikehoustonrepository

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class BookControllerSpec extends Specification {

    @Inject
    BookClient bookClient;

    void 'test find'() {
        when:
        Optional<Book> book = bookClient.find 'The Nature Of Necessity'

        then:
        !book.present

        when:
        bookClient.create 'The Nature Of Necessity', 'Alvin Plantinga'
        book = bookClient.find 'The Nature Of Necessity'

        then:
        book.present
    }
}

@Client(value = "/", path = "/books")
interface BookClient {
    @Post("/{title}/{author}")
    Book create(String title, String author)

    @Get("/")
    List<Book> list()

    @Get("/find/{title}")
    Optional<Book> find(String title)
}