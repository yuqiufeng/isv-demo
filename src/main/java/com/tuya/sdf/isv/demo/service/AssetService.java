package com.tuya.sdf.isv.demo.service;

import com.tuya.sdf.isv.demo.model.Asset;
import com.tuya.sdf.starter.model.response.SdfResponse;

import java.util.List;
import java.util.Set;

/**
 * TODO 类描述
 *
 * @author : gushun.yu@tuya.com
 * @since : 2021/8/19 12:02 下午
 */
public interface AssetService {

    /**
     * 添加资产
     *
     * @param assetName
     * @param parentAssetId
     * @return
     */
    SdfResponse addAsset(String assetName, String parentAssetId, String userId);

    /**
     * 更新资产
     *
     *
     * @param userId
     * @param assetId
     * @param assetName
     * @return
     */
    SdfResponse updateAsset(String userId, String assetId, String assetName);

    /**
     * 删除资产
     *
     *
     * @param userId
     * @param assetId
     * @return
     */
    SdfResponse deleteAsset(String userId, String assetId);

    List<Asset> listAsset(Set<String> assetIds);
}
