package org.iptime.naduri.domain.course_in_module;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.iptime.naduri.domain.course.Course;
import org.iptime.naduri.domain.module.Module;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

//코스의 모듈정보 복합키
@Getter
@NoArgsConstructor
@Embeddable
public class CourseInModuleId implements Serializable {
    //코스정보, 외래키 설정
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "courseId")
    private Course course;

    //모듈정보, 외래키 설정
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "moduleId")
    private Module module;

    @Builder
    public CourseInModuleId(Course course, Module module){
        this.course = course;
        this.module = module;
    }
}
