package my.web.app.shop.models;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="product_id", unique=true, nullable=false, updatable=false)
    private Book book;
    private int price;
    private int count;

    public Cart() {
    }

    public Cart(Book book, int price, int count) {
        this.book = book;
        this.price = price;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", book=" + book +
                ", price='" + price + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
