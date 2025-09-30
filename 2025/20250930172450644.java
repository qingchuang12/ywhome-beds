package com.transfar.soar.admin.controller;

import com.transfar.soar.common.beans.UserInfo;
import com.transfar.soar.common.feign.AdminFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  admin 模块拆分接口
 * @author liuxiaogang
 * @create 2021-01-11 10:10
 **/
@Api(tags = "账户管理")
@RestController
public class AdminController {

    @Resource
    AdminFeign adminFeign;

    @PostMapping("/login")
    @ApiOperation(value = "登陆")
    public Object login(@RequestBody UserInfo userInfo) {
       return adminFeign.login(userInfo);
    }

    @GetMapping("/query/userList")
    @ApiOperation(value = "用户列表")
    public Object queryUserList(@RequestParam(required = false) Integer roleId, @RequestParam(required = false) Long deptId) {
        return adminFeign.queryUserList(roleId, deptId);
    }

    @GetMapping("/query/user")
    @ApiOperation(value = "用户信息")
    public Object queryUserInfo(@RequestParam(required = false) String token, @RequestParam(required = false) Long userId) {
        return adminFeign.queryUserInfo(token, userId);
    }

    @GetMapping("/query/roleList")
    @ApiOperation(value = "角色列表")
    public Object queryRoleList() {
        return adminFeign.queryRoleList();
    }

    @GetMapping("/query/deptList/{deptId}")
    @ApiOperation(value = "单位列表")
    public Object queryDeptList(@PathVariable String deptId) {
        return adminFeign.queryDeptList(deptId);
    }

}
