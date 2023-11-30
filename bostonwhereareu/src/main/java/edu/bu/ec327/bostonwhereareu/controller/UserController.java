package edu.bu.ec327.bostonwhereareu.controller;

import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;
import edu.bu.ec327.bostonwhereareu.service.UserScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserScoreService userScoreServiceImpl;

    @PostMapping("/score")
    UserScoreDTO createOrUpdateUserScore(@RequestBody UserScoreDTO userScoreDTO) {
        return userScoreServiceImpl.createOrUpdateUserScore(userScoreDTO);
    }

    @GetMapping("/name/{name}/score")
    UserScoreDTO getUserScore(@PathVariable String name) {
        return userScoreServiceImpl.getUserScore(name);
    }
}
