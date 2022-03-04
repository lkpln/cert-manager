package com.wencheng.wencheng_web.service;

import com.wencheng.wencheng_web.Util.QRcodeUtil;
import com.wencheng.wencheng_web.pojo.Result;
import isc.authclt.IscJcrypt;
import xtqm.code.server.service.XTQMJarService;
import xtqm.code.server.util.Log;
import xtqm.code.server.vo.SystemConstrantEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class QrcodeService {

    public Result getApp(String url ) {
        QRcodeUtil qRcodeUtil = new QRcodeUtil();
        BufferedImage bufferedImage = null;
        XTQMJarService xtqmJarService =new XTQMJarService();
        try {
            bufferedImage = qRcodeUtil.QREncodes(url);
        } catch (IOException ioException) {
            Log.warring("[生成扫码认证二维码错误-1]" + ioException);
            return new Result(SystemConstrantEnum.FAIL.getCode(), SystemConstrantEnum.FAIL.getMessage(), "生成二维码错误");
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String base64Img = "";
        try {
            ImageIO.write(bufferedImage, "PNG", outputStream);
            base64Img = new IscJcrypt().byteTobase64(outputStream.toByteArray());
        } catch (IOException ioException) {

            Log.warring("[生成扫码认证二维码错误-2]" + ioException);
            return new Result(SystemConstrantEnum.FAIL.getCode(), SystemConstrantEnum.FAIL.getMessage(), "生成扫码认证二维码错误");
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException exception) {
                    Log.warring("关闭资源失败！！");
                }
            }
        }
        HashMap<String, Object> resultMap = new HashMap();
        resultMap.put("base64Img", "data:image/png;base64," + base64Img);

        return new Result(SystemConstrantEnum.OK.getCode(), SystemConstrantEnum.OK.getMessage(), resultMap);
    }
}
