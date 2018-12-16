package pl.moviebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@SpringBootApplication
public class BackendApplication {

    @CrossOrigin(origins = "http://localhost:3000") //trzeba ustawic CORS globalnie
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Dzień dobry - to początek backendu MovieBook'a!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}



