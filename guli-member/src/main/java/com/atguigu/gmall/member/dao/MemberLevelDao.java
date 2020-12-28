package com.atguigu.gmall.member.dao;

import com.atguigu.gmall.member.entity.MemberLevelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员等级
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:29:51
 */
@Mapper
public interface MemberLevelDao extends BaseMapper<MemberLevelEntity> {

	/**
	 * 获取默认的会员等级
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/28 10:31 上午
	 * @return: com.atguigu.gmall.member.entity.MemberLevelEntity
	 */
	MemberLevelEntity getDefaultLevel();
}
