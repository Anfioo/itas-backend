package com.itas.itasbackend.query;



import java.lang.annotation.*;

/**
 * 自定义注解：用于标记实体类字段的查询策略。
 * <p>
 * 通常与动态构建查询条件的工具类配合使用，如根据该注解自动构造 MyBatis-Plus 的 QueryWrapper 条件。
 * </p>
 *
 * 示例用法：
 * <pre>
 * {@code
 * @QueryCondition(strategy = QueryStrategy.LIKE)
 * private String userName;
 * }
 * </pre>
 *
 * 默认策略为 {@link QueryStrategy#EQ}，即等值查询。
 *
 * @author anfioo
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryCondition {

    /**
     * 指定字段的查询策略，如等值（EQ）、模糊（LIKE）、大于（GT）等。
     * 默认为 EQ。
     *
     * @return 查询策略
     */
    QueryStrategy strategy() default QueryStrategy.EQ;
}
