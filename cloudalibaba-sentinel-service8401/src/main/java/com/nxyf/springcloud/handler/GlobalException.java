package com.nxyf.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nxyf.springcloud.utils.R;

/**
 * @program: springcloud
 * @description:
 * @author: myj
 * @create: 2021-01-24 11:23
 */
public class GlobalException {

    public static R exceptionHandler1(BlockException blockException) {
        return R.error().put("data", "exceptionHandler1");
    }

    public static R exceptionHandler2(BlockException blockException) {
        return R.error().put("data", "exceptionHandler2");
    }
}
