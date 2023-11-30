package edu.bu.ec327.bostonwhereareu.service;

import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;

public interface UserScoreService {
    UserScoreDTO createOrUpdateUserScore(UserScoreDTO userScoreDTO);
    UserScoreDTO getUserScore(String userName);
}
