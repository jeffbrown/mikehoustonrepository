package mikehoustonrepository;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class BookControllerTest {

    @Inject
    BookClient bookClient;

    @Test
    public void testFind() throws Exception {
        Optional<Book> book = bookClient.find("The Nature Of Necessity");
        assertFalse(book.isPresent());

        bookClient.create("The Nature Of Necessity", "Alvin Plantinga");

        book = bookClient.find("The Nature Of Necessity");
        assertTrue(book.isPresent());
    }
}

@Client(value="/", path = "/books")
interface BookClient {
    @Post("/{title}/{author}")
    Book create(String title, String author);

    @Get("/")
    List<Book> list();

    @Get("/find/{title}")
    Optional<Book> find(String title);
}