package com.wencheng.wencheng_web.Util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class QRcodeUtil {
    /**
     * 生成二维码图片.
     *
     * @param content 二维码内容.
     * @return BufferedImage
     * @throws IOException io异常
     */
    public BufferedImage appsssQREncode(String content) throws IOException {
        int width = 500; // 图像宽度
        int height = 500; // 图像高度
        Map<EncodeHintType, Object> hints = new HashMap();
        //内容编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //设置二维码边的空度，非负数
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = null;
        BufferedImage bufferedImage = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
            //去白边
            BitMatrix bitMatrix1 = deleteWhite(bitMatrix);
            //原始 不带Logo二维码
            bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix1, matrixToImageConfig);
        } catch (WriterException e) {
            e.printStackTrace();
        }

//        无logo
        //  return bufferedImage;



        //带logo
        assert bufferedImage != null;
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/img/logo.png");
        return LogoMatrix(bufferedImage,resourceAsStream);


    }


    /**
     * 生成二维码Logo.
     *
     * @param matrixImage 二维码原图
     * @param inputStream    要添加的Logo
     * @return
     * @throws IOException
     */
    public BufferedImage LogoMatrix(BufferedImage matrixImage, InputStream inputStream) throws IOException {


        //读取原始二维码，构建绘图对象.
        Graphics2D g2 = matrixImage.createGraphics();
        int matrixWidth = matrixImage.getWidth();
        int matrixHeigh = matrixImage.getHeight();

        //读取Logo图片
        BufferedImage logo = ImageIO.read(inputStream);
        //开始绘制图片
        //g2.drawImage(logo, matrixWidth / 7 * 3, matrixHeigh / 5 * 2, matrixWidth / 7, matrixHeigh / 7, null);//绘制
        //g2.drawImage(logo, matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, null);//绘制
        g2.drawImage(logo, matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, null);//绘制
        BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(stroke);// 设置笔画对象
        //指定弧度的圆角矩形
        //RoundRectangle2D.Float round = new RoundRectangle2D.Float(matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, 20, 20);
        g2.setColor(Color.white);
        //g2.draw(round);// 绘制圆弧矩形
        //设置logo 有一道灰色边框
        //BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        //g2.setStroke(stroke2);// 设置笔画对象
        //RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(matrixWidth / 5 * 2 + 2, matrixHeigh / 5 * 2 + 2, matrixWidth / 5 - 4, matrixHeigh / 5 - 4, 20, 20);
        //g2.setColor(new Color(128, 128, 128));
        //g2.draw(round2);// 绘制圆弧矩形
        g2.dispose();
        matrixImage.flush();
        return matrixImage;
    }

    /**
     * 去白边
     * @param matrix
     * @return
     */
    private static BitMatrix deleteWhite(BitMatrix matrix) {
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (matrix.get(i + rec[0], j + rec[1]))
                    resMatrix.set(i, j);
            }
        }
        return resMatrix;

    }
    /**
     * 生成二维码图片不带Logo.
     *
     * @param content 二维码内容.
     * @return BufferedImage
     * @throws IOException io异常
     */
    public  BufferedImage QREncodes(String content) throws IOException {
        int width = 500; // 图像宽度
        int height = 500; // 图像高度
        Map<EncodeHintType, Object> hints = new HashMap();
        //内容编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //设置二维码边的空度，非负数
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = null;
        BufferedImage bufferedImage = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
            //去白边
            BitMatrix bitMatrix1 = deleteWhite(bitMatrix);
            //原始 不带Logo二维码
            bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix1, matrixToImageConfig);
        } catch (WriterException e) {
            e.printStackTrace();
        }

//        无logo
        return bufferedImage;
    }

}
