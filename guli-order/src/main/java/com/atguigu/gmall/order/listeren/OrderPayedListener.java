package com.atguigu.gmall.order.listeren;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.atguigu.gmall.order.config.AlipayTemplate;
import com.atguigu.gmall.order.service.OrderService;
import com.atguigu.gmall.order.vo.PayAsyncVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: gmall
 * @description: 支付宝支付成功的回调接口
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/13 10:19 上午
 * @Version: 1.0
 */
@RestController
public class OrderPayedListener {

	@Autowired
	private OrderService orderService;

	@Autowired
	private AlipayTemplate alipayTemplate;

	/**
	 * 支付成功后的回调地址，自己配置的 alipay.notify_url <br/>
	 * 支付成功后，支付宝使用最大努力通知模式，保持两边的状态一致，一共会发 8 次请求，直到收到服务器响应的"success"后才会停止发送
	 *
	 * @param asyncVo
	 * @param request
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/13 10:20 上午
	 * @return: java.lang.String
	 */
	@PostMapping(value = "/payed/notify")
	public String handleAlipayed(PayAsyncVo asyncVo, HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException {
		// 只要收到支付宝的异步通知，返回 success 支付宝便不再通知
		// 获取支付宝POST过来反馈信息
		//TODO 需要验签
		Map<String, String> params = new HashMap<>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (String name : requestParams.keySet()) {
			String[] values = requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayTemplate.getAlipay_public_key(),
				alipayTemplate.getCharset(), alipayTemplate.getSign_type()); //调用SDK验证签名

		if (signVerified) {
			System.out.println("签名验证成功...");
			//去修改订单状态
			String result = orderService.handlePayResult(asyncVo);
			return result;
		} else {
			System.out.println("签名验证失败...");
			return "error";
		}
	}

	/**
	 * 微信支付回调接口
	 *
	 * @param notifyData
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/13 1:33 下午
	 * @return: java.lang.String
	 */
	@PostMapping(value = "/pay/notify")
	public String asyncNotify(@RequestBody String notifyData) {
		//异步通知结果
		return orderService.asyncNotify(notifyData);
	}
}
