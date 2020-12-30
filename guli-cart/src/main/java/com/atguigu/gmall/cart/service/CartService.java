package com.atguigu.gmall.cart.service;

import com.atguigu.gmall.cart.vo.CartItemVo;
import com.atguigu.gmall.cart.vo.CartVo;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/30 10:28 上午
 */
public interface CartService {

	/**
	 * 将商品添加至购物车
	 *
	 * @param skuId
	 * @param num
	 * @return
	 */
	CartItemVo addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;

	/**
	 * 获取购物车某个购物项
	 *
	 * @param skuId
	 * @return
	 */
	CartItemVo getCartItem(Long skuId);

	/**
	 * 获取购物车里面的信息
	 *
	 * @return
	 */
	CartVo getCart() throws ExecutionException, InterruptedException;

	/**
	 * 清空购物车的数据
	 *
	 * @param cartKey
	 */
	void clearCartInfo(String cartKey);

	/**
	 * 勾选购物项
	 *
	 * @param skuId
	 * @param check
	 */
	void checkItem(Long skuId, Integer check);

	/**
	 * 改变商品数量
	 *
	 * @param skuId
	 * @param num
	 */
	void changeItemCount(Long skuId, Integer num);


	/**
	 * 删除购物项
	 *
	 * @param skuId
	 */
	void deleteIdCartInfo(Integer skuId);

	List<CartItemVo> getUserCartItems();
}
