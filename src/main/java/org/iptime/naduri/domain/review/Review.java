package org.iptime.naduri.domain.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.iptime.naduri.domain.BaseTimeEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//리뷰정보
@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseTimeEntity {
    //코스의 유저정보, 복합키(코스, 유저)
    @EmbeddedId
    private ReviewId reviewId;

    //코스에 대한 유저평점, null 허용
    private Integer reviewGrade;

    //코스에 대한 유저리뷰내용, null 허용
    private String reviewContents;

    @Builder
    public Review(ReviewId reviewId, Integer reviewGrade, String reviewContents){
        this.reviewId = reviewId;
        if(reviewGrade!=null) this.reviewGrade = reviewGrade;
        if(reviewContents!=null) this.reviewContents = reviewContents;
    }

    public void update(Integer reviewGrade, String reviewContents){
        this.reviewGrade = reviewGrade;
        this.reviewContents = reviewContents;
    }
}
