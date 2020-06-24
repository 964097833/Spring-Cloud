package cn.yqd.service;

import cn.yqd.entity.BookEntity;

import java.util.List;

public interface BookService {
	//更新或保存
	BookEntity save(BookEntity book);
	
	BookEntity getBookById(Long id);
	
	List<BookEntity> selectAll();
	
	void deleteById(Long id);
}