package com.peach.weixin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
public class WeChatController {
    private static final Log log = LogFactory.getLog(WeChatController.class);



    @RequestMapping(value = "peach", method = RequestMethod.POST)
    public void peach(OutputStream outputStream,
            HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("post");
        System.out.println(IOUtils.toString(req.getInputStream()));
        String abc = "<xml><ToUserName><![CDATA[op3jKwMJISgwakjZ3p2xtEPf7jtA]]></ToUserName>" +
                "<FromUserName><![CDATA[gh_22f57582220d]]></FromUserName>" +
                "<CreateTime>" + Calendar.getInstance().getTimeInMillis() / 1000 + "</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType>" +
                "<Content><![CDATA[桃子桃子桃子]]></Content>" +
                "</xml>";
        System.out.println(abc);
        StringBuffer str = new StringBuffer();
        str.append("<xml>");
        str.append("<ToUserName><![CDATA[gh_22f57582220d]]></ToUserName>");
        str.append("<FromUserName><![CDATA[op3jKwMJISgwakjZ3p2xtEPf7jtA]]></FromUserName>");
        str.append("<CreateTime>" +  Calendar.getInstance().getTimeInMillis() / 1000  + "</CreateTime>");
        str.append("<MsgType><![CDATA[text]]></MsgType>");
        str.append("<Content><![CDATA[你说的是，吗？]]></Content>");
        str.append("</xml>");
        System.out.println(str.toString());
        outputStream.write(abc.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }

    /*@RequestMapping(value = "peach", method = RequestMethod.GET)
    public void peachVerify(
            @RequestParam(value = "signature") String signature,
            @RequestParam(value = "timestamp") String timestamp,
            @RequestParam(value = "nonce") Integer nonce,
            @RequestParam(value = "echostr", required = false) String echostr,
            OutputStream outputStream,
            HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String token = "zengtaotao3390";
        List list = Lists.newArrayList(signature, timestamp, token);
        Ordering<String> naturalOrdering = Ordering.natural();
        List naturalSortList = naturalOrdering.sortedCopy(list);
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        outputStream.write(echostr.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }

    public static String SHA1(String decript) throws NoSuchAlgorithmException {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }*/

}
