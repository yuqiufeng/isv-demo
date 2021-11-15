package com.tuya.sdf.isv.demo.highway;


import com.tuya.highway.common.annotation.RequestParam;
import com.tuya.highway.common.annotation.RestMapping;
import com.tuya.highway.common.constants.PositionEnum;
import com.tuya.highway.common.constants.RequestMethod;
import com.tuya.sdf.isv.demo.model.Asset;
import com.tuya.sdf.isv.demo.model.AssetCriteria;
import com.tuya.sdf.starter.model.response.SdfResponse;

import java.util.List;

/**
 * 资产管理接口，接入highway
 *
 * @author : yulian
 * @since : 2021/8/24 10:21
 */
public interface AssetInterface {

    /**
     * 新增资产
     *
     * @param criteria
     * @return
     */
    @RestMapping(value = "/v1.0/assets", desc = "新增资产", method = RequestMethod.POST, returnOriginalResponse = true)
    SdfResponse addAsset(
            @RequestParam(position = PositionEnum.BODY, desc = "资产信息", required = true, example = "资产信息参数")
                    AssetCriteria criteria);

    /**
     * 修改资产
     *
     * @param assetId
     * @param criteria
     * @return
     */
    @RestMapping(value = "/v1.0/assets/{asset_id}", desc = "修改资产", method = RequestMethod.PUT, returnOriginalResponse = true)
    SdfResponse updateAsset(
            @RequestParam(position = PositionEnum.URI, desc = "资产id", required = true, example = "1234")
                    String assetId,
            @RequestParam(position = PositionEnum.BODY, desc = "资产信息", required = true, example = "资产信息参数")
                    AssetCriteria criteria);

    /**
     * 删除资产
     *
     * @param assetId
     * @return
     */
    @RestMapping(value = "/v1.0/assets/{asset_id}", desc = "删除资产", method = RequestMethod.DELETE, returnOriginalResponse = true)
    SdfResponse deleteAsset(
            @RequestParam(position = PositionEnum.URI, desc = "资产id", required = true, example = "1234")
                    String assetId);


    @RestMapping(value = "/v1.0/assets/{asset_ids}", desc = "查询资产", method = RequestMethod.GET, returnOriginalResponse = true)
    SdfResponse<List<Asset>> select(@RequestParam(position = PositionEnum.URI, desc = "资产id", required = true, example = "1234")String assetsIds);
}
