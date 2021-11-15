package com.tuya.sdf.isv.demo.ability;


import com.tuya.sdf.isv.demo.model.Asset;
import com.tuya.sdf.isv.demo.model.AssetAddRequest;
import com.tuya.sdf.isv.demo.model.AssetModifyRequest;

import java.util.List;

/**
 * Description  TODO
 *
 * @author Chyern
 * @date 2021/3/11
 */
public interface AssetAbility {

    String addAsset(AssetAddRequest request);

    Boolean modifyAsset(String assetId, AssetModifyRequest body);

    Boolean deleteAsset(String assetId);

    List<Asset> selectAssets(String assetIds);
}
