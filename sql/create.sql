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
    role_key    VARCHAR(20)  NOT NULL PRIMARY KEY COMMENT '角色标识',
    role_name   VARCHAR(50)  NOT NULL COMMENT '角色名称',
    remark      VARCHAR(200) NULL COMMENT '角色备注',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT ='系统角色表';


-- 4. 用户–角色映射表
CREATE TABLE sys_user_role
(
    user_id     BIGINT      NOT NULL COMMENT '用户ID，关联 sys_user.user_id',
    role_key    VARCHAR(20) NOT NULL COMMENT '角色标识，关联 msys_role.role_key',
    grant_time  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '授权时间',
    create_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (user_id, role_key),
    CONSTRAINT fk_usr_role_user FOREIGN KEY (user_id) REFERENCES sys_user (user_id),
    CONSTRAINT fk_usr_role_role FOREIGN KEY (role_key) REFERENCES sys_role (role_key)
) COMMENT ='用户与角色映射表';


-- 课程表（courses）
CREATE TABLE courses
(
    course_id   BIGINT PRIMARY KEY COMMENT '课程ID',
    course_name VARCHAR(100) NOT NULL COMMENT '课程名称',
    teacher_id  BIGINT       NOT NULL COMMENT '教师ID',
    weekday     ENUM ('周一', '周二', '周三', '周四', '周五', '周六', '周日') COMMENT '上课星期',
    start_time  TIME COMMENT '上课开始时间',
    end_time    TIME COMMENT '上课结束时间',
    location    VARCHAR(50) COMMENT '上课地点',
    description TEXT COMMENT '课程描述',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);


-- 作业表（assignments）
CREATE TABLE assignments
(
    assignment_id BIGINT PRIMARY KEY COMMENT '作业ID',
    course_id     BIGINT       NOT NULL COMMENT '所属课程ID',
    title         VARCHAR(100) NOT NULL COMMENT '作业标题',
    description   TEXT COMMENT '作业描述',
    due_date      DATETIME COMMENT '截止时间',
    max_score     INT COMMENT '最高得分',
    create_time   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (course_id) REFERENCES courses (course_id)
);

-- 作业提交记录表（submission_records）
CREATE TABLE submission_records
(
    submission_id BIGINT PRIMARY KEY COMMENT '提交记录ID',
    assignment_id BIGINT   NOT NULL COMMENT '作业ID',
    submitted_at  DATETIME COMMENT '提交时间',
    status        ENUM ('已提交', '未提交') COMMENT '提交状态',
    score         INT COMMENT '得分',
    file_url      VARCHAR(255) COMMENT '文件链接',
    create_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (assignment_id) REFERENCES assignments (assignment_id)
);

-- 成绩表（grades）
CREATE TABLE grades
(
    grade_id      BIGINT PRIMARY KEY COMMENT '成绩ID',
    course_id     BIGINT   NOT NULL COMMENT '课程ID',
    current_score INT COMMENT '当前成绩',
    max_total     INT COMMENT '总分',
    distribution  JSON COMMENT '成绩分布（JSON格式）',
    create_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (course_id) REFERENCES courses (course_id)
);

-- 资源表（resources）
CREATE TABLE resources
(
    resource_id   BIGINT PRIMARY KEY COMMENT '资源ID',
    course_id     BIGINT   NOT NULL COMMENT '课程ID',
    parent_id     BIGINT COMMENT '父资源ID（用于树形结构）',
    resource_type ENUM ('章节', '题目', '文件') COMMENT '资源类型',
    title         VARCHAR(100) COMMENT '资源标题',
    content       TEXT COMMENT '资源内容',
    create_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (course_id) REFERENCES courses (course_id),
    FOREIGN KEY (parent_id) REFERENCES resources (resource_id)
);

-- 班级表（classes）
CREATE TABLE classes
(
    class_id    BIGINT PRIMARY KEY COMMENT '班级ID',
    class_name  VARCHAR(50) COMMENT '班级名称',
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 教室表（classrooms）
CREATE TABLE classrooms
(
    classroom_id BIGINT PRIMARY KEY COMMENT '教室ID',
    building     VARCHAR(20) COMMENT '楼栋',
    room_number  VARCHAR(10) COMMENT '教室号',
    capacity     INT COMMENT '容量',
    status       ENUM ('空闲', '占用') COMMENT '教室状态',
    create_time  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 消息表（messages）
CREATE TABLE messages
(
    message_id   BIGINT PRIMARY KEY COMMENT '消息ID',
    course_id    BIGINT   NOT NULL COMMENT '课程ID',
    message_date DATETIME COMMENT '发布时间',
    content      TEXT COMMENT '消息内容',
    create_time  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (course_id) REFERENCES courses (course_id)
);

-- 班级成员表（class_members）
CREATE TABLE class_members
(
    class_id    BIGINT   NOT NULL COMMENT '班级ID',
    user_id     BIGINT   NOT NULL COMMENT '用户ID',
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (class_id, user_id),
    FOREIGN KEY (class_id) REFERENCES classes (class_id)
);



# 功能：
#
# 1主页展示课程表（周几上某节课那种）
# 2.作业功能（通过选定某一个课程查看作业状态、作业节点、作业分数等）
# 3.成绩查询（通过选定某一个课程查看该课程的当前成绩、满分、成绩分布等）
# 4.我的资源（通过选定某一个课程查看该课程中的资源、章节、题目等）
# 5.我的班级（用户查看班级里的所有同学）
# 6.自习（查看教室资源，通过楼栋号如8栋/6栋查询当前教室是否为空教室，以提供自习）
# 7.查看消息（通过查询日期/课程，列出消息列表）
#
# 1*.查看笔记
# 2*.AI插件
