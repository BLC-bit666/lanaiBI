package com.lanai.lanaiBI.manager;

import com.lanai.lanaiBI.common.ErrorCode;
import com.lanai.lanaiBI.exception.ThrowUtils;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: lanaiBI
 * @CreateTime: 2023-12-28  09:09
 * @Author: lanai
 * @Description: 用以提供RedisLimiter限流基础服务的（通用能力增加可移植性）
 */
@Service
public class RedisLimiterManager {
    @Resource
    private RedissonClient redissonClient;

    public void doRateLimit(String key) {
        // 为每个 key 创建一个限流器
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(key);
        // 设定限流器规则 OVERALL : 所有rateLimiter实例的总速率为每秒5次
        rateLimiter.trySetRate(RateType.OVERALL, 5, 1, RateIntervalUnit.SECONDS);
        boolean canOp = rateLimiter.tryAcquire(1);
        ThrowUtils.throwIf(!canOp, ErrorCode.TOO_MANY_REQUEST);
    }

}