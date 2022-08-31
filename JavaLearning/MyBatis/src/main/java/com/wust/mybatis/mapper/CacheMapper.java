package com.wust.mybatis.mapper;

import com.wust.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    /**
     * 缓存只对查询功能有效
     *
     * 1.一级缓存默认开启：一级缓存默认范围是SqlSession，对于同一个SqlSession，访问相同的东西会首先去缓存中找看是否有
     * 同时增删改会将一级缓存给清除掉，同时手动清空（sqlSession.clearCache()）只对一级缓存有效，不会清空二级缓存
     *
     * 2.二级缓存开启条件：
     *      a.在核心配置文件中设置全局配置属性cacheEnabled="true"，默认为true
     *      b.映射文件中设置标签<cache/>
     *      c.二级缓存必须在SqlSession关闭或提交之后有效
     *      d.查询的数据所转换的实体类类型必须实现序列化的接口
     * 注：执行任意增删改会清空一级二级缓存
     *
     * Mybatis缓存查询顺序：
     *      1.先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以拿来直接使用
     *      2.如果二级缓存没有命中，再查询一级缓存
     *      3.如果一级缓存也没有命中，则查询数据库
     *      4.SqlSession关闭之后，一级缓存中的数据会写入二级缓存
     */


    Emp getEmpByEid(@Param("eid")Integer eid);

    void insertEmp(Emp emp);
}
