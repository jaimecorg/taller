package com.jaimecorg.taller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class TallerApplicationTests {



	@Autowired
	PasswordEncoder encoder; 

	@Test
	void crearUsuariosTest() {

	String password = encoder.encode("12345");
	System.out.println((password));
	}
}
