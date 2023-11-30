package edu.bu.ec327.bostonwhereareu.mapper;

import edu.bu.ec327.bostonwhereareu.model.dto.UserScoreDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserScoreEntityMapper {

    @Insert("INSERT INTO user_scores (user_name, score) VALUES (#{userName}, #{score}) " +
            "ON DUPLICATE KEY UPDATE score = VALUES(score)")
    void insertOrUpdateUserScore(UserScoreDTO userScoreDTO);

    @Select("SELECT * FROM user_scores WHERE user_name = #{userName}")
    UserScoreDTO selectUserScoreByUserName(@Param("userName") String userName);

    @Select("SELECT * FROM user_scores ORDER BY score DESC LIMIT #{limit} OFFSET #{offset}")
    List<UserScoreDTO> selectLeaderboard(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("SELECT COUNT(*) FROM user_scores")
    int getTotalCount();
}
