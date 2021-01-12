package com.atguigu.gmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.member.entity.MemberReceiveAddressEntity;

import java.util.List;
import java.util.Map;

/**
 * 会员收货地址
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:29:51
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 根据会员 ID 查询会员的收获地址
	 *
	 * @param memberId
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/6 9:36 上午
	 * @return: java.util.List<com.atguigu.gmall.member.entity.MemberReceiveAddressEntity>
	 */
	List<MemberReceiveAddressEntity> getAddress(Long memberId);
}

