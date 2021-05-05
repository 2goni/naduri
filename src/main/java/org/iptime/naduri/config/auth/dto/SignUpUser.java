package org.iptime.naduri.config.auth.dto;


import lombok.Data;
import org.iptime.naduri.domain.user_info.Gender;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class SignUpUser {
    private Integer age;
    private Gender gender;

}
