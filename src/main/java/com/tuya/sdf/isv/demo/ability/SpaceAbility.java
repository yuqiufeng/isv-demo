package com.tuya.sdf.isv.demo.ability;

import com.tuya.sdf.isv.demo.model.IdaasSpaceOuterRsp;
import com.tuya.sdf.isv.demo.model.SpaceApplyOuterReq;

/**
 * @description
 * @author benguan.zhou@tuya.com
 * @date 2021/05/31
 */
public interface SpaceAbility {
    /**
     * 申请权限空间
     * @param spaceApplyRequest 权限空间申请参数
     * @return 申请是否成功
     * */
    String applySpace(SpaceApplyOuterReq spaceApplyRequest);

    IdaasSpaceOuterRsp querySpace(String spaceGroup, String spaceCode);
}
