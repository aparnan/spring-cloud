package springboot.circuitbreaker;

import org.springframework.data.annotation.Id;

public class Product {
	@Id
	private String id;

	private String name;

	public String getName() {
		return name;
	}

}
