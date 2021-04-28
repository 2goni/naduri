package org.iptime.naduri.domain.module_management;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.iptime.naduri.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ModuleManagement extends BaseTimeEntity {

    //회원정보의 모듈 정보, 복합키(회원정보, 모듈정보)
    @EmbeddedId
    private ModuleManagementId moduleManagementId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Progress progress;

    @Builder
    public ModuleManagement(ModuleManagementId moduleManagementId, Progress progress){
        this.moduleManagementId = moduleManagementId;
        this.progress = progress;
    }

    public void update(Progress progress){
        this.progress = progress;
    }
}
