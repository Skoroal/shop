package my.web.app.shop.repo;

import my.web.app.shop.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {
//    @Query("SELECT b FROM Book b WHERE b.description='Демо описание'")
    @Query("SELECT b FROM Book b")
    List<Book> findByDescription();
}
