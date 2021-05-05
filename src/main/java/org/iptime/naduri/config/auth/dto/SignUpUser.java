package org.iptime.naduri.config.auth.dto;


import lombok.Data;
import org.iptime.naduri.domain.user_info.Gender;

//회원가입시 사용되는 dto
@Data
public class SignUpUser {
    private Integer age;
    private Gender gender;
}
