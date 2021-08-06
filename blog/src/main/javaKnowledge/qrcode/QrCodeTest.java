package qrcode;

/**
 * @author Young
 * 生成二维码类
 */
public class QrCodeTest {
    /**
     * QRCodeUtil.encode(text, imgPath, destPath, true);
     * text：编码到二维码中的内容，这里是“我是小铭”
     * imgPath：要嵌入二维码的图片路径，如果不写或者为null则生成一个没有嵌入图片的纯净的二维码
     * destPath：生成的二维码的存放路径
     * true：表示将嵌入二维码的图片进行压缩，如果为“false”则表示不压缩。
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
        String text = "我是小铭";
        // 嵌入二维码的图片路径
        String imgPath = "E:/qrCode/1.jpg";
        // 生成的二维码的路径及名称
        String destPath = "E:/qrCode/QRCode.jpg";
        //生成二维码
        QrCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = QrCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);
    }
}
