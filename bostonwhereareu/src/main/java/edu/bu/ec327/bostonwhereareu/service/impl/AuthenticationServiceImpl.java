package edu.bu.ec327.bostonwhereareu.service.impl;

import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;
import edu.bu.ec327.bostonwhereareu.service.AuthenticationService;
import edu.bu.ec327.bostonwhereareu.service.UserScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserScoreService userScoreServiceImpl;

    @Override
    public UserScoreDTO loginOrCreateUser(String userName) {
        UserScoreDTO userScoreDTO = userScoreServiceImpl.getUserScore(userName);
        if (null == userScoreDTO) {
            userScoreDTO = new UserScoreDTO();
            userScoreDTO.setUserName(userName);
            userScoreDTO.setScore(0);
            userScoreServiceImpl.createOrUpdateUserScore(userScoreDTO);
        }
        return userScoreDTO;
    }
}
