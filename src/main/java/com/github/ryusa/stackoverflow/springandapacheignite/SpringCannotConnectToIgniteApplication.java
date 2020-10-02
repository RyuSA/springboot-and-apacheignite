package com.github.ryusa.stackoverflow.springandapacheignite;

import org.apache.ignite.Ignite;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class SpringCannotConnectToIgniteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCannotConnectToIgniteApplication.class, args);
	}

	@RequiredArgsConstructor
	@RestController
	public static class Debug {

		private final Ignite igniteInstance;

		@GetMapping(path = "/nodenumber")
		public int node_number() {
			return this.igniteInstance.cluster().nodes().size();
		}
	}

}
