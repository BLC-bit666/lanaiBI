package com.lanai.lanaiBI.manager;

import com.lanai.lanaiBI.common.ErrorCode;
import com.lanai.lanaiBI.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: lanaiBI
 * @CreateTime: 2023-12-25  10:27
 * @Author: lanai
 * @Description: TODO
 */
@Service
public class AiManager {
    @Resource
    private YuCongMingClient client;

    /**
     * 调用 AI（鱼聪明） 并进行对话，处理结果
     *
     * @param modelId 模型id
     * @param message 用户消息
     * @return 处理结果
     */
    public String doChat(long modelId,String message) {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(modelId);
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
        if(response==null){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"AI 调用异常");
        }
        return response.getData().getContent();
    }
}
