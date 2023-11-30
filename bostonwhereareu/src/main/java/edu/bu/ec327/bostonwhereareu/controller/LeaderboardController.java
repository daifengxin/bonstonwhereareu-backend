package edu.bu.ec327.bostonwhereareu.controller;

import edu.bu.ec327.bostonwhereareu.model.dto.PaginatedDTO;
import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;
import edu.bu.ec327.bostonwhereareu.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/leaderboard")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LeaderboardController {
    private final LeaderboardService leaderboardServiceImpl;

    @GetMapping()
    PaginatedDTO<UserScoreDTO> getLeaderboard(@RequestParam(required = false) Integer offset,
                                              @RequestParam(required = false) Integer limit) {
        return leaderboardServiceImpl.getLeaderboard(offset, limit);
    }
}
