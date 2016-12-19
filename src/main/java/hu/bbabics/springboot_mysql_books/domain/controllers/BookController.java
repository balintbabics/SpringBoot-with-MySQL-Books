package hu.bbabics.springboot_mysql_books.domain.controllers;

import hu.bbabics.springboot_mysql_books.data.repository.BookRepository;
import hu.bbabics.springboot_mysql_books.data.entity.Book;
import hu.bbabics.springboot_mysql_books.data.entity.QBook;
import hu.bbabics.springboot_mysql_books.domain.data.BookBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired BookRepository bookRepository;

    private BookBO mergeBook(Book book) {

        BookBO bookBO = new BookBO();
        bookBO.setId(book.getId());
        bookBO.setAuthor(book.getAuthor());
        bookBO.setTitle(book.getTitle());
        return bookBO;
    }

    private Book convertToBook(BookBO bookBO) {

        Book book = new Book();
        book.setId(bookBO.getId());
        book.setAuthor(bookBO.getAuthor());
        book.setTitle(bookBO.getTitle());
        return book;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public BookBO get(@PathVariable("id") Long id) {

        Book book = bookRepository.findOne(id);
        return mergeBook(book);
    }

    @RequestMapping("/getByTitle/{title}")
    @ResponseBody
    public List<BookBO> getByTitle(@PathVariable("title") String title) {

        Iterable<Book> books = bookRepository.findAll(QBook.book.title.contains(title));
        List<BookBO> bookBOs = new ArrayList<>();
        for(Book book : books) {
            bookBOs.add(mergeBook(book));
        }
        return bookBOs;
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    @ResponseBody
    public BookBO save(@RequestBody BookBO bookBO) {

        Book bookToSave = convertToBook(bookBO);
        if(bookBO.getId() != null) {

            Book book = bookRepository.findOne(bookBO.getId());
            if(book == null) {

                throw new IllegalArgumentException("The book specified by ID [" + bookBO.getId() + "] does not exist!");
            }
        }
        return mergeBook(bookRepository.save(bookToSave));
    }
}
