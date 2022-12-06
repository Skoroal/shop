package my.web.app.shop.controllers;

import my.web.app.shop.models.Cart;
import my.web.app.shop.repo.BookRepository;
import my.web.app.shop.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/")
    public String greeting(Model model) {
        Iterable<Cart> goods = cartRepository.findAll();
        model.addAttribute("content", "cart");
        model.addAttribute("goods", goods);
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") long bookId) {
        var cart = cartRepository.getCartByBookId(bookId);

        if (cart != null) {
            cart.setCount(cart.getCount() + 1);

        } else {
            var book = bookRepository.findById(bookId).orElse(null);

            if (book != null) {
                cart = new Cart(book, book.getPrice(), 1);
            } else {
                return "redirect:/";
            }
        }

        cartRepository.save(cart);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String addBook(@PathVariable("id") long id) {
        cartRepository.deleteById(id);
        return "redirect:/";
    }
}
