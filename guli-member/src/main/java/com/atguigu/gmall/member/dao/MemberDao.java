package com.atguigu.gmall.member.dao;

import com.atguigu.gmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:29:51
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
