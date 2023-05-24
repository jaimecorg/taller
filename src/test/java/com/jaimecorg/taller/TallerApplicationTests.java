package com.jaimecorg.taller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jaimecorg.taller.model.Permiso;
import com.jaimecorg.taller.model.Usuario;
import com.jaimecorg.taller.repository.PermisoRepository;
import com.jaimecorg.taller.repository.UsuarioRepository;

@SpringBootTest
class TallerApplicationTests {

	@Autowired
	UsuarioRepository userRepository;

	@Autowired
	PermisoRepository permissionRepository;

	@Autowired
	PasswordEncoder encoder;

	@Test
	void crearUsuariosTest() {

		Usuario u1 = new Usuario();
		u1.setCodigo(1);
		u1.setNombre("usuario1");
		u1.setPassword(encoder.encode("1234"));
		u1.setEmail("jcg@gmail.com");

		Usuario u2 = new Usuario();
		u2.setCodigo(2);
		u2.setNombre("usuario2");
		u2.setPassword(encoder.encode("5555"));
		u2.setEmail("jcg@gmail.com");

		Usuario u3 = new Usuario();
		u3.setCodigo(3);
		u3.setNombre("usuario3");
		u3.setPassword(encoder.encode("666"));
		u3.setEmail("jcg@gmail.com");

		Usuario u4 = new Usuario();
		u4.setCodigo(20);
		u4.setNombre("usuario4");
		u4.setPassword(encoder.encode("777"));
		u4.setEmail("jcg@gmail.com");

		Permiso permisoAdmin = new Permiso();
		permisoAdmin.setCodigo(1);
		permisoAdmin.setNombre("ADMIN");

		Permiso permisoClientes = new Permiso();
		permisoClientes.setCodigo(2);
		permisoClientes.setNombre("CLIENTES");

		Permiso permisoEmpleados = new Permiso();
		permisoEmpleados.setCodigo(3);
		permisoEmpleados.setNombre("EMPLEADOS");


		Permiso permisoNotas = new Permiso();
		permisoNotas.setCodigo(4);
		permisoNotas.setNombre("NOTAS");

		List<Permiso> permisosTodos = new ArrayList<Permiso>();
		permisosTodos.add(permisoAdmin);



		u1.setPermissions(permisosTodos);


		permissionRepository.save(permisoAdmin);
		permissionRepository.save(permisoClientes);
		permissionRepository.save(permisoEmpleados);
		permissionRepository.save(permisoNotas);

		userRepository.save(u1);
		userRepository.save(u3);
		userRepository.save(u4);

		Usuario saveUsuario2 = userRepository.save(u2);

		assertTrue(u2.getPassword().equalsIgnoreCase(saveUsuario2.getPassword()));
	}
}
