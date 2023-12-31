package com.lanai.lanaiBI.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiManagerTest {

    @Resource
    private AiManager aiManager;
    @Test
    void doChat() {
//        System.out.println(aiManager.doChat("给我讲个笑话吧"));
    }
}