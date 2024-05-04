/*package com.eya.livres;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class LivresApplication {
	public static void main(String[] args) {
		SpringApplication.run(LivresApplication.class, args);
	}
}*/

package com.eya.livres;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.eya.livres.entities.Livre;
import com.eya.livres.entities.Role;
import com.eya.livres.entities.User;
import com.eya.livres.service.LivreService;
import com.eya.livres.service.UserService;

import jakarta.annotation.PostConstruct;
//
//public class LivresApplication implements CommandLineRunner {
////@Autowired
////LivreService livreService;
////public static void main(String[] args) {
////SpringApplication.run(LivresApplication.class, args);
////}
////@Override
////public void run(String... args) throws Exception {
////livreService.saveLivre(new Livre("PC Dell","bbb", 2600.0, new Date()));
////livreService.saveLivre(new Livre("PC Asus", "ccc",2800.0, new Date()));
////livreService.saveLivre(new Livre("Imprimante Epson","ddd", 900.0, new Date()));
////}
////}
@SpringBootApplication

public class LivresApplication implements CommandLineRunner{
@Autowired
LivreService livreService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(LivresApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	 //System.out.println("Password Encoded BCRYPT :******************** ");
	 //System.out.println(passwordEncoder.encode("123"));
	/*produitService.saveProduit(new Produit("PC Dell", 2600.0, new Date()));
	produitService.saveProduit(new Produit("PC Asus", 2800.0, new Date()));
	produitService.saveProduit(new Produit("Imp Epson", 900.0, new Date()));
	*/
	}

	
	/*
	 * @PostConstruct void init_users() { //ajouter les rôles
	 * userService.addRole(new Role(null,"ADMIN")); userService.addRole(new
	 * Role(null,"AGENT")); userService.addRole(new Role(null,"USER")); //ajouter
	 * les users userService.saveUser(new User(null,"admin","123",true,null));
	 * userService.saveUser(new User(null,"eya","123",true,null));
	 * userService.saveUser(new User(null,"user1","123",true,null)); //ajouter les
	 * rôles aux users userService.addRoleToUser("admin", "ADMIN");
	 * userService.addRoleToUser("eya", "USER"); userService.addRoleToUser("eya",
	 * "AGENT"); userService.addRoleToUser("user1", "USER"); }
	 */

//	@Override
//	public void run(String... args) throws Exception {
//		repositoryRestConfiguration.exposeIdsFor(Livre.class);
//	}
}
