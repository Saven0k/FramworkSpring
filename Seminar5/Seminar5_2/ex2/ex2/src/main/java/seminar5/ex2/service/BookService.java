package seminar5.ex2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import seminar5.ex2.model.Book;
import seminar5.ex2.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookService {
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book bookDetails, Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublicationYear(bookDetails.getPublicationYear());
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book not found with id:" + id);
        }
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
