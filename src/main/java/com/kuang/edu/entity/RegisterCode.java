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
@ApiModel(value="RegisterCode对象", description="")
public class RegisterCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "机构号")
    private String orgId;

    @ApiModelProperty(value = "上级机构号")
    private String lastOrg;

    @ApiModelProperty(value = "是否管理员（1.是 0.否）")
    @TableField("isManager")
    private String isManager;

    @ApiModelProperty(value = "注册码序列号")
    private String registerNumber;

    @ApiModelProperty(value = "是否已使用（1.是 0.否）")
    @TableField("isUse")
    private String isUse;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;


}
