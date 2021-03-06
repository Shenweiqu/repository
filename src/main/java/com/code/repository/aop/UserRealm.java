package com.code.repository.aop;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm<IUserService> extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

//    @Autowired
//    private IUserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        try {
            UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
            String username = usernamePasswordToken.getUsername();
            String password = new String(usernamePasswordToken.getPassword());
          /*  User user = userService.findByUsername(username);
            String userPassword = user.getPassword();
            if (password.equals(userPassword)) {
                return new SimpleAuthenticationInfo(user, userPassword, "userRealm");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
