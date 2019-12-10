package mikehoustonrepository

import io.micronaut.context.annotation.Replaces
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect

@JdbcRepository(dialect = Dialect.H2)
@Replaces(BookRepository.class)
interface TestBookRepository extends BookRepository{}
