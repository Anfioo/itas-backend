package com.itas.itasbackend.core;

/**
 * 查询策略枚举类，用于指定构建查询条件时的操作类型。
 * <p>
 * 通常与 {@link com.anfioo.common.query.QueryCondition} 或 {@link com.anfioo.common.query.QueryAutoCondition}
 * 注解结合使用，标识某个字段在自动构建查询时应使用的条件策略。
 * </p>
 *
 * 支持的策略包括：
 * <ul>
 *   <li>{@code EQ} - 等于（=）</li>
 *   <li>{@code LIKE} - 模糊匹配（LIKE '%xxx%'）</li>
 *   <li>{@code GT} - 大于（>）</li>
 *   <li>{@code GE} - 大于等于（>=）</li>
 *   <li>{@code LT} - 小于（<）</li>
 *   <li>{@code LE} - 小于等于（<=）</li>
 * </ul>
 *
 * 示例用途：
 * <pre>
 * {@code
 * @QueryCondition(strategy = QueryStrategy.LIKE)
 * private String userName;
 * }
 * </pre>
 *
 * @author anfioo
 */
public enum QueryStrategy {
    /** 等于 */
    EQ,
    /** 模糊匹配（like） */
    LIKE,
    /** 大于（greater than） */
    GT,
    /** 大于等于（greater than or equal） */
    GE,
    /** 小于（less than） */
    LT,
    /** 小于等于（less than or equal） */
    LE
}
