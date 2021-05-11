package org.iptime.naduri.domain.module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {

}
