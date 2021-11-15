package com.tuya.sdf.isv.demo.service.impl;

import com.tuya.connector.api.config.Configuration;
import com.tuya.sdf.isv.demo.ability.AssetAbility;
import com.tuya.sdf.isv.demo.ability.SpaceAbility;
import com.tuya.sdf.isv.demo.model.Asset;
import com.tuya.sdf.isv.demo.model.AssetAddRequest;
import com.tuya.sdf.isv.demo.model.AssetModifyRequest;
import com.tuya.sdf.isv.demo.service.AssetService;
import com.tuya.sdf.starter.model.response.SdfResponse;
import com.tuya.sdf.starter.util.SdfContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 资产管理
 *
 * @author : gushun.yu@tuya.com
 * @since : 2021/8/19 12:03 下午
 */
@Service
@Slf4j
public class AssetServiceImpl implements AssetService {

    private static final int PAGE_NO = 1;
    private static final int PAGE_SIZE = 100;
    private static final String ASSET_TOP_ID = "-1";
    private static final int BATCH_SIZE = 20;

    private final AtomicInteger atomicInteger = new AtomicInteger(1);
    private final int corePoolSize = 50;
    private final int maximumPoolSize = 50;
    private final long keepAliveTime = 60;
    private final TimeUnit unit = TimeUnit.SECONDS;
    private final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
    private final ThreadFactory threadFactory = r -> new Thread(r, "asset-pool-" + atomicInteger.getAndIncrement());
    private final RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
    private final ExecutorService executorService =
            new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);

    /**
     * 批量查询资产，资产ID个数不超过100个
     */
    private static final int QUERY_ASSERT_MAX_SIZE = 100;

    @Autowired
    private Configuration configuration;

    @Resource
    private AssetAbility assetAbility;

    @Value("${asset.auth.size:40}")
    private Integer assetAuthSize;

    @Resource
    private SpaceAbility spaceAbility;

    @Override
    public SdfResponse addAsset(String assetName, String parentAssetId, String userId) {
        String spaceId = spaceAbility.querySpace(SdfContextHolder.getProject().getProjectCode(), "MICRO_APP_DEFAULT").getSpaceId();
        log.info("Start to authorize first-level assets to admin,spaceId={},assetName={},parentAssetId={},userId={}",
                spaceId, assetName, parentAssetId, userId);

        AssetAddRequest request = new AssetAddRequest();
        request.setName(assetName);
        request.setParentAssetId(parentAssetId);
        String assetId = assetAbility.addAsset(request);
        return SdfResponse.success(assetId);
    }


    @Override
    public SdfResponse updateAsset(String userId, String assetId, String assetName) {
        AssetModifyRequest request = new AssetModifyRequest();
        request.setName(assetName);
        Boolean aBoolean = assetAbility.modifyAsset(assetId, request);
        // updateAssetToCache(assetId, assetName);
        return SdfResponse.success(aBoolean);
    }


    @Override
    public SdfResponse deleteAsset(String userId, String assetId) {
        Boolean aBoolean = assetAbility.deleteAsset(assetId);
        // deleteAssetFromCache(assetId);
        return SdfResponse.success(aBoolean);
    }

    /**
     * 批量查询资产
     *
     * @param assetIds
     * @return
     */
    @Override
    public List<Asset> listAsset(Set<String> assetIds) {
        if (CollectionUtils.isEmpty(assetIds)) {
            return new ArrayList<>();
        }
        return assetAbility.selectAssets(String.join(",", assetIds));

    }
}
