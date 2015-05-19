package com.joe.utils;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.entity.message.resp.RespMusicMessage;
import com.joe.wxchat.entity.message.resp.RespNewsMessage;
import com.joe.wxchat.entity.message.resp.RespTextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * 消息工具类
 */
public class MessageUtils {

    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<>();

        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();
        // 读取输入流  
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素  
        Element root = document.getRootElement();
        // 得到根元素的所有子节点  

        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();

        // 遍历所有子节点  
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源  
        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * 文本消息对象转换成xml
     *
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(RespTextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 音乐消息对象转换成xml
     *
     * @param musicMessage 音乐消息对象
     * @return xml
     */
    public static String musicMessageToXml(RespMusicMessage musicMessage) {
        xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }

    /**
     * 图文消息对象转换成xml
     *
     * @param newsMessage 图文消息对象
     * @return xml
     */
    public static String newsMessageToXml(RespNewsMessage newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", RespNewsMessage.RespArticleMessage.class);
        return xstream.toXML(newsMessage);
    }

    public static String messageToXml(RespBaseMessage message) {
        try {
            if (message instanceof RespTextMessage) {
                return textMessageToXml((RespTextMessage) message);
            } else if (message instanceof RespNewsMessage) {
                return newsMessageToXml((RespNewsMessage) message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * 扩展xstream，使其支持CDATA块
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记  
                boolean cdata = true;

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });


}  