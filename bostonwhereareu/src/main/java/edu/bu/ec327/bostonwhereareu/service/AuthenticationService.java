package edu.bu.ec327.bostonwhereareu.service;

import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;

public interface AuthenticationService {
    UserScoreDTO loginOrCreateUser(String userName);
}
