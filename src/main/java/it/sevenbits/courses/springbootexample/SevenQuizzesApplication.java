package it.sevenbits.courses.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
public final class SevenQuizzesApplication {
	private SevenQuizzesApplication() {}

	/**
	 *
	 * @param args args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(SevenQuizzesApplication.class, args);
	}
}
