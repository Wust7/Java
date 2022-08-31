package com.wust.mybatis.mapper;


import com.wust.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * mybatis面向接口编程的两个一致：
 *  1、映射文件的namespace要和mapper接口的全类名保持一致
 *
 */


//第二步：对应实体类的mapper
public interface UserMapper {
    /**
     * Mybatis各种查询功能：
     *  1.若查询出的数据只有一条，可以通过实体类对象或集合接收
     *  2.若查询结果有多条，则不能通过实体类对象接收，只能通过集合接收
     */


    /**
     * 添加用户信息（添加功能带自增的主键）
     */
    void insertUserById(User user);

    /**
     * 查询指定表中的数据
     */
    List<User>  getUserByTableName(@Param("tableName") String tableName);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids")String ids);

    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username")String username);

    /**
     * 查询所有用户信息（List<Map>）
     */
//    List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")//以id为键，由于Map集合键唯一，所以id需要唯一,剩下的属性作为值
    Map<String,Object> getAllUserToMap();

    /**
     * 根据id查询用户信息为一个map集合
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询总记录数
     */
    Integer getCount();

    /**
     * 验证登录（使用@Param）
     */
    User checkLoginByParam(@Param(value = "username") String username,@Param("password")String password);

    /**
     * 插入用户
     * @return
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除
     */
    int deleteUser();

    /**
     * 查询
     */
    User getUserById();

    /**
     * 查询所有用户信息
     */
    List<User> getUserAllUser();

    /**
     * 根据用户名查询信息
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录（map）
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 插入用户（User）
     */
    Integer insertByUser(User user);
}
