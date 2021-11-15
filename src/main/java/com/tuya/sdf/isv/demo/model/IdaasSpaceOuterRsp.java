package com.tuya.sdf.isv.demo.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author benguan.zhou@tuya.com
 * @description
 * @date 2021/06/07
 */
@Data
@Builder
public class IdaasSpaceOuterRsp {
    String spaceGroup;
    String spaceId;
    String owner;
    String spaceCode;
}
