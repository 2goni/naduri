package org.iptime.naduri.domain.user_info;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.iptime.naduri.domain.BaseTimeEntity;

import javax.persistence.*;

//유저 정보 저장
@Getter
@NoArgsConstructor
@Entity
public class UserInfo extends BaseTimeEntity {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserInfoId;

    //닉네임(별칭), OAuth2에서 가져올 정보
    @Column(nullable = false)
    private String nickName;

    //이메일, OAuth2에서 가져올 정보
    @Column(nullable = false)
    private String email;

    //사진(url 주소), OAuth2에서 가져올 정보, null 허용
    @Column(length = 500)
    private String profilePicture;

    //성별, null 허용
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //나이, null 허용
    private Integer age;

    //경험치, 기본값 0;
    @ColumnDefault("0")
    private Long experience = 0l;

    @Builder
    public UserInfo(String nickName, String email, String profilePicture, Gender gender, Integer age, Long experience){
        this.nickName = nickName;
        this.email = email;
        this.profilePicture = profilePicture;
        this.gender = gender;
        this.age = age;
        this.experience = experience;
    }

    //성별, 나이 업데이트 메소드(null 값도 허용, 다만 파라미터 위치는 맞춰줘야함.)
    public void update(Gender gender, Integer age){
        this.gender = gender;
        this.age = age;
    }
}
