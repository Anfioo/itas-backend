# CREATE DATABASE `mmjd-database`;
USE `itas_database`;

-- 1. 系统用户表
CREATE TABLE sys_user
(
    user_id      BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    user_name    VARCHAR(30)  NOT NULL UNIQUE COMMENT '登录账号（唯一）',
    nick_name    VARCHAR(30)  NOT NULL COMMENT '用户昵称',
    password     VARCHAR(255) NOT NULL COMMENT '密码',

    email        VARCHAR(50)  NULL UNIQUE COMMENT '用户邮箱',
    phone_number VARCHAR(11)  NULL UNIQUE COMMENT '手机号码',
    avatar       VARCHAR(255) NULL COMMENT '头像URL',
    sex          CHAR(1)      NOT NULL DEFAULT '2' COMMENT '性别（0男,1女,2未知）',
    status       CHAR(1)      NOT NULL DEFAULT '0' COMMENT '账号状态（0正常,1停用）',
    del_flag     CHAR(1)      NOT NULL DEFAULT '0' COMMENT '删除标志（0存在,1已删）',
    create_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT ='系统用户表';


-- 2. 系统角色表
CREATE TABLE sys_role
(
    role_key  VARCHAR(20)  NOT NULL PRIMARY KEY COMMENT '角色标识',
    role_name VARCHAR(50)  NOT NULL COMMENT '角色名称',
    remark    VARCHAR(200) NULL COMMENT '角色备注'
) COMMENT ='系统角色表';


-- 4. 用户–角色映射表
CREATE TABLE sys_user_role
(
    user_id    BIGINT      NOT NULL COMMENT '用户ID，关联 sys_user.user_id',
    role_key   VARCHAR(20) NOT NULL COMMENT '角色标识，关联 msys_role.role_key',
    grant_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '授权时间',
    PRIMARY KEY (user_id, role_key),
    CONSTRAINT fk_usr_role_user FOREIGN KEY (user_id) REFERENCES sys_user (user_id),
    CONSTRAINT fk_usr_role_role FOREIGN KEY (role_key) REFERENCES sys_role (role_key)
) COMMENT ='用户与角色映射表';

