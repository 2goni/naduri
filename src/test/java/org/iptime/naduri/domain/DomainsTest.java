package org.iptime.naduri.domain;

import org.iptime.naduri.domain.course.Course;
import org.iptime.naduri.domain.course.CourseRepository;
import org.iptime.naduri.domain.course_in_module.CourseInModule;
import org.iptime.naduri.domain.course_in_module.CourseInModuleId;
import org.iptime.naduri.domain.course_in_module.CourseInModuleRepository;
import org.iptime.naduri.domain.module.Module;
import org.iptime.naduri.domain.module.ModuleRepository;
import org.iptime.naduri.domain.module_management.ModuleManagement;
import org.iptime.naduri.domain.module_management.ModuleManagementId;
import org.iptime.naduri.domain.module_management.ModuleManagementRepository;
import org.iptime.naduri.domain.module_management.Progress;
import org.iptime.naduri.domain.review.Review;
import org.iptime.naduri.domain.review.ReviewId;
import org.iptime.naduri.domain.review.ReviewRepository;
import org.iptime.naduri.domain.user_achievement.UserAchievement;
import org.iptime.naduri.domain.user_achievement.UserAchievementId;
import org.iptime.naduri.domain.user_achievement.UserAchievementRepository;
import org.iptime.naduri.domain.user_favorites.State;
import org.iptime.naduri.domain.user_favorites.UserFavorites;
import org.iptime.naduri.domain.user_favorites.UserFavoritesId;
import org.iptime.naduri.domain.user_favorites.UserFavoritesRepository;
import org.iptime.naduri.domain.user_info.Gender;
import org.iptime.naduri.domain.user_info.Platform;
import org.iptime.naduri.domain.user_info.UserInfo;
import org.iptime.naduri.domain.user_info.UserInfoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.SimpleDateFormat;
import java.util.Date;

//모든 도메인 테스트클래스
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DomainsTest {
    //모든 모메인 리포지토리 의존성주입
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    UserFavoritesRepository userFavoritesRepository;
    @Autowired
    UserAchievementRepository userAchievementRepository;
    @Autowired
    CourseInModuleRepository courseInModuleRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ModuleManagementRepository moduleManagementRepository;

    //테스트 종료 후 데이터 전부 지우기, 주의!! 재 빌드시 데이터베이스에 데이터가 전부 삭제됩니다.
    @AfterEach
    public void cleanUp() {
        userInfoRepository.deleteAll();
        courseRepository.deleteAll();
        moduleRepository.deleteAll();
        userFavoritesRepository.deleteAll();
        userAchievementRepository.deleteAll();
        courseInModuleRepository.deleteAll();
        reviewRepository.deleteAll();
        moduleManagementRepository.deleteAll();
    }

    //테스트 메소드(각 테이블에 데이터 넣기, 데이터 읽기확인)
    @Test
    public void testDataInsertAndRead(){
        //회원정보 넣기
        userInfoRepository.save(UserInfo.builder()
                .nickName("테스트 닉네임")
                .email("test@test.com")
                .platform(Platform.Google)
                .profilePicture("testprofile.url")
                .gender(Gender.Male)
                .age(10)
                .build());
        //회원정보 가져오기
        UserInfo userInfo = userInfoRepository.findById(1l).orElseThrow(()->new IllegalArgumentException("회원정보 가져오기 에러"));

        //모듈 생성
        moduleRepository.save(Module.builder()
                .moduleName("모듈 이름")
                .address("경기도 수원시")
                .latitude("123.123123")
                .longitude("50.50505")
                .explanation("수원입니다.")
                .imgId(1l)
                .build());
        //모듈정보 가져오기
        Module module = moduleRepository.findById(1l).orElseThrow(()->new IllegalArgumentException("모듈정보 가져오기 에러"));

        //날짜정보 생성
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyymmdd").parse("20210428");
        }catch (Exception e){
            e.printStackTrace();
        }
        //코스 생성
        courseRepository.save(Course.builder()
                .userInfo(userInfo)
                .courseName("코스이름")
                .courseTag("코스태그")
                .courseDate(date)
                .build());
        //코스정보 가져오기
        Course course = courseRepository.findById(1l).orElseThrow(()->new IllegalArgumentException("코스정보 가져오기 에러"));

        //모듈관리정보 생성
        moduleManagementRepository.save(ModuleManagement.builder()
                .moduleManagementId(ModuleManagementId.builder()
                        .userInfo(userInfo)
                        .module(module)
                        .build())
                .progress(Progress.게시요청)
                .build());

        //유저 즐겨찾기정보 생성
        userFavoritesRepository.save(UserFavorites.builder()
                .userFavoritesId(UserFavoritesId.builder()
                        .userInfo(userInfo)
                        .course(course)
                        .build())
                .state(State.즐겨찾기)
                .build());

        //유저 코스별 모듈정보 생성
        userAchievementRepository.save(UserAchievement.builder()
                .userAchievementId(UserAchievementId.builder()
                        .userInfo(userInfo)
                        .course(course)
                        .module(module)
                        .build())
                .build());

        //코스의 모듈정보 생성
        courseInModuleRepository.save(CourseInModule.builder()
                .courseInModuleId(CourseInModuleId.builder()
                        .course(course)
                        .module(module)
                        .build())
                .courseInModuleTag("코스태그")
                .courseInModuleContents("코스내용")
                .build());

        //코스의 회원리뷰 생성
        reviewRepository.save(Review.builder()
                .reviewId(ReviewId.builder()
                        .userInfo(userInfo)
                        .course(course)
                        .build())
                .reviewGrade(5)
                .reviewContents("리뷰내용")
                .build());
    }
}
