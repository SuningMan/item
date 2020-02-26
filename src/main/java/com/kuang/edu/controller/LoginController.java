package com.kuang.edu.controller;

import com.kuang.edu.entity.User;
import com.kuang.edu.service.UserService;
import com.kuang.edu.util.StringUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lqs
 * @Date: 2020/2/25 15:17
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登陆界面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 跳转到主页面
     Title: toMain
     *@author QiuSheng Lv
     *@date 2019年7月17日
     */
    @RequestMapping(value = "/toMain")
    public String toMain(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "main";
    }

    /**
     * 电脑端登陆
     Title: loginByPc
     *@author QiuSheng Lv
     *@date 2019年6月30日
     */
    @RequestMapping("/user/login")
    @ResponseBody
    public JSONObject loginByPc(HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        String userName=request.getParameter("userName");
        String passWord=request.getParameter("passWord");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", userName);
        map.put("userPaw", passWord);
        User user=new User();
        try {
            user = userService.findUserIsExist(map);
            System.out.println("===="+user.toString());
            if(StringUtil.notNullorEmpty(user)) {
                request.getSession().setAttribute("user", user);//登录信息存入session
                json.put("success", true);
            }else {
                json.put("error", false);
            }
        } catch (Exception e) {
            // TODO: handle exception
            json.put("error", false);
            System.out.println(e.toString());
        }
        return json;
    }
}
