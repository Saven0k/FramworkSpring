package seminar5.ex2.contoller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seminar5.ex2.model.Book;
import seminar5.ex2.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping()
    public List<Book> getAllBook(){
        return bookService.getAllBooks();
    }

}
