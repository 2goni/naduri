package org.iptime.naduri.controller;

import lombok.RequiredArgsConstructor;
import org.iptime.naduri.domain.module.DTO.ModuleDTO;
import org.iptime.naduri.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/makeCourse")
    public void makeCourse(Model model){
        List<ModuleDTO> moduleDTOList = courseService.moduleDtoList();
        model.addAttribute("moduleListFirst", moduleDTOList.get(0));
        if(courseService.moduleDtoList().size()>1){
            moduleDTOList.remove(0);
            model.addAttribute("moduleList", moduleDTOList);
        }
    }

}
