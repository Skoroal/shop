package my.web.app.shop.controllers;

import my.web.app.shop.models.Book;
import my.web.app.shop.repo.BookRepository;
import my.web.app.shop.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private BookRepository bookRepository;//через этот объект будем вызывать методы для взаимодействия с БД

//    @GetMapping("/")
//    public String main(Model model) {
//        List<Book> books = bookRepository.findByDescription();
//        model.addAttribute("books",books);
//        return "main";
//    }
    @GetMapping("/")
    public String main(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books",books);
        return "main";
    }
    @GetMapping("/book/add")
    public String showForm() {
       return "form";
    }

    @PostMapping("/book/add")
    public String getForm(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam String description,
                          @RequestParam int price) {

        Book book = new Book(title,author,description,price);
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/book/{id}")
    public String showCard(@PathVariable(value = "id") long id,Model model) {
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book",book);
        return "card.html";
    }
    @GetMapping("/edit/{id}")
    public String editCard(@PathVariable(value = "id") long id,Model model) {
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book",book);
        return "edit.html";
    }
    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable(value = "id") long id,
                             @RequestParam String title,
                             @RequestParam String author,
                             @RequestParam String description,
                             @RequestParam int price) {
        Book book = bookRepository.findById(id).get();
        book.setAuthor(author);
        book.setDescription(description);
        book.setPrice(price);
        book.setTitle(title);
        bookRepository.save(book);
        return "redirect:/book/" + id;
    }
}
