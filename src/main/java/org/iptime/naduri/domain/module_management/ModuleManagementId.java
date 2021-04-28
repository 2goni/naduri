package org.iptime.naduri.domain.module_management;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.iptime.naduri.domain.module.Module;
import org.iptime.naduri.domain.user_info.UserInfo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

//회원정보의 모듈
@Getter
@NoArgsConstructor
@Embeddable
public class ModuleManagementId implements Serializable {

    //유저정보, 외래키 설정
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "userInfoId")
    private UserInfo userInfo;

    //모듈정보, 외래키 설정
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "moduleId")
    private Module module;

    public void setModuleManagementId(UserInfo userInfo, Module module){
        this.userInfo = userInfo;
        this.module = module;
    }
}
