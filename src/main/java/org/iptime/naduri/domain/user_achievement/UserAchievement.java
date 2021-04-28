package org.iptime.naduri.domain.user_achievement;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.iptime.naduri.domain.BaseTimeEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//유저의 코스의 모듈 진행상황 정보
@Getter
@NoArgsConstructor
@Entity
public class UserAchievement extends BaseTimeEntity {

    @EmbeddedId
    private UserAchievementId userAchievementId;

    @Builder
    public UserAchievement(UserAchievementId userAchievementId){
        this.userAchievementId = userAchievementId;
    }
}
