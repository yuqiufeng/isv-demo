package com.tuya.sdf.isv.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @Description: 资产授权请求数据模型
 * @auther: Medivh.chen@tuya.com
 * @date: 2021/04/20
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AssetAuthorizationRequest implements Serializable {
    private static final long serialVersionUID = 8392308577501227408L;

    /**
     * 用户ID
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * 资产ID
     */
    @JsonProperty("asset_id")
    private String assetId;

    /**
     * 是否给子节点授权,默认是false
     */
    @JsonProperty("authorized_children")
    private boolean authorizedChildren;
}
