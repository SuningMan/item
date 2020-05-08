package com.kuang.edu.controller;

import com.kuang.edu.annotation.Log;
import com.kuang.edu.entity.User;
import com.kuang.edu.service.UserService;
import com.kuang.edu.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lqs
 * @Date: 2020/2/25 15:17
 */
@Controller
@Api(tags = "用户登陆接口")
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
     * 跳转到菜单页
     * @return
     */
    @RequestMapping("/nav")
    public String toNav() {
        return "nav";
    }


    /**
     * 产品详情页
     * @return
     */
    @RequestMapping("/productInfo")
    public String toProductInfo() {
        return "productInfo";
    }

    /**
     * 用户详情页
     * @return
     */
    @RequestMapping("/userInfo")
    public String toUserInfo() {
        return "userInfo";
    }

    /**
     * 供应商详情页
     * @return
     */
    @RequestMapping("/supplierInfo")
    public String toSupplierInfo() {
        return "supplierInfo";
    }

    /**
     * 供注册码详情页
     * @return
     */
    @RequestMapping("/registerCodeInfo")
    public String toRegisterCodeInfo() {
        return "registerCodeInfo";
    }

    /**
     * 用户登陆
     Title: loginByPc
     *@author QiuSheng Lv
     *@date 2019年6月30日
     */
    @Log("用户登陆")
    @ApiOperation("用户登陆")
    @RequestMapping("/user/login")
    @ResponseBody
    public JSONObject loginByPc(HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        String userName=request.getParameter("userName");
        String passWord=request.getParameter("passWord");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", userName);
        map.put("userPaw", passWord);
        try {
           User user = userService.findUserIsExist(map);
            if(StringUtils.isNotEmpty(user)) {
                //登录信息存入session
                request.getSession().setAttribute("user", user);
                json.put("success", true);
            }else {
                json.put("error", false);
            }
        } catch (Exception e) {
            json.put("error", false);
            System.out.println(e.toString());
        }
        return json;
    }

    /**
     * 清除session
     Title: loginout
     *@author QiuSheng Lv
     *@date 2019年7月19日
     */
    @RequestMapping(value = "/loginout")
    public String loginout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }
}
