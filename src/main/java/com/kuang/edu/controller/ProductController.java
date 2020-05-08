package com.kuang.edu.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuang.edu.annotation.Log;
import com.kuang.edu.entity.Product;
import com.kuang.edu.entity.User;
import com.kuang.edu.service.ProductService;
import com.kuang.edu.service.UserService;
import com.kuang.edu.util.StringUtils;
import io.swagger.annotations.Api;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lvqs
 * @since 2020-02-25
 */
@Api(tags = "产品相关接口")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查询所有产品信息 Title: findAllProduct
     *
     * @author QiuSheng Lv
     * @date 2019-6-22
     */
    @Log("查询所有产品信息")
    @RequestMapping("/findAllProduct")
    @ResponseBody
    public Map<String, Object> findAllProduct(int page, int rows, String search, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> returnMap = new HashMap<>();
        //TODO 判断unionId是什么权限，除了管理员之外，带orgid进行查询
        try {
            User loginUser = (User) request.getSession().getAttribute("user");
            if (StringUtils.isNotEmpty(loginUser)) {
                //最高权限管理员
                if ("管理员".equals(loginUser.getOrg())&&loginUser.getLastOrg().equals("管理员")) {
                    // 管理员
                } else if(!"管理员".equals(loginUser.getOrg())&& "管理员".equals(loginUser.getLastOrg())){
                    //厂家管理员
                    map.put("orgId", loginUser.getOrg());
                }
            }
            PageHelper.startPage(page, rows);
            map.put("search", search);
            List<Product> products = productService.findAllProduct(map);
            PageInfo<Product> pageInfo = new PageInfo<Product>(products);
            returnMap.put("pageInfo", pageInfo);
            returnMap.put("total", pageInfo.getTotal());
            returnMap.put("rows", pageInfo.getList());
        } catch (Exception e) {
            returnMap.put("returnCode", "fail");
        }
        return returnMap;
    }
}

