package org.iptime.naduri.domain.user_info;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//유저정보 저장소
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    //email,platform 기준으로 조회
    Optional<UserInfo> findByEmailAndPlatform(String email, Platform platform);
}
