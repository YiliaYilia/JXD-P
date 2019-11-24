drop table if exists GE_AREA;

drop table if exists GE_DAILY_RECORD;

drop table if exists GE_DEPARTMENT;

drop table if exists GE_DICT_DATA;

drop table if exists GE_DICT_TYPE;

drop table if exists GE_PERMISSION;

drop table if exists GE_PERMISSION_RESOURCES;

drop table if exists GE_RESOURCES;

drop table if exists GE_RESOURCES_ICON;

drop table if exists GE_ROLE;

drop table if exists GE_ROLE_PERMISSION;

drop table if exists GE_SYSTEM_TEMPLATE;

drop table if exists GE_USER;

drop table if exists GE_USERGROUP;

drop table if exists GE_USERGROUP_ROLE;

drop table if exists GE_USER_DEP;

drop table if exists GE_USER_ROLE;

drop table if exists GE_USER_USERGROUP;

/*==============================================================*/
/* Table: GE_AREA                                               */
/*==============================================================*/
create table GE_AREA
(
   GID                  varchar(255) not null comment '区域编号',
   GNAME                varchar(255) not null comment '区域名称',
   PGID                 varchar(255) not null comment '父区域',
   NOTE                 varchar(255) comment '备注',
   CREATETIME           datetime comment '创建时间',
   primary key (GID)
);

/*==============================================================*/
/* Table: GE_DAILY_RECORD                                       */
/*==============================================================*/
create table GE_DAILY_RECORD
(
   RECORDID             varchar(255) not null comment '记录编号',
   OPERATORNAME         varchar(50) not null comment '操作人',
   RECORDTYPE           varchar(50) comment '操作类型',
   CREATETIME           datetime comment '创建时间',
   DESCRIPTION          varchar(255) comment '记录内容',
   EXPENGTIME           varchar(50) comment '消耗时间',
   primary key (RECORDID)
);

/*==============================================================*/
/* Table: GE_DEPARTMENT                                         */
/*==============================================================*/
create table GE_DEPARTMENT
(
   DEPTID               varchar(255) not null comment '机构编号',
   DEPTNAME             varchar(255) not null comment '机构名称',
   PARENTID             varchar(255) not null comment '父机构',
   CONTACTADDRESS       varchar(255) comment '通讯地址',
   OFFICEPHONE          varchar(50) comment '办公电话',
   ZIPCODE              varchar(50) comment '邮编',
   ORGANTYPE            varchar(50) comment '机构类型',
   ROOT                 varchar(50) comment 'root 表示该为根节点，否则为空',
   DEPTCODE             varchar(255) comment '机构编码',
   primary key (DEPTID)
);

/*==============================================================*/
/* Table: GE_DICT_DATA                                          */
/*==============================================================*/
create table GE_DICT_DATA
(
   DICTDATAID           varchar(255) not null comment '字典编号',
   DICTTYPEID           varchar(255) not null comment '字典类型',
   DICTDATACODE         varchar(50) not null comment '字典编码',
   DICTDATANAME         varchar(50) not null comment '字典名称',
   DICTDATADESC         varchar(255) comment '字典描述',
   CREATETIME           datetime not null,
   OPERATORNAME         varchar(50) not null comment '操作人员',
   primary key (DICTDATAID)
);

/*==============================================================*/
/* Table: GE_DICT_TYPE                                          */
/*==============================================================*/
create table GE_DICT_TYPE
(
   DICTTYPEID           varchar(255) not null comment '字典类型编号',
   DICTTYPECODE         varchar(50) not null comment '字典类型编码',
   DICTTYPENAME         varchar(50) not null comment '字典类型名称',
   CREATETIME           datetime not null comment '创建时间',
   OPERATORNAME         varchar(50) not null comment '操作人员',
   primary key (DICTTYPEID)
);

/*==============================================================*/
/* Table: GE_PERMISSION                                         */
/*==============================================================*/
create table GE_PERMISSION
(
   PERMISSIONID         varchar(255) not null comment '权限编号',
   PERMISSIONNAME       varchar(255) not null comment '权限名称',
   PERMISSIONDESC       varchar(255) comment '权限描述',
   CREATETIME           datetime not null comment '创建时间',
   OPERATORNAME         varchar(50) not null comment '操作人员',
   primary key (PERMISSIONID)
);

alter table GE_PERMISSION comment '权限';

/*==============================================================*/
/* Table: GE_PERMISSION_RESOURCES                               */
/*==============================================================*/
create table GE_PERMISSION_RESOURCES
(
   PERMISSIONID         varchar(255) comment '权限编号',
   RESOURCESID          varchar(255) comment '资源编号'
);

alter table GE_PERMISSION_RESOURCES comment '权限-资源';

