package cn.yqd.service.impl;

import cn.yqd.entity.BookEntity;
import cn.yqd.repository.BookRepository;
import cn.yqd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "book")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@CachePut(key = "#p0.id")
	public BookEntity save(BookEntity book) {
		BookEntity bookEntity = bookRepository.save(book);
		return bookEntity;
	}
	@Cacheable(key = "#p0")
	public BookEntity getBookById(Long id) {
		BookEntity bookEntity = bookRepository.getOne(id);
		return bookEntity;
	}
	@Cacheable(key="#root.methodName")
	public List<BookEntity> selectAll() {
		List<BookEntity> findAll = bookRepository.findAll();
		return findAll;
	}

	@CacheEvict(key = "#p0")
	public void deleteById(Long id) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setId(id);
		bookRepository.delete(bookEntity);
	}
}