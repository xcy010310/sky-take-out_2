package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: ShoppingCartMapper
 * Package: com.sky.mapper
 * Description: This is a program for testing.
 *
 * @Author Ben
 * @Create 2024/12/31 23:14
 * @Version 1.0
 */
@Mapper
public interface ShoppingCartMapper {

    /**
     * 条件查询
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 更新商品数量
     * @param shoppingCart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart shoppingCart);

    /**
     * 插入购物车数据
     * @param shoppingCart
     */
    @Insert("insert into shopping_cart (name, image, user_id, dish_id, setmeal_id, " +
            "dish_flavor, amount, create_time, number) " +
            "VALUES (#{name}, #{image}, #{userId}, #{dishId}, #{setmealId}," +
            "#{dishFlavor}, #{amount}, #{createTime}, #{number})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 根据用户id删除购物车数据
     * @param userId
     */
    @Delete("delete from shopping_cart where user_id = #{userId}")
    void deleteByUserId(Long userId);

    /**
     * 根据菜品id删除购物车中的菜品数据
     * @param userId
     * @param dishFlavor
     * @param dishId
     */
    @Delete("delete from shopping_cart where user_id = #{userId} and dish_flavor = #{dishFlavor} and dish_id = #{dishId}")
    void deleteByDishId(Long userId, String dishFlavor, Long dishId);

    /**
     * 批量插入购物车数据
     * @param shoppingCartList
     */
    void insertBatch(List<ShoppingCart> shoppingCartList);
}
