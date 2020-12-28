package com.atguigu.gmall.member.controller;

import com.atguigu.common.exception.BizCodeEnum;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gmall.member.entity.MemberEntity;
import com.atguigu.gmall.member.exception.PhoneException;
import com.atguigu.gmall.member.exception.UsernameException;
import com.atguigu.gmall.member.feign.CouponFeign;
import com.atguigu.gmall.member.service.MemberService;
import com.atguigu.gmall.member.vo.MemberUserLoginVo;
import com.atguigu.gmall.member.vo.MemberUserRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:29:51
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	CouponFeign couponFeign;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = memberService.queryPage(params);

		return R.ok().put("page", page);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id) {
		MemberEntity member = memberService.getById(id);
		R info = couponFeign.info(id);
		return R.ok().put("member", member).put("coupon", info.get("coupon"));
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody MemberEntity member) {
		memberService.save(member);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody MemberEntity member) {
		memberService.updateById(member);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids) {
		memberService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}

	/**
	 * 会员注册
	 *
	 * @param vo
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/28 10:25 上午
	 * @return: com.atguigu.common.utils.R
	 */
	@PostMapping(value = "/register")
	public R register(@RequestBody MemberUserRegisterVo vo) {

		try {
			memberService.register(vo);
		} catch (PhoneException e) {
			return R.error(BizCodeEnum.PHONE_EXIST_EXCEPTION.getCode(), BizCodeEnum.PHONE_EXIST_EXCEPTION.getMsg());
		} catch (UsernameException e) {
			return R.error(BizCodeEnum.USER_EXIST_EXCEPTION.getCode(), BizCodeEnum.USER_EXIST_EXCEPTION.getMsg());
		}

		return R.ok();
	}

	@PostMapping(value = "/login")
	public R login(@RequestBody MemberUserLoginVo vo) {

		MemberEntity memberEntity = memberService.login(vo);

		if (memberEntity != null) {
			return R.ok().setData(memberEntity);
		} else {
			return R.error(BizCodeEnum.LOGINACCT_PASSWORD_EXCEPTION.getCode(),BizCodeEnum.LOGINACCT_PASSWORD_EXCEPTION.getMsg());
		}
	}

}
