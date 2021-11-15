package com.tuya.sdf.isv.demo.connector;

import com.tuya.connector.api.annotations.Body;
import com.tuya.connector.api.annotations.GET;
import com.tuya.connector.api.annotations.POST;
import com.tuya.connector.api.annotations.Query;
import com.tuya.sdf.isv.demo.ability.SpaceAbility;
import com.tuya.sdf.isv.demo.model.IdaasSpaceOuterRsp;
import com.tuya.sdf.isv.demo.model.SpaceApplyOuterReq;

/**
 * @author benguan.zhou@tuya.com
 * @description
 * @date 2021/05/31
 */
public interface SpaceConnector extends SpaceAbility {

    @Override
    @POST("/v1.0/iot-03/idaas/spaces")
    String applySpace(@Body SpaceApplyOuterReq spaceApplyRequest);

    @Override
    @GET("/v1.0/iot-03/idaas/spaces")
    IdaasSpaceOuterRsp querySpace(@Query("spaceGroup") String spaceGroup,
                                  @Query("spaceCode") String spaceCode);
}
