package com.tuya.sdf.isv.demo.controller;

import com.tuya.sdf.isv.demo.highway.AssetInterface;
import com.tuya.sdf.isv.demo.model.Asset;
import com.tuya.sdf.isv.demo.model.AssetCriteria;
import com.tuya.sdf.isv.demo.service.AssetService;
import com.tuya.sdf.starter.model.response.SdfResponse;
import com.tuya.sdf.starter.util.SdfContextHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 资产管理
 *
 * @author : gushun.yu@tuya.com
 * @since : 2021/8/18 10:57 上午
 */

@Slf4j
@RequestMapping("/v1.0/assets")
@RestController
@Api(tags = "资产管理")
public class AssetController implements AssetInterface {

    @Resource
    private AssetService assetService;

    @Override
    @PostMapping
    public SdfResponse addAsset(@RequestBody AssetCriteria criteria) {
        return assetService
                .addAsset(criteria.getAssetName(), criteria.getParentAssetId(), SdfContextHolder.getUser().getUserId());
    }

    @Override
    @PutMapping(value = "/{asset_id}")
    public SdfResponse updateAsset(@ApiParam(name = "asset_id", value = "资产ID", required = true)
                                @PathVariable("asset_id") String assetId,
                                @RequestBody AssetCriteria criteria) {
        return assetService.updateAsset(SdfContextHolder.getUser().getUserId(), assetId, criteria.getAssetName());
    }

    @Override
    @DeleteMapping(value = "/{asset_id}")
    public SdfResponse deleteAsset(@ApiParam(name = "asset_id", value = "资产ID", required = true)
                                @PathVariable("asset_id") String assetId) {
        return assetService.deleteAsset(SdfContextHolder.getUser().getUserId(), assetId);
    }

    @Override
    @GetMapping("/{asset_ids}")
    public SdfResponse<List<Asset>> select(@PathVariable(name = "asset_ids") String assetsIds) {
        Set<String> assetList = new HashSet<>();
        assetList.addAll(Arrays.asList(assetsIds.split(",")));
        return SdfResponse.success(assetService.listAsset(assetList));
    }
}
