package org.iptime.naduri.domain.user_favorites;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.iptime.naduri.domain.course.Course;
import org.iptime.naduri.domain.user_info.UserInfo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

//복합키 클래스
@Getter
@NoArgsConstructor
@Embeddable
public class UserFavoritesId implements Serializable {

    //유저정보, 외래키 설정
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "userInfoId")
    private UserInfo userInfo;

    //코스정보, 외래키 설정
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "courseId")
    private Course course;

    public void setUserFavoritesId(UserInfo userInfo, Course course){
        this.userInfo = userInfo;
        this.course = course;
    }
}
