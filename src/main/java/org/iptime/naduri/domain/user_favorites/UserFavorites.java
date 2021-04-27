package org.iptime.naduri.domain.user_favorites;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.iptime.naduri.domain.BaseTimeEntity;

import javax.persistence.*;

//유저 즐겨찾기 정보 저장
@Getter
@NoArgsConstructor
@Entity
public class UserFavorites extends BaseTimeEntity {

    //복합키(유저정보, 코스정보), PK
    @EmbeddedId
    private UserFavoritesId userFavoritesId;

    //상태정보(찜, 즐겨찾기, 완료)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    @Builder
    public UserFavorites(State state){
        this.state = state;
    }

    public void update(State state){
        this.state = state;
    }
}
