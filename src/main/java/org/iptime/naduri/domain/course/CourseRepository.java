package org.iptime.naduri.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;

//코스정보 저장소
public interface CourseRepository extends JpaRepository<Course, Long> {
}
