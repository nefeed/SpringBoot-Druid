package io.nefeed.springdruid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringDruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDruidApplication.class, args);
	}
}
