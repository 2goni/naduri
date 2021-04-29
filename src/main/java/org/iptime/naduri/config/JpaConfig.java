package org.iptime.naduri.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//jpa사용중 create_date, modified_date 받기
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
