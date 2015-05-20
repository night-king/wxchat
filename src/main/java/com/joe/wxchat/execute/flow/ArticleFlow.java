package com.joe.wxchat.execute.flow;

import java.util.HashMap;
import java.util.Map;

import com.joe.wxchat.entity.message.resp.RespTextMessage;
import com.joe.server.dao.entity.User;
import com.joe.wxchat.execute.messagemodel.DefaultResponseTextMessage;

/**
 * NOTE:Create Article Flow
 * Created by zhouwd on 15-5-17.
 */
public class ArticleFlow {

    public static final int STEP_0 = 0;

    /**
     * First: Title
     */
    public static final int STEP_1 = 1;

    /**
     * Second: Content
     */
    public static final int STEP_2 = 2;

    /**
     * Third: Pic
     */
    public static final int STEP_3 = 3;

    /**
     * Fourth: End
     */
    public static final int STEP_4 = 4;

    /**
     * Over
     */
    public static final int STEP_5 = 5;

    private int currentStep;

    private Map<Integer, String> stepContentMap=new HashMap<>();

    public RespTextMessage getCurrentTipTextMsg(User user) {
        return getStepTipTextMsg(currentStep, user);
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }

    public Map<Integer, String> getStepContentMap() {
        return stepContentMap;
    }

    public void setStepContentMap(Map<Integer, String> stepContentMap) {
        this.stepContentMap = stepContentMap;
    }


    private RespTextMessage getStepTipTextMsg(int step, User user) {
        RespTextMessage respTextMessage = DefaultResponseTextMessage.createDefaultTextMsg(user.getUserName());
        String content;

        if (STEP_0 == step) {
            content = "已经返回第一步，请输入标题。";
        } else if (STEP_1 == step) {
            content = "请输入标题。";
        } else if (STEP_2 == step) {
            content = "请输入内容。输入“!<”返回上一步。";
        } else if (STEP_3 == step) {
            content = "请上传图片，如果没有，请直接输入“!>”跳到下一步。输入“!<”可以返回上一步。";
        } else if (STEP_4 == step) {
            content = "请输入“!$”结束。输入“!<”可以返回上一步。";
        } else if (STEP_5 == step) {
            content = "请输入“!$”结束。";
        } else {
            content = "";
        }


        respTextMessage.setContent(content);
        return respTextMessage;
    }


    public String checkStep(){
        String content=null;

        if(null==stepContentMap.get(STEP_1)||"".equals(stepContentMap.get(STEP_1))){
            content="名称不能为空";
        }else if(null==stepContentMap.get(STEP_2)||"".equals(stepContentMap.get(STEP_2))){
            content="内容不能为空";
        }
        return content;
    }
}
