package seminar5.ex2.repository;

import seminar5.ex2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {

}
