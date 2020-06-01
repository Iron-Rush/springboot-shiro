package cn.czl.shiro;

import cn.czl.domain.User;
import cn.czl.domain.UserPower;
import cn.czl.service.PowerService;
import cn.czl.service.UserService;
import cn.czl.service.impl.PowerServiceImpl;
import cn.czl.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义Realm
 * @author RedRush
 * */
public class UserRealm extends AuthorizingRealm {
    //注入业务
    @Autowired
    private UserService userService = new UserServiceImpl();
    @Autowired
    private PowerService powerService = new PowerServiceImpl();
    /**
     * 执行授权逻辑
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //对资源进行授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取当前用户的id
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        //到数据库查询当前用户的授权字符串
        User dbUser = userService.findBasicById(user.getUid());
        //添加资源的授权字符串(关联授权过滤器后面的字符串)
//        authorizationInfo.addStringPermission("user:add");
//        authorizationInfo.addStringPermission(dbUser.getPerms());
        //添加角色的授权字符串
        authorizationInfo.addRole(dbUser.getRole());

        //将权限列表批量导入
        List <UserPower> userPowers= powerService.getUpower(dbUser.getPid());
        for (UserPower userPower:userPowers){
            System.out.println(userPower);
            authorizationInfo.addStringPermission(userPower.getPerm());
        }
//        List<Perm> perms = permDao.getPermById(user.getUid());
//        for (Perm perm : perms){
//            authorizationInfo.addStringPermission(perm.getPermName());
//        }
        return authorizationInfo;
    }
    /**
     * 执行认证逻辑
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        System.out.println(token.getUsername());
        User user = userService.findByName(token.getUsername());
        if(user == null){
            //用户名不存在
            return null;//shiro底层会抛出UnknownAccountException
        }
        //2.判断密码("返回给login方法的数据(授权方法可获取)","数据库密码","realm名字")
        return new SimpleAuthenticationInfo(user, user.getUpwd(), "");
    }
}
