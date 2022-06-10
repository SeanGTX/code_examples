package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ServerController {

    @PostMapping
    public ResponseEntity<String> getProfile(@RequestParam(name = "login", required = true) String login,
                                             @RequestParam(name = "password", required = true) String password){
        if (login.equals("admin") && password.equals("1234"))
            return ResponseEntity.ok().body("OK");
        else
            return ResponseEntity.badRequest().body("Bad login");
    }

    @RequestMapping(value="/{login}/{password}", method=RequestMethod.GET)
    public Autorization LoginAutorization(@PathVariable String login, @PathVariable String password) {

        String status;

        if(login.equals("admin") && password.equals("1234"))
            status = "OK";
        else
            status = "NOT OK";
        System.out.println(status);
        return new Autorization(status);
    }
}
