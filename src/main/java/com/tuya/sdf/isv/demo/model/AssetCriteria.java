package com.tuya.sdf.isv.demo.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * Description  TODO
 *
 * @author Chyern
 * @since 2021/3/12
 */
@Data
public class AssetCriteria implements Serializable {

    private static final long serialVersionUID = -1260872555499313451L;

    @ApiModelProperty(value = "父资产ID", required = false)
    //@JsonProperty(value = "parent_asset_id", required = false)
    @Schema(required = false, description = "父资产ID", example = "id1")
    private String parentAssetId;

    @ApiModelProperty(value = "资产名称", required = true)
    //@JsonProperty(value = "asset_name", required = true)
    @Schema(required = true, description = "资产名称", example = "资产1")
    private String assetName;
}