/*==============================================================*/
/* Table: GE_RESOURCES                                          */
/*==============================================================*/
create table GE_RESOURCES
(
   RESOURCESID          varchar(255) not null comment '资源编号',
   RESOURCESNAME        varchar(255) not null comment '资源名称',
   RESOURCESTYPE        varchar(50) not null comment '资源类型',
   RESOURCESLINKTYPE    varchar(50) comment '链接类型',
   RESOURCESPARENT      varchar(255) not null comment '资源父节点',
   RESOURCESCONTENT     varchar(255) comment '资源内容',
   RESOURCESDESC        varchar(500) comment '资源描述',
   RESOURCESSTYLE       varchar(255) comment '样式',
   RESOURCESICONID      varchar(255) comment '资源图标编号',
   RESOURCESCODE        varchar(255) not null comment '资源编码',
   primary key (RESOURCESID)
);

alter table GE_RESOURCES comment '资源';

/*==============================================================*/
/* Table: GE_RESOURCES_ICON                                     */
/*==============================================================*/
create table GE_RESOURCES_ICON
(
   RESOURCESICONID      varchar(255) not null comment '资源图标编号',
   RESOURCESICONPATH    varchar(255) not null comment '资源图标路径',
   primary key (RESOURCESICONID)
);

/*==============================================================*/
/* Table: GE_ROLE                                               */
/*==============================================================*/
create table GE_ROLE
(
   ROLEID               varchar(255) not null comment '角色编号',
   ROLENAME             varchar(255) not null comment '角色名称',
   ROLEDESC             varchar(500) comment '角色描述',
   CREATETIME           datetime not null comment '创建时间',
   OPERATORNAME         varchar(50) not null comment '操作人员',
   primary key (ROLEID)
);

alter table GE_ROLE comment '角色';

/*==============================================================*/
/* Table: GE_ROLE_PERMISSION                                    */
/*==============================================================*/
create table GE_ROLE_PERMISSION
(
   ROLEID               varchar(255) not null comment '角色编号',
   PERMISSIONID         varchar(255) not null comment '权限编号'
);

alter table GE_ROLE_PERMISSION comment '角色-权限';

/*==============================================================*/
/* Table: GE_SYSTEM_TEMPLATE                                    */
/*==============================================================*/
create table GE_SYSTEM_TEMPLATE
(
   GETEMPID             varchar(255) not null comment '模板编号',
   TEMPNAME             varchar(50) not null comment '模板名',
   TEMPCONTENT          text not null comment '模板内容',
   FUNCTIONCODE         varchar(255) not null comment '功能编号',
   TEMPTYPECODE         varchar(255) not null comment '类型编号',
   CREATETIME           datetime not null comment '创建时间',
   OPERATORNAME         varchar(50) not null comment '操作人员',
   primary key (GETEMPID)
);

/*==============================================================*/
/* Table: GE_USER                                               */
/*==============================================================*/
create table GE_USER
(
   USERID               varchar(255) not null comment '用户编号',
   USERNAME             varchar(255) not null comment '用户名称',
   PASSWORD             varchar(255) not null comment '用户密码',
   USERTYPE             varchar(255) comment '用户类型 0:超级管理员 1:普通管理员',
   EMAIL                varchar(255) comment '用户邮箱',
   SEX                  varchar(255) not null comment '用户性别',
   PHONE                varchar(255) comment '用户手机',
   STATE                varchar(2) not null default '1' comment '用户状态 1：表示有效 0：表示无效',
   CREATETIME           datetime not null comment '创建时间',
   OPERATORNAME         varchar(50) comment '操作人员',
   primary key (USERID)
);

alter table GE_USER comment 'MIS后台用户表';

/*==============================================================*/
/* Table: GE_USERGROUP                                          */
/*==============================================================*/
create table GE_USERGROUP
(
   USERGROUPID          varchar(255) not null comment '用户组编号',
   USERGROUPNAME        varchar(255) not null comment '用户组名称',
   USERGROUPDESC        varchar(500) comment '用户组描述',
   CREATETIME           datetime not null comment '创建时间',
   OPERATORNAME         varchar(50) not null comment '操作人员',
   primary key (USERGROUPID)
);

alter table GE_USERGROUP comment '用户组';

/*==============================================================*/
/* Table: GE_USERGROUP_ROLE                                     */
/*==============================================================*/
create table GE_USERGROUP_ROLE
(
   USERGROUPID          varchar(255) not null comment '用户组编号',
   ROLEID               varchar(255) not null comment '角色编号'
);

alter table GE_USERGROUP_ROLE comment '用户组-角色';

/*==============================================================*/
/* Table: GE_USER_DEP                                           */
/*==============================================================*/
create table GE_USER_DEP
(
   USERID               varchar(255) comment '用户编号',
   DEPTID               varchar(255) comment '机构编号'
);

/*==============================================================*/
/* Table: GE_USER_ROLE                                          */
/*==============================================================*/
create table GE_USER_ROLE
(
   USERID               varchar(255) not null comment '用户编号',
   ROLEID               varchar(255) not null comment '角色编号'
);

alter table GE_USER_ROLE comment '用户-角色';

/*==============================================================*/
/* Table: GE_USER_USERGROUP                                     */
/*==============================================================*/
create table GE_USER_USERGROUP
(
   USERID               varchar(255) not null comment '用户编号',
   USERGROUPID          varchar(255) not null comment '用户组编号'
);

alter table GE_USER_USERGROUP comment '用户-用户组';
