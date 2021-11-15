package com.tuya.sdf.isv.demo.connector;


import com.tuya.connector.api.annotations.*;
import com.tuya.sdf.isv.demo.ability.AssetAbility;
import com.tuya.sdf.isv.demo.model.Asset;
import com.tuya.sdf.isv.demo.model.AssetAddRequest;
import com.tuya.sdf.isv.demo.model.AssetModifyRequest;

import java.util.List;

/**
 * Description  TODO
 *
 * @author Chyern
 * @date 2021/3/10
 */
public interface AssetConnector extends AssetAbility {

    @Override
    @POST("/v1.0/iot-02/assets")
    String addAsset(@Body AssetAddRequest request);

    @Override
    @PUT("/v1.0/iot-02/assets/{asset_id}")
    Boolean modifyAsset(@Path("asset_id") String assetId, @Body AssetModifyRequest body);

    @Override
    @DELETE("/v1.0/iot-02/assets/{asset_id}")
    Boolean deleteAsset(@Path("asset_id") String assetId);

    @Override
    @GET("/v1.0/iot-02/assets")
    List<Asset> selectAssets(@Query("asset_ids") String assetIds);
}
