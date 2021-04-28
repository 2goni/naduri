package org.iptime.naduri.domain.user_info;

import org.springframework.data.jpa.repository.JpaRepository;

//유저정보 저장소
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
