package hu.bbabics.springboot_mysql_books.data.repository;

import hu.bbabics.springboot_mysql_books.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, QueryDslPredicateExecutor<Book> {}
