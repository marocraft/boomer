package ma.craft.boomer.demo.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ma.craft.boomer.demo.entities.Book;

@FeignClient( path="/book" ,name="zuul" )
public interface FeignGetAllBooks {
	@GetMapping("/books")
	public List<Book> getData();
	}