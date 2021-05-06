package org.iptime.naduri.domain.module;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.iptime.naduri.domain.BaseTimeEntity;

import javax.persistence.*;

//모듈정보
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Module extends BaseTimeEntity {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    //모듈 이름(명칭)
    @Column(nullable = false)
    private String moduleName;

    //모듈 주소(실제 주소지)
    @Column(nullable = false)
    private String address;

    //모듈 위도
    @Column(nullable = false)
    private String latitude;

    //모듈 경도
    @Column(nullable = false)
    private String longitude;

    //모듈 설명
    @Column(length = 1000, nullable = false)
    private String explanation;

    //이미지 PK(image_hosting 테이블의 id)
    @Column(nullable = false)
    private Long imgId;

    @Builder
    public Module(String moduleName, String address, String latitude, String longitude, String explanation, Long imgId){
        this.moduleName = moduleName;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.explanation = explanation;
        this.imgId = imgId;
    }
}
