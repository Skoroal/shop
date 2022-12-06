package my.web.app.shop.repo;

import my.web.app.shop.models.Book;
import my.web.app.shop.models.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart getCartByBookId(long id);
}
