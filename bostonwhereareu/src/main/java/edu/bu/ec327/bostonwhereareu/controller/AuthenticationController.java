package edu.bu.ec327.bostonwhereareu.controller;

import edu.bu.ec327.bostonwhereareu.model.dto.LoginDTO;
import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;
import edu.bu.ec327.bostonwhereareu.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationController {
    private final AuthenticationService authenticationServiceImpl;

    @PostMapping("/login")
    UserScoreDTO loginOrCreateUser(@RequestBody LoginDTO loginDTO) {
        return authenticationServiceImpl.loginOrCreateUser(loginDTO.getUserName());
    }

}
