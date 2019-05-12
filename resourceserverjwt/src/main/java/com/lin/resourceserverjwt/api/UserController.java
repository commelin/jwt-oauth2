package com.lin.resourceserverjwt.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuzhicheng on 2019/5/12
 */
public class UserController {
    @RequestMapping("/user/userList")
    public ResponseEntity<UserInfo> getUserList() {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String email = user.getUsername() + "@j.com";

        UserInfo userInfo = new UserInfo();
        userInfo.setName(user.getUsername());
        userInfo.setName(email);
        userInfo.setAge("18");

        return ResponseEntity.ok(userInfo);
    }
}
