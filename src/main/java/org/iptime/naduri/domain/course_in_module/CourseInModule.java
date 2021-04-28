package org.iptime.naduri.domain.course_in_module;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.iptime.naduri.domain.BaseTimeEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//코스의 모듈 정보
@Getter
@NoArgsConstructor
@Entity
public class CourseInModule extends BaseTimeEntity {
    //코스의 모듈, 복합키(코스정보, 모듈정보)
    @EmbeddedId
    private CourseInModuleId courseInModuleId;

    //코스의 모듈의 태그
    private String courseInModuleTag;

    //코스의 모듈의 내용
    private String courseInModuleContents;

    @Builder
    public CourseInModule(CourseInModuleId courseInModuleId, String courseInModuleTag, String courseInModuleContents){
        this.courseInModuleId = courseInModuleId;
        this.courseInModuleTag = courseInModuleTag;
        this.courseInModuleContents = courseInModuleContents;
    }

    public void update(String courseInModuleTag, String courseInModuleContents){
        this.courseInModuleTag = courseInModuleTag;
        this.courseInModuleContents = courseInModuleContents;
    }
}
