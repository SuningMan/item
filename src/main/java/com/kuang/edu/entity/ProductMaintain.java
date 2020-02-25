package com.kuang.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="ProductMaintain对象", description="")
public class ProductMaintain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品编号")
    @TableId(value = "product_id", type = IdType.ID_WORKER_STR)
    private String productId;

    @ApiModelProperty(value = "用户编号")
    private String userId;

    @ApiModelProperty(value = "激活时间")
    private String activateTime;

    @ApiModelProperty(value = "机构号")
    private String orgId;

    @ApiModelProperty(value = "到期时间")
    private String isoverTime;

    @ApiModelProperty(value = "激活时图片保存路径")
    private String activateImageUrl;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;


}
