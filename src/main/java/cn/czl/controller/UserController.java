package cn.czl.controller;

import cn.czl.service.PowerService;
import cn.czl.service.impl.PowerServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    //注入业务
    @Autowired
    private PowerService powerService = new PowerServiceImpl();
    /**
     * 测试方法
     * @author RedRush
     * */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("UserController.hello()");
        return "ok";
    }
    @RequestMapping("/add")
    public String add(){
        System.out.println("UserController.add()");
        return "/user/add";
    }
    @RequestMapping("/update")
    public String update(){
        System.out.println("UserController.update()");
        return "/user/update";
    }
    @RequestMapping("/toLogin")
    public String tologin(){
        return "login";
    }
    /**
     * 登陆逻辑处理
     * @author RedRush
     * */
    @RequestMapping("/login")
    public String login(String name, String password, Model model){
        System.out.println("name" + name + ";password" + password);
        /**
         * 使用shiro编写认证操作
         * */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.获取用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //3.执行登陆方法
        try {
            subject.login(token);
            //登陆成功
            //执行"/testThymeleaf"请求，重定向，跳转到test.html
            return "redirect:/testThymeleaf";
        }catch (UnknownAccountException e){
            //e.printStackTrace();
            //登陆失败：用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            //登陆失败：密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
    /**
     * 测试Thymeleaf
     * @author RedRush
     */
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        //把数据放入model
        model.addAttribute("name", "老陈");
        //返回test.html
        return "test";
    }
    @RequestMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }
    @RequestMapping("/manage")
    public String manage(){
        System.out.println("toManage");
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.获取用户数据
//        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

//        subject.
        return "/user/manage";
    }
}
