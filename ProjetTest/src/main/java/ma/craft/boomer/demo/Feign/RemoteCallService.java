package ma.craft.boomer.demo.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( path="/book" ,name="zuul" )
public interface RemoteCallService{
	@GetMapping("/book/search/{libelle}")
	public Object getData(@PathVariable("libelle") String libelle); 
}