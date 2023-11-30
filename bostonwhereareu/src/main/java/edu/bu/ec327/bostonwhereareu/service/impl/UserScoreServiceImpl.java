package edu.bu.ec327.bostonwhereareu.service.impl;

import edu.bu.ec327.bostonwhereareu.exception.UserNotFoundException;
import edu.bu.ec327.bostonwhereareu.mapper.UserScoreEntityMapper;
import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;
import edu.bu.ec327.bostonwhereareu.service.UserScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserScoreServiceImpl implements UserScoreService {

    private final UserScoreEntityMapper userScoreEntityMapper;

    @Override
    public UserScoreDTO createOrUpdateUserScore(UserScoreDTO userScoreDTO) {
        userScoreEntityMapper.insertOrUpdateUserScore(userScoreDTO);
        return userScoreEntityMapper.selectUserScoreByUserName(userScoreDTO.getUserName());
    }

    @Override
    public UserScoreDTO getUserScore(String userName) {
        UserScoreDTO userScoreDTO = userScoreEntityMapper.selectUserScoreByUserName(userName);
        if (null == userScoreDTO) {
            throw new UserNotFoundException("User score not found for user: " + userName);
        }

        return userScoreDTO;
    }
}
