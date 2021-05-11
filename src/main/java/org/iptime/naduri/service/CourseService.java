package org.iptime.naduri.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.iptime.naduri.domain.module.DTO.ModuleDTO;
import org.iptime.naduri.domain.module.Module;
import org.iptime.naduri.domain.module.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final ModuleRepository moduleRepository;

    public List<ModuleDTO> moduleDtoList(){
        List<ModuleDTO> moduleDTOList = new ArrayList<>();
        List<Module> moduleList = moduleRepository.findAll();
        for(Module module : moduleList){
            ModuleDTO moduleDTO = ModuleDTO.builder()
                    .moduleId(module.getModuleId())
                    .moduleName(module.getModuleName())
                    .address(module.getAddress())
                    .latitude(module.getLatitude())
                    .longitude(module.getLongitude())
                    .explanation(module.getExplanation())
                    .imgId(module.getImgId())
                    .build();
            moduleDTOList.add(moduleDTO);
        }
        return moduleDTOList;
    }
}
