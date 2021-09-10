# 用户表
drop table if exists `user`;
create table `user` (
                         `id` bigint not null comment 'id',
                         `name` varchar(50) comment '姓名',
                         primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='用户';


# 测试表
drop table if exists `test`;
create table `test` (
                        `id` bigint not null comment 'id',
                        `name` varchar(50) comment '姓名',
                        primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='测试';