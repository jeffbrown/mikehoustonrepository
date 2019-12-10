package mikehoustonrepository

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> find(String title)
}
