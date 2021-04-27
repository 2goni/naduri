package org.iptime.naduri.domain.course;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.iptime.naduri.domain.BaseTimeEntity;
import org.iptime.naduri.domain.user_info.UserInfo;

import javax.persistence.*;
import java.util.Date;

//코스정보 저장
@Getter
@NoArgsConstructor
@Entity
public class Course extends BaseTimeEntity {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    //유저정보, FK
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "userInfoId")
    private UserInfo userInfo;

    //코스 이름
    @Column(nullable = false)
    private String courseName;

    //코스 태그, null 허용
    private String courseTag;

    //코스 날짜, 사용자가 직접 작성하는 날짜, null 허용
    @Temporal(TemporalType.DATE)
    private Date courseDate;

    @Builder
    public Course(UserInfo userInfo, String courseName, String courseTag, Date courseDate){
        this.userInfo = userInfo;
        this.courseName = courseName;
        this.courseTag = courseTag;
        this.courseDate = courseDate;
    }

    //업데이트 가능한 목록은 코스이름, 코스태그, 코스날짜, null 값일 경우 수정하지 않는다.
    public void update(String courseName, String courseTag, Date courseDate){
        if(courseName!=null) this.courseName = courseName;
        if(courseTag!=null) this.courseTag = courseTag;
        if(courseDate!=null) this.courseDate = courseDate;
    }
}
