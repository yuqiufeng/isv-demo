package com.tuya.sdf.isv.demo.model;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @description:
 * @author: benguan.zhou@tuya.com
 * @date: 2021/05/24
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SpaceApplyOuterReq {

    /**
     * 空间分组
     */
    @SerializedName("spaceGroup")
    String spaceGroup;

    /**
     * 空间隔离标识
     */
    @SerializedName("spaceCode")
    String spaceCode;

    /**
     * 备注
     */
    String remark;

    /**
     * 鉴权扩展字段
     */
    Integer authentication;

    /**
     * 拥有者
     */
    List<String> ownerList;

}
