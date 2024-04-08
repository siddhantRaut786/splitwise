package com.example.splitwise;

import com.example.splitwise.commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	private Scanner scanner = new Scanner(System.in);

	@Autowired
	private CommandRegistry commandRegistry;

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			String command = scanner.nextLine();
			commandRegistry.execute(command);
		}
	}
}
