package org.iptime.naduri.domain.review;

import lombok.Builder;
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

@Getter
@NoArgsConstructor
@Embeddable
public class ReviewId implements Serializable {
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

    @Builder
    public ReviewId(UserInfo userInfo, Course course){
        this.userInfo = userInfo;
        this.course = course;
    }
}
