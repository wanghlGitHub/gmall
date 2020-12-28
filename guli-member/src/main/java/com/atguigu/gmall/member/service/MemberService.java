package com.atguigu.gmall.member.service;

import com.atguigu.gmall.member.exception.PhoneException;
import com.atguigu.gmall.member.exception.UsernameException;
import com.atguigu.gmall.member.vo.MemberUserLoginVo;
import com.atguigu.gmall.member.vo.MemberUserRegisterVo;
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

	MemberEntity login(MemberUserLoginVo vo);
}

