package com.jeefl.common.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @author lyz
 * @date 2017-10-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxJson implements Serializable{

    // 是否成功
    private boolean success = true;

    // 提示信息
    private String msg = "操作成功";

    // 其他信息
    private Object obj = null;

    // 其他参数
    private Map<String, Object> attributes;

}
