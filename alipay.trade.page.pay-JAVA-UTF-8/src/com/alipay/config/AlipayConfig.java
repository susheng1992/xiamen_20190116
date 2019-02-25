package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091600526896";	
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC7svIyvHldqpICnru8TxqZC+ldVEY2wHlZ0v48eFshsi11fa0fWPopDnjnJkbxk04WfhLRmQ9kV3xQ4AK8c/V+Fc129+QfZE/+Ixti8SmUA2eyPaAT/5uQUHhsTdKGKIYLk3pHNFt7Yqt46teWBTfpggAL9/FO6QAj6cVywh0EgYRrTD/wpNdT0VbsSEiV7kYbMKozPedhRFeIyRFa9r/ciQ5O3wvr0/Cou4LzkRw7wJrT82Tg4f105CEcpVi7enmy6Z/FndJjxs879elgNDDFwL5EsfGpaYshCVD5nWJBVHvh3lVcNwqWkowDiJGsHO56EQjDwOW/W0xaYtJYOWh1AgMBAAECggEAUbXa/f9SjlYc7gsQCzAckhe/ZaO0VU2BBnt1tflnIsogRA+L+COR86GbPHVLWQsZaW1E3/3T14jGU6bRShzo+BSht3K+2nOe5zF9UJtP0GGTGOL+9vXFURPW+L8AMOsfP5baGnlOge44W5FQfLyU1JCFWLB9Wi7QotG35PdgDn9cjRrzLC+GhX2TkoM52YfgsVnA303UX38wZV1VOQlt+bEczxkBt982lQkXSp0pX618Me67JE8nD8UehpHPpDOFr+V8Xky8gE5VYw+UZjNDIWcl+YELTcy3AyfzIFQ9ocs7rVmTY5ThEq+huMqOYjWyMEUjKComukb9sbJ5NKblgQKBgQDlKeQbk6wvcXXEQfRWjHMSbiyw/HbzibSmFrvr2Pc6SeuRcvp9RJQbOcWEGyIEKXYRbcrLFM4Y+c977wp4MSo1/s2M4TxyQwqBLVvpuTUhTdhaCyEtOzMs4fhaXULE6lM0+SzEqjV7PXvbc8HRFJnLrfKmtP/wBiiiomPJh8GfhQKBgQDRrfwWKF2Bj3I6rNnkLQjm0eiV+x5H3xERJYzF+lICs0RmMPVmty1TygWfoGJsm411ZPvaCNu1iy017v0BClkTtAJomq8g4HIHceNigEEAB2I7jabDCoWleatZtMi/6+nO70AoXV7Inh7jKmWU/nxd4D4CUmYE9KxtTmZ8MnhgMQKBgHSclYPm6FaYEMpWmYQ1IhU91SYWwlz5NODTbrr8BAo4NVQlQwvditQz2Kt5txyREJCb4vbmVl3lOMyi/hvdQNKLH4PR1ZV7Qewr7bqIUV3qI+7l/PLsTgVH073/+QsFBmRNa5eD2YUl61HnnLfNGNnJYVGthxNXvvPLWKXjnAaVAoGBAK3DWIBoTS08Wjaj3iJI6/KVDAGWzL5U7sjd7G55BpO0Sj/B3OyVatvgNI7XlBlbQ3yBBnHnG2S0hPAIMOU21SEN8V0Mq4s8VWM0D3MmxDco51BhEEzcIGtEjCrYNfFOqUFTZkDNN+pbl088aFh0GU6Wseysqlz7AxXGfgn4rWdRAoGAE4gl/KSTLQ3xx8wrm7KuVKUR32a6/TuhXFnwLywXtdEOr7lhpLtWGVZiAe47+ibZJyncOpG9asK0zGHjywFV+eYuATmR41JM9yny1/3580nkX5+L4AiWBEWAgTRncP/A1wGfamvWDzeXHg7nwZJoMTiYKaBJGoezzLhqfjj4sWM=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAu7LyMrx5XaqSAp67vE8amQvpXVRGNsB5WdL+PHhbIbItdX2tH1j6KQ545yZG8ZNOFn4S0ZkPZFd8UOACvHP1fhXNdvfkH2RP/iMbYvEplANnsj2gE/+bkFB4bE3ShiiGC5N6RzRbe2KreOrXlgU36YIAC/fxTukAI+nFcsIdBIGEa0w/8KTXU9FW7EhIle5GGzCqMz3nYURXiMkRWva/3IkOTt8L69PwqLuC85EcO8Ca0/Nk4OH9dOQhHKVYu3p5sumfxZ3SY8bPO/XpYDQwxcC+RLHxqWmLIQlQ+Z1iQVR74d5VXDcKlpKMA4iRrBzuehEIw8Dlv1tMWmLSWDlodQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "E:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

