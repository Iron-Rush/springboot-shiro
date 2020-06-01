package cn.czl.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类
 * @author RedRush
 * */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     * 创建shiro过滤器工厂
     * */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //1.设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //2.添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截
         * 常用的过滤器：
         *  anon:无需认证(登陆)即可访问
         *  authc:必须认证才可以访问
         *  user:如果使用rememeberMe的功能可以直接访问
         *  perms:该资源必须得到资源权限才可以访问
         *  roles:该资源必须得到角色权限才可以访问
         * */

        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        //设置白名单(无需认证访问页面)
        filterMap.put("/testThymeleaf", "anon");
        //放行login请求
        filterMap.put("/login", "anon");
        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
        filterMap.put("/manage", "roles[manage]");
        filterMap.put("/add", "perms[user:add]");
        filterMap.put("/update", "perms[user:update]");
        //设置拦截url
        filterMap.put("/*", "authc");
        //        filterMap.put("/add", "authc");
        //        filterMap.put("/update", "authc");

        //修改调整的登陆页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     * 创建默认网络安全管理员
     * */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     * 身份验证器Realm(开发者自行编写设置认证、授权业务)
     * */
    @Bean(name = "userRealm")
    public UserRealm gerRealm(){
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     * shiro方言(shiro权限判断标签)
     * */
    @Bean
    public ShiroDialect getShiroDialect(){
        System.out.println("创建ShiroDialect");
        return new ShiroDialect();
    }

}
