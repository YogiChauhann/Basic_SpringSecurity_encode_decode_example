package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class FirstSecurityWebAppApplicationTests {

	@Test
	void testPasswordEncoders() {
		System.out.println(new BCryptPasswordEncoder().encode("yogi"));
		System.out.println(new Pbkdf2PasswordEncoder().encode("yogi"));
		System.out.println(new SCryptPasswordEncoder().encode("yogi"));
		
		Map<String, PasswordEncoder> encodes = new HashMap<>();
		encodes.put("bcrypt", new BCryptPasswordEncoder());
		encodes.put("scrypt", new SCryptPasswordEncoder());
		System.out.println(new DelegatingPasswordEncoder("scrypt", encodes).encode("yogi"));
	}

}
