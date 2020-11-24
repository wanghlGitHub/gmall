package com.atguigu.gmall.product.exception;

import com.atguigu.common.exception.BizCodeEnume;
import com.atguigu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局处理异常类，集中处理所有异常
 *
 * @author heliang.wang
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
public class GuliExceptionControllerAdvice {


	/**
	 * 处理校验错误异常
	 *
	 * @param e
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/24 10:58 上午
	 * @return: com.atguigu.common.utils.R
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public R handleVaildException(MethodArgumentNotValidException e) {
		log.error("数据校验出现问题{}，异常类型：{}", e.getMessage(), e.getClass());
		BindingResult bindingResult = e.getBindingResult();

		Map<String, String> errorMap = new HashMap<>();
		bindingResult.getFieldErrors().forEach((fieldError) -> {
			errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		});
		return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(), BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data", errorMap);
	}

	/**
	 * 处理其他异常
	 *
	 * @param throwable
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/24 10:59 上午
	 * @return: com.atguigu.common.utils.R
	 */
	@ExceptionHandler(value = Throwable.class)
	public R handleException(Throwable throwable) {

		log.error("错误：", throwable);
		return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(), BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
	}


}
