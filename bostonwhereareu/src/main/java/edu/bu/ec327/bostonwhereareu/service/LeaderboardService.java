package edu.bu.ec327.bostonwhereareu.service;

import edu.bu.ec327.bostonwhereareu.model.dto.PaginatedDTO;
import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;

public interface LeaderboardService {
    PaginatedDTO<UserScoreDTO> getLeaderboard(Integer offset, Integer limit);
}
