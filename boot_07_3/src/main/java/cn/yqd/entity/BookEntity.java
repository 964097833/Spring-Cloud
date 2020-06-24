package cn.yqd.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="book")
@Proxy(lazy = false)//注意，该注解一定要加，否则 查询之后，再次从缓存中取值会报错
public class BookEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id//主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键由数据库自动生成（主要是自动增长型）
	private Long id;
	@Column(name="book_name")
	private String bookName;
	@Column(name="book_author")
	private String bookAuthor;
	@Column(name="book_count")
	private Integer bookCount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	
}