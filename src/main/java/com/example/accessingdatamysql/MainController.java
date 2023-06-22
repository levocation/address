package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@PostMapping(path="/user") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@PutMapping("/user")
	public @ResponseBody String UpdateUser(@RequestParam Integer id, @RequestParam 
		String name, @RequestParam String email) {
		User n = new User();
		n.setId(id);
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Updated";
	}

	@DeleteMapping(path="/user")
	public @ResponseBody String deleteUser(@RequestParam Integer id) {
		User n = new User();
		n.setId(id);
		userRepository.delete(n);
		return "Deleted";
	}

}
