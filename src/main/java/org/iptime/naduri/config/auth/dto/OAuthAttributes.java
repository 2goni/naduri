package org.iptime.naduri.config.auth.dto;

import lombok.Builder;
import lombok.Getter;
import org.iptime.naduri.domain.user_info.Platform;
import org.iptime.naduri.domain.user_info.UserInfo;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String nickName;
    private String email;
    private String profilePicture;
    private Platform platform;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String nickName, String email, String profilePicture, Platform platform) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.nickName = nickName;
        this.email = email;
        this.profilePicture = profilePicture;
        this.platform = platform;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)){
            return ofNaver("id", attributes);
        }
        else if("kakao".equals(registrationId)){
            return ofKakao("id", attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .nickName((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .profilePicture((String) attributes.get("picture"))
                .platform(Platform.Google)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes){
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        System.out.println();

        return OAuthAttributes.builder()
                .nickName((String) response.get("name"))
                .email((String) response.get("email"))
                .profilePicture((String) response.get("profile_image"))
                .platform(Platform.Naver)
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes){
        Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");

        return OAuthAttributes.builder()
                .nickName((String) profile.get("nickname"))
                .profilePicture((String) profile.get("profile_image"))
                .email((String) kakao_account.get("email"))
                .platform(Platform.Kakao)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
    public UserInfo toEntity(){
        return UserInfo.builder()
                .nickName(nickName)
                .email(email)
                .profilePicture(profilePicture)
                .platform(platform)
                .build();
    }
}

