package com.itas.itasbackend.core;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类级别注解：用于标记一个实体类，表示其字段在构建查询条件时应自动应用默认查询策略。
 * <p>
 * 配合自定义查询构造器使用时，如果某个字段没有显式使用 {@link QueryCondition} 注解，
 * 则会应用该注解中指定的默认查询策略（如 EQ）。
 * </p>
 *
 * 示例用法：
 * <pre>
 * {@code
 * @QueryAutoCondition(defaultStrategy = QueryStrategy.EQ)
 * public class ISSysUser {
 *     private String userName;
 *     private String status;
 *     // 未标注 @QueryCondition 的字段也会使用 EQ 查询
 * }
 * }
 * </pre>
 *
 * 优先级说明：
 * - 若字段有 {@link QueryCondition} 注解，则以字段注解为准；
 * - 若字段无注解，则应用此类注解指定的默认策略；
 * - 若类和字段都无注解，则该字段不会参与构造查询条件。
 *
 * @author anfioo
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryAutoCondition {

    /**
     * 指定默认的查询策略，当字段上没有单独声明 {@link QueryCondition} 时生效。
     * 默认为 EQ（等值查询）。
     *
     * @return 默认查询策略
     */
    QueryStrategy defaultStrategy() default QueryStrategy.EQ;
}
