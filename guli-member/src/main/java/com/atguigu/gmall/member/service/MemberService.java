package com.atguigu.gmall.member.service;

import com.atguigu.gmall.member.exception.PhoneException;
import com.atguigu.gmall.member.exception.UsernameException;
import com.atguigu.gmall.member.vo.MemberUserLoginVo;
import com.atguigu.gmall.member.vo.MemberUserRegisterVo;
import com.atguigu.gmall.member.vo.SocialUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:29:51
 */
public interface MemberService extends IService<MemberEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void register(MemberUserRegisterVo vo);

	void checkPhoneUnique(String phone) throws PhoneException;

	void checkUserNameUnique(String userName) throws UsernameException;

	/**
	 * 正常系统账号登录
	 *
	 * @param vo
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/28 5:06 下午
	 * @return: com.atguigu.gmall.member.entity.MemberEntity
	 */
	MemberEntity login(MemberUserLoginVo vo);

	/**
	 * 社交登录
	 *
	 * @param socialUser
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/28 5:06 下午
	 * @return: com.atguigu.gmall.member.entity.MemberEntity
	 */
	MemberEntity login(SocialUser socialUser) throws Exception;
}

