package org.iptime.naduri.config.auth.dto;

import lombok.Getter;
import org.iptime.naduri.domain.user_info.Platform;
import org.iptime.naduri.domain.user_info.UserInfo;

import java.io.Serializable;

// session에 저장될 사용자 정보
@Getter
public class SessionUser implements Serializable {
    private String nickName;
    private String email;
    private String profilepicture;

    public SessionUser(UserInfo user) {
        this.nickName = user.getNickName();
        this.email = user.getEmail();
        this.profilepicture = user.getProfilePicture();
    }

}

