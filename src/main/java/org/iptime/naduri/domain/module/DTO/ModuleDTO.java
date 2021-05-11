package org.iptime.naduri.domain.module.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
public class ModuleDTO {
    private Long moduleId;
    private String moduleName;
    private String address;
    private String latitude;
    private String longitude;
    private String explanation;
    private Long imgId;

    @Builder
    public ModuleDTO(Long moduleId, String moduleName, String address, String latitude, String longitude, String explanation, Long imgId){
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.explanation = explanation;
        this.imgId = imgId;
    }
}
