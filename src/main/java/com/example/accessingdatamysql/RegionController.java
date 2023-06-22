package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller        // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class RegionController {
        @Autowired // This means to get the bean called userRepository
        private RegionRepository regionRepository;

        @PostMapping(path="/region") // Map ONLY POST Requests
        public @ResponseBody String addNewUser (@RequestParam String name) {
                Regions n = new Regions();
                n.setRegionName(name);
                regionRepository.save(n);
                return "Saved";
        }

        @GetMapping(path="/regions")
        public @ResponseBody Iterable<Regions> getAllUsers() {
                // This returns a JSON or XML with the users
                return regionRepository.findAll();
        }
}
