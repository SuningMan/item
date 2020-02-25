package com.kuang.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lvqs
 * @since 2020-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Product对象", description="")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品编号")
    @TableId(value = "product_id", type = IdType.ID_WORKER_STR)
    private String productId;

    @ApiModelProperty(value = "机构号（1.管理员 2.厂家 3.用户）")
    private String orgId;

    @ApiModelProperty(value = "产品激活时间")
    private String enterTime;

    @ApiModelProperty(value = "二维码保存路径")
    @TableField("QRcode_url")
    private String qrcodeUrl;

    @ApiModelProperty(value = "创建用户openId")
    @TableField("openId")
    private String openId;

    @ApiModelProperty(value = "保修月数")
    @TableField("monthNum")
    private String monthNum;

    @ApiModelProperty(value = "商家维护信息")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "打印状态（1.已打印 0.未打印）")
    @TableField("printStatus")
    private String printStatus;


}
