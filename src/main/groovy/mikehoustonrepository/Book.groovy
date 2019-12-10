package mikehoustonrepository

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Book {
    @Id
    @GeneratedValue
    Long id
    String title
    String author

    Book(String title, String author) {
        this.title = title
        this.author = author
    }
}