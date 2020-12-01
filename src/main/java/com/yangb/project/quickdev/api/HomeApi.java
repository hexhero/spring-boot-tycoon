package com.yangb.project.quickdev.api;

import com.yangb.project.quickdev.common.ResultVo;
import com.yangb.project.quickdev.config.comment.CurrentUser;
import com.yangb.project.quickdev.entity.AppUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by yangb on 2020/4/14
 */
@RestController
public class HomeApi {

    @RequestMapping
    @PreAuthorize("hasAuthority('ROLE_GUEST')")
    public ResultVo index() {
        return ResultVo.makeSuccess("请求成功");
    }

    @RequestMapping("/admin")
    @Secured("ROLE_ADMIN")
    public ResultVo admin(@CurrentUser AppUser user) {
        return ResultVo.makeSuccess(user);
    }
}
