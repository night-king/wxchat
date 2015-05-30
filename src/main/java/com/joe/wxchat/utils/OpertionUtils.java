package com.joe.wxchat.utils;

/**
 * All Opertion start with "!".
 */
public class OpertionUtils {

    //    public static String OPER_L1 = "!#";
    public static final String EN_STR_VIEW = "!@";
    public static final String EN_STR_PRE = "!<";
    public static final String EN_STR_NEXT = "!>";
    public static final String EN_STR_QUERY = "!%";
    public static final String EN_STR_CLEAR = "!|";
    public static final String EN_STR_ADD = "!+";
    public static final String EN_STR_SAVE = "!$";
    public static final String EN_STR_DEL = "!-";


    public static final String CN_STR_VIEW = "！@";
    public static final String CN_STR_PRE = "！<";
    public static final String CN_STR_NEXT = "！>";
    public static final String CN_STR_QUERY = "！%";
    public static final String CN_STR_CLEAR = "！|";
    public static final String CN_STR_ADD = "！+";
    public static final String CN_STR_SAVE = "！$";
    public static final String CN_STR_DEL = "！-";

    public static final int TYPE_QUERY = 0;
    public static final int TYPE_VIEW = 1;
    public static final int TYPE_PRE = 2;
    public static final int TYPE_NEXT = 3;
    public static final int TYPE_CLEAR = 4;
    public static final int TYPE_ADD = 5;
    public static final int TYPE_SAVE = 6;
    public static final int TYPE_DEL = 7;


    public static int getOperType(String content) {
        if (EN_STR_QUERY.equals(content) || CN_STR_QUERY.equals(content)) {
            return TYPE_QUERY;
        } else if (EN_STR_VIEW.equals(content) || CN_STR_VIEW.equals(content)) {
            return TYPE_VIEW;
        } else if (EN_STR_PRE.equals(content) || CN_STR_PRE.equals(content)) {
            return TYPE_PRE;
        } else if (EN_STR_NEXT.equals(content) || CN_STR_NEXT.equals(content)) {
            return TYPE_NEXT;
        } else if (EN_STR_CLEAR.equals(content) || CN_STR_CLEAR.equals(content)) {
            return TYPE_CLEAR;
        } else if (EN_STR_ADD.equals(content) || CN_STR_ADD.equals(content)) {
            return TYPE_ADD;
        } else if (EN_STR_SAVE.equals(content) || CN_STR_SAVE.equals(content)) {
            return TYPE_SAVE;
        } else if (EN_STR_DEL.equals(content) || CN_STR_DEL.equals(content)) {
            return TYPE_DEL;
        } else {
            return -1;
        }
    }

    public static String getRequestContent(String content) {
        if (content.startsWith(EN_STR_QUERY)) {
            return content.replace(EN_STR_QUERY, "");
        } else if (content.startsWith(CN_STR_QUERY)) {
            return content.replace(CN_STR_QUERY, "");

        } else if (content.startsWith(EN_STR_VIEW)) {
            return content.replace(EN_STR_VIEW, "");
        } else if (content.startsWith(CN_STR_VIEW)) {
            return content.replace(CN_STR_VIEW, "");

        } else if (content.startsWith(EN_STR_PRE)) {
            return content.replace(EN_STR_PRE, "");
        } else if (content.startsWith(CN_STR_PRE)) {
            return content.replace(CN_STR_PRE, "");

        } else if (content.startsWith(EN_STR_NEXT)) {
            return content.replace(EN_STR_NEXT, "");
        } else if (content.startsWith(CN_STR_NEXT)) {
            return content.replace(CN_STR_NEXT, "");

        } else if (content.startsWith(EN_STR_CLEAR)) {
            return content.replace(EN_STR_CLEAR, "");
        } else if (content.startsWith(CN_STR_CLEAR)) {
            return content.replace(CN_STR_CLEAR, "");

        } else if (content.startsWith(EN_STR_ADD)) {
            return content.replace(EN_STR_ADD, "");
        } else if (content.startsWith(CN_STR_ADD)) {
            return content.replace(CN_STR_ADD, "");

        } else if (content.startsWith(EN_STR_SAVE)) {
            return content.replace(EN_STR_SAVE, "");
        } else if (content.startsWith(CN_STR_SAVE)) {
            return content.replace(CN_STR_SAVE, "");

        } else if (content.startsWith(EN_STR_DEL)) {
            return content.replace(EN_STR_DEL, "");
        } else if (content.startsWith(CN_STR_DEL)) {
            return content.replace(CN_STR_DEL, "");
        }
        return content;
    }

}
