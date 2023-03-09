package cstk.chisato.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {



    @PostMapping("/doLogin")
    public ResponseEntity<Void> doLogin(@RequestParam String username,
                                        @RequestParam String password){


        return ResponseEntity.ok().build();

    }
}
