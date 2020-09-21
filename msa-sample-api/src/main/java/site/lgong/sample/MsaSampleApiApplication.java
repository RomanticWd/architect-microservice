package site.lgong.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "site.lgong")
public class MsaSampleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaSampleApiApplication.class, args);
	}

}
