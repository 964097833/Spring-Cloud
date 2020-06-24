package cn.yqd.controller;

import cn.yqd.entity.BookEntity;
import cn.yqd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/save")
	public BookEntity save(@RequestBody BookEntity book) {
		return bookService.save(book);
	}
	
	@RequestMapping("/getById")
	public BookEntity getById(Long id) {
		BookEntity book = bookService.getBookById(id);
		return book;
	}
	
	@RequestMapping("/selectAll")
	public List<BookEntity> selectAll(){
		List<BookEntity> selectAll = bookService.selectAll();
		System.out.println("public List<BookEntity> selectAll(){:"+selectAll);
		return selectAll;
	}
}