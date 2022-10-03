package hh.swd20.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity

public class Bookstore {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	
	private String title;
	private String author;
	@Column(name="publishing_year")
	private int	year;
	private String	isbn;
	private int price;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Bookstore() {}
	public Bookstore(String title, String author, int year, String isbn, int price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn= isbn;
		this.price= price;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	public int getYear() {
		return year;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getPrice() {
		return price;
	}
	public Category getCategory() {
		return category;
		
	}
	public void setCategory(Category category) {
		this.category=category;
	}
	
	@Override
	public String toString() {
		if (this.category !=null)
		return title+author+year+isbn+price+this.getCategory();
		else
		return title+author+year+isbn+price;
	}
	

	

}

