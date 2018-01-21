package com.github.yglll.funlive.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/21   13:31
 **/
public class MD5Util {

    public static String getToMd5Low32(String str) {
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] bytes = md5.digest();
            for (byte b : bytes) {
                int digital = b&0xff;
                if (digital < 16)
                    builder.append(0);
                builder.append(Integer.toHexString(digital));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return builder.toString().toLowerCase();
    }
//
//    /**
//     *   斗鱼加密算法
//     * @param str
//     * @return
//     */
//    /**
//     * 执行md5.js文件中的MD5函数
//     *
//     * @param code
//     *            原始字符串
//     * @return 进行加密操作后的字符串
//     * */
//    public static String md5Special(String code) throws Exception {
//        ScriptEngineManager manager = new ScriptEngineManager();
//        String newCode = "";
//        InputStreamReader inputStreamReader = null;
//        ScriptEngine engine = manager.getEngineByName("javascript");
//        try {
//            URL url = new URL("http://211.***.***.193/*****/js/md5.js");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestProperty("Content-Type", "text/html");
//            inputStreamReader = getInputContent("GET", null, conn);
//        } catch (ConnectException ce) {
//            ce.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        engine.eval(inputStreamReader);
//        if (engine instanceof Invocable) {
//            Invocable invoke = (Invocable) engine;
//            newCode = (String) invoke.invokeFunction("md5", code);// 调用md5方法，并传入1个参数
//        }
//        inputStreamReader.close();
//        return newCode;
//
//    }
//
//    /**
//     *
//     *    通过流获取返回内容
//     */
//    private static InputStreamReader getInputContent(String requestMethod,
//                                                     String outputStr, HttpURLConnection conn) throws ProtocolException,
//            IOException, UnsupportedEncodingException { // （封装的http请求方法） 需要调用的方法
//        conn.setDoOutput(true);
//        conn.setDoInput(true);
//        conn.setUseCaches(false);
//        // 设置请求方式（GET/POST）
//        conn.setRequestMethod(requestMethod);
//        // 当outputStr不为null时向输出流写数据
//        if (null != outputStr) {
//            OutputStream outputStream = conn.getOutputStream();
//            // 注意编码格式
//            outputStream.write(outputStr.getBytes("UTF-8"));
//            outputStream.close();
//        }
//        // 从输入流读取返回内容
//        InputStream inputStream = conn.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(
//                inputStream, "UTF-8");
//        return inputStreamReader;
//    }

    /**
     * 获得字符串的md5值
     *
     * @param str 待加密的字符串
     * @return md5加密后的字符串
     */
    public static String getMD5String(String str) {
        byte[] bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            bytes = md5.digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return HexUtil.bytes2Hex(bytes);

    }



    /**
     * 获得字符串的md5大写值
     *
     * @param str 待加密的字符串
     * @return md5加密后的大写字符串
     */
    public static String getMD5UpperString(String str) {
        return getMD5String(str).toUpperCase();
    }

    /**
     * 获得文件的md5值
     *
     * @param file 文件对象
     * @return 文件的md5
     */
    public static String getFileMD5String(File file) {
        String ret = "";
        FileInputStream in = null;
        FileChannel ch = null;
        try {
            in = new FileInputStream(file);
            ch = in.getChannel();
            ByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
                    file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            ret = HexUtil.bytes2Hex(md5.digest());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ch != null) {
                try {
                    ch.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    /**
     * 获得文件md5值大写字符串
     *
     * @param file 文件对象
     * @return 文件md5大写字符串
     */
    public static String getFileMD5UpperString(File file) {
        return getFileMD5String(file).toUpperCase();
    }

    /**
     * 校验文件的md5值
     *
     * @param file 目标文件
     * @param md5  基准md5
     * @return 校验结果
     */
    public static boolean checkFileMD5(File file, String md5) {
        return getFileMD5String(file).equalsIgnoreCase(md5);
    }

    /**
     * 校验字符串的md5值
     *
     * @param str 目标字符串
     * @param md5 基准md5
     * @return 校验结果
     */
    public static boolean checkMD5(String str, String md5) {
        return getMD5String(str).equalsIgnoreCase(md5);
    }

    /**
     * 获得加盐md5，算法过程是原字符串md5后连接加盐字符串后再进行md5
     *
     * @param str  待加密的字符串
     * @param salt 盐
     * @return 加盐md5
     */
    public static String getMD5AndSalt(String str, String salt) {
        return getMD5String(getMD5String(str).concat(salt));
    }

}
