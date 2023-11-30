package edu.bu.ec327.bostonwhereareu.service.impl;

import edu.bu.ec327.bostonwhereareu.mapper.UserScoreEntityMapper;
import edu.bu.ec327.bostonwhereareu.model.dto.PaginatedDTO;
import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;
import edu.bu.ec327.bostonwhereareu.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LeaderboardServiceImpl implements LeaderboardService {

    private final UserScoreEntityMapper userScoreEntityMapper;

    @Override
    public PaginatedDTO<UserScoreDTO> getLeaderboard(Integer offset, Integer limit) {
        if (null == offset) {
            offset = 0;
        }
        if (null == limit || limit == 0) {
            limit = 10;
        }
        List<UserScoreDTO> userScoreDTOList = userScoreEntityMapper.selectLeaderboard(offset, limit);
        int totalCount = userScoreEntityMapper.getTotalCount();

        PaginatedDTO<UserScoreDTO> paginatedDTO = new PaginatedDTO<>();
        paginatedDTO.setOffset(offset);
        paginatedDTO.setLimit(limit);
        paginatedDTO.setItems(userScoreDTOList);
        paginatedDTO.setTotalCount(totalCount);

        return paginatedDTO;
    }
}
