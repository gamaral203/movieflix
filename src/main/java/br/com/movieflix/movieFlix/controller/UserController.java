package br.com.movieflix.movieFlix.controller;

import br.com.movieflix.movieFlix.dto.UserDTO;
import br.com.movieflix.movieFlix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/criar")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO user){
        UserDTO userDTO = userService.save(user);
        return ResponseEntity.ok(userDTO);
    }

}
