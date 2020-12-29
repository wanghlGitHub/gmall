package com.atguigu.gmall.auth.feign;

import com.atguigu.common.utils.R;
import com.atguigu.gmall.auth.vo.SocialUser;
import com.atguigu.gmall.auth.vo.UserLoginVo;
import com.atguigu.gmall.auth.vo.UserRegisterVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: gmall
 * @description: 会员接口
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/28 10:14 上午
 * @Version: 1.0
 */
@FeignClient("guli-member")
public interface MemberFeignService {

	/**
	 * 会员注册接口
	 *
	 * @param vo
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/28 10:24 上午
	 * @return: com.atguigu.common.utils.R
	 */
	@PostMapping(value = "/member/member/register")
	R register(@RequestBody UserRegisterVo vo);


	@PostMapping(value = "/member/member/login")
	R login(@RequestBody UserLoginVo vo);

	@PostMapping(value = "/member/member/oauth2/login")
	R oauthLogin(@RequestBody SocialUser socialUser) throws Exception;

	@PostMapping(value = "/member/member/weixin/login")
	R weixinLogin(@RequestParam("accessTokenInfo") String accessTokenInfo);
}
