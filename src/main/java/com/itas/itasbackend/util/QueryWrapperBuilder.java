package com.itas.itasbackend.util;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itas.itasbackend.query.QueryAutoCondition;
import com.itas.itasbackend.query.QueryCondition;
import com.itas.itasbackend.query.QueryStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * 查询构造器工具类：用于根据实体对象上的注解动态构建 MyBatis-Plus 的 {@link QueryWrapper} 查询条件。
 * <p>
 * 支持两种注解配置方式：
 * <ul>
 *   <li>{@link QueryCondition}：用于标注字段的查询策略（如 EQ、LIKE 等）；</li>
 *   <li>{@link QueryAutoCondition}：用于标注类级默认策略，使未标注字段也能应用默认查询规则。</li>
 * </ul>
 * <p>
 * 示例用法：
 * <pre>{@code
 * @QueryAutoCondition
 * public class ISSysUser {
 *     @QueryCondition(strategy = QueryStrategy.LIKE)
 *     private String userName;
 *     private String status; // 默认使用 EQ
 * }
 * QueryWrapper<ISSysUser> wrapper = QueryWrapperBuilder.buildQueryWrapper(query);
 * }</pre>
 * <p>
 * 注意事项：
 * <ul>
 *   <li>字段值为 null 时将被忽略，不参与查询条件构建。</li>
 *   <li>支持继承父类的字段。</li>
 * </ul>
 *
 * @author anfioo
 */
public class QueryWrapperBuilder {

    private static final Logger log = LoggerFactory.getLogger(QueryWrapperBuilder.class);

    /**
     * 构建 QueryWrapper 实例，根据实体类中的注解定义自动添加查询条件。
     *
     * @param queryObj 查询对象，字段上的注解用于指示查询策略
     * @param <T>      实体类型
     * @return 构造好的 QueryWrapper 实例
     */
    public static <T> QueryWrapper<T> buildQueryWrapper(T queryObj) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();

        Class<?> clazz = queryObj.getClass();
        // 获取类级注解，判断是否启用默认查询策略,会向上查找一层父类 见方法 getAutoConditionAnnotation
        QueryAutoCondition enableAutoQuery = getAutoConditionAnnotation(clazz);
        QueryStrategy defaultStrategy = (enableAutoQuery != null) ? enableAutoQuery.defaultStrategy() : null;


        // 遍历类层级结构，处理所有字段（包括继承的）
        while (clazz != null && clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(queryObj);
                    if (value == null) continue; // 忽略 null 字段

                    // 1. 优先使用字段注解
                    QueryCondition fieldAnno = field.getAnnotation(QueryCondition.class);
                    QueryStrategy strategy;

                    if (fieldAnno != null) {
                        strategy = fieldAnno.strategy();
                    } else if (defaultStrategy != null) {
                        // 2. 使用类级默认注解
                        strategy = defaultStrategy;
                    } else {
                        continue; // 无注解且未启用类级策略时跳过
                    }

                    String column = humpToUnderline(field.getName());

                    // 添加查询条件
                    switch (strategy) {
                        case EQ -> wrapper.eq(column, value);
                        case LIKE -> wrapper.like(column, value);
                        case GT -> wrapper.gt(column, value);
                        case GE -> wrapper.ge(column, value);
                        case LT -> wrapper.lt(column, value);
                        case LE -> wrapper.le(column, value);
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException("字段读取失败: " + field.getName(), e);
                }
            }
            clazz = clazz.getSuperclass(); // 继续处理父类字段
        }

        return wrapper;
    }

    /**
     * 将驼峰命名转换为下划线命名（例如：createTime -> create_time）。
     *
     * @param str 待转换的字符串
     * @return 下划线命名字符串
     */
    private static String humpToUnderline(String str) {
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }


    /**
     * 查找当前类和其父类是否有QueryAutoCondition注解
     *
     * @param clazz 查找的类
     * @return 查找结果
     */
    private static QueryAutoCondition getAutoConditionAnnotation(Class<?> clazz) {
        // 检查当前类
        QueryAutoCondition annotation = clazz.getAnnotation(QueryAutoCondition.class);
        if (annotation != null) return annotation;

        // 检查父类
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null && superClass != Object.class) {
            annotation = superClass.getAnnotation(QueryAutoCondition.class);
            if (annotation != null) return annotation;
        }

        // 当前类和父类都没有注解，发出警告日志
        log.warn("⚠️ [{}] 及其父类未检测到 @QueryAutoCondition 注解，未启用默认查询策略。",
                clazz.getSimpleName());

        return null;
    }

}
