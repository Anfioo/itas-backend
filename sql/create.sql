-- 用户表 user
CREATE TABLE `user`
(
    `id`         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username`   VARCHAR(50)  NOT NULL,
    `password`   VARCHAR(255) NOT NULL,
    `role_id`    INT,
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 角色表 role
CREATE TABLE `role`
(
    `id`          INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`        VARCHAR(50) NOT NULL,
    `description` TEXT,
    `created_at`  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 课程表 course
CREATE TABLE `course`
(
    `id`          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`       VARCHAR(100) NOT NULL,
    `description` TEXT,
    `teacher_id`  INT,
    `created_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 章节表 chapter
CREATE TABLE `chapter`
(
    `id`             INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `course_id`      INT          NOT NULL,
    `chapter_number` INT          NOT NULL,
    `title`          VARCHAR(100) NOT NULL,
    `content`        TEXT,
    `created_at`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 学生表 student
CREATE TABLE `student`
(
    `id`         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`    INT          NOT NULL,
    `name`       VARCHAR(100) NOT NULL,
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 教师表 teacher
CREATE TABLE `teacher`
(
    `id`         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`    INT          NOT NULL,
    `name`       VARCHAR(100) NOT NULL,
    `department` VARCHAR(100),
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 作业表 homework
CREATE TABLE `homework`
(
    `id`          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`       VARCHAR(100) NOT NULL,
    `description` TEXT,
    `course_id`   INT          NOT NULL,
    `due_date`    DATETIME,
    `created_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 考试表 exam
CREATE TABLE `exam`
(
    `id`          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`       VARCHAR(100) NOT NULL,
    `description` TEXT,
    `course_id`   INT          NOT NULL,
    `exam_date`   DATETIME,
    `created_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 资源表 resource
CREATE TABLE `resource`
(
    `id`           INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `course_id`    INT          NOT NULL,
    `title`        VARCHAR(100) NOT NULL,
    `description`  TEXT,
    `resource_url` VARCHAR(255),
    `created_at`   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 成绩表 score
CREATE TABLE `score`
(
    `id`         INT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `student_id` INT      NOT NULL,
    `exam_id`    INT      NOT NULL,
    `score`      INT      NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
