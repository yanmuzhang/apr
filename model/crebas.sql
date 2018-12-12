/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2018/11/20 15:00:17                          */
/*==============================================================*/


drop table t_app;

drop table t_app_attr;

drop table t_binding_phone_history;

drop table t_button;

drop table t_certification_info;

drop table t_login_info;

drop table t_menu;

drop table t_module;

drop table t_operator;

drop table t_operator_attr;

drop table t_operator_role;

drop table t_organization;

drop table t_people;

drop table t_privilege;

drop table t_role;

/*==============================================================*/
/* Table: t_app                                                 */
/*==============================================================*/
create table t_app (
   id                   VARCHAR(32)          not null,
   secret               VARCHAR(32)          null,
   name                 VARCHAR(32)          null,
   organization_id      VARCHAR(32)          null,
   constraint PK_T_APP primary key (id)
);

comment on table t_app is
'实体对象
应用';

comment on column t_app.id is
'app_id';

comment on column t_app.secret is
'密钥';

comment on column t_app.name is
'应用名';

comment on column t_app.organization_id is
'组织ID';

/*==============================================================*/
/* Table: t_app_attr                                            */
/*==============================================================*/
create table t_app_attr (
   app_id               VARCHAR(32)          null,
   name                 VARCHAR(32)          null,
   type                 VARCHAR(32)          null,
   required             BOOL                 null,
   default_value        VARCHAR(32)          null,
   sort                 INT2                 null,
   constraint PK_T_APP_ATTR primary key ()
);

comment on table t_app_attr is
'值对象
应用属性';

/*==============================================================*/
/* Table: t_binding_phone_history                               */
/*==============================================================*/
create table t_binding_phone_history (
   people_id            VARCHAR(32)          null,
   phone                VARCHAR(11)          null,
   create_time          TIMESTAMP            null,
   binding_type         VARCHAR(11)          null,
   constraint PK_T_BINDING_PHONE_HISTORY primary key ()
);

comment on table t_binding_phone_history is
'值对象
绑定手机号记录';

comment on column t_binding_phone_history.binding_type is
'BINDING,
UNBINDING';

/*==============================================================*/
/* Table: t_button                                              */
/*==============================================================*/
create table t_button (
   id                   VARCHAR(32)          not null,
   btn_no               VARCHAR(45)          null,
   btn_name             VARCHAR(50)          null,
   btn_type             VARCHAR(32)          null,
   btn_icon             VARCHAR(32)          null,
   menu_id              VARCHAR(32)          null,
   init_status          BOOL                 null,
   constraint PK_T_BUTTON primary key (id)
);

comment on table t_button is
'实体对象
按钮';

comment on column t_button.btn_no is
'按钮编码';

comment on column t_button.btn_name is
'按钮名称';

comment on column t_button.btn_type is
'按钮类型';

comment on column t_button.btn_icon is
'按钮标';

comment on column t_button.menu_id is
'菜单ID';

comment on column t_button.init_status is
'1可用,0不可用';

/*==============================================================*/
/* Table: t_certification_info                                  */
/*==============================================================*/
create table t_certification_info (
   id_card_number       VARCHAR(20)          not null,
   name                 VARCHAR(45)          null,
   card_front           VARCHAR(200)         null,
   card_back            VARCHAR(200)         null,
   people_id            VARCHAR(32)          null,
   constraint PK_T_CERTIFICATION_INFO primary key (id_card_number)
);

comment on table t_certification_info is
'值对象
实名认证';

/*==============================================================*/
/* Table: t_login_info                                          */
/*==============================================================*/
create table t_login_info (
   people_id            VARCHAR(32)          not null,
   source               VARCHAR(32)          null,
   mark                 VARCHAR(32)          null,
   status               VARCHAR(32)          null,
   constraint PK_T_LOGIN_INFO primary key (people_id)
);

comment on table t_login_info is
'值对象
登录方式';

comment on column t_login_info.source is
'PASSWORD,
PHONE,
QQ,
WECHART,
ALIPAY,
FACEBOOK,
GOOGLE
';

comment on column t_login_info.status is
'normal,
disable
';

/*==============================================================*/
/* Table: t_menu                                                */
/*==============================================================*/
create table t_menu (
   id                   VARCHAR(32)          not null,
   menu_no              VARCHAR(45)          null,
   module_id            VARCHAR(32)          null,
   parent_id            VARCHAR(32)          null,
   order_list           INT2                 null,
   name                 VARCHAR(50)          null,
   url                  VARCHAR(200)         null,
   icon                 VARCHAR(200)         null,
   is_visible           BOOL                 null,
   is_leaf              INT2                 null,
   constraint PK_T_MENU primary key (id)
);

comment on table t_menu is
'实体对象
菜单';

comment on column t_menu.menu_no is
'菜单编码';

comment on column t_menu.module_id is
'模块ID';

comment on column t_menu.parent_id is
'上级ID';

comment on column t_menu.order_list is
'排序';

comment on column t_menu.name is
'菜单名称';

comment on column t_menu.url is
'菜单地址';

comment on column t_menu.icon is
'菜单图标';

comment on column t_menu.is_visible is
'是否启用';

comment on column t_menu.is_leaf is
'是否为叶子节点';

/*==============================================================*/
/* Table: t_module                                              */
/*==============================================================*/
create table t_module (
   id                   VARCHAR(32)          not null,
   module_code          VARCHAR(45)          null,
   module_name          VARCHAR(50)          null,
   module_desc          VARCHAR(32)          null,
   module_icon          VARCHAR(32)          null,
   module_url           VARCHAR(32)          null,
   app_id               VARCHAR(32)          null,
   constraint PK_T_MODULE primary key (id)
);

comment on table t_module is
'实体对象
系统模块';

comment on column t_module.module_code is
'编码';

comment on column t_module.module_name is
'名称';

comment on column t_module.module_desc is
'描述';

comment on column t_module.module_icon is
'图标';

comment on column t_module.module_url is
'地址';

comment on column t_module.app_id is
'应用ID';

/*==============================================================*/
/* Table: t_operator                                            */
/*==============================================================*/
create table t_operator (
   id                   VARCHAR(20)          not null,
   people_id            VARCHAR(32)          null,
   app_id               VARCHAR(32)          null,
   constraint PK_T_OPERATOR primary key (id)
);

comment on table t_operator is
'实体对象
系统操作员';

/*==============================================================*/
/* Table: t_operator_attr                                       */
/*==============================================================*/
create table t_operator_attr (
   operator_id          VARCHAR(32)          not null,
   name                 VARCHAR(32)          null,
   value                VARCHAR(255)         null,
   sort                 INT2                 null,
   constraint PK_T_OPERATOR_ATTR primary key (operator_id)
);

comment on table t_operator_attr is
'操作员属性';

/*==============================================================*/
/* Table: t_operator_role                                       */
/*==============================================================*/
create table t_operator_role (
   role_id              VARCHAR(32)          not null,
   operator_id          VARCHAR(32)          null,
   constraint PK_T_OPERATOR_ROLE primary key (role_id)
);

comment on table t_operator_role is
'值对象
角色';

/*==============================================================*/
/* Table: t_organization                                        */
/*==============================================================*/
create table t_organization (
   id                   VARCHAR(32)          not null,
   name                 VARCHAR(32)          null,
   organization_type    VARCHAR(32)          null,
   register_number      VARCHAR(32)          null,
   zip_code             VARCHAR(32)          null,
   address              VARCHAR(200)         null,
   organization_code    VARCHAR(32)          null,
   business_scope       VARCHAR(300)         null,
   business_license     VARCHAR(32)          null,
   license_type         VARCHAR(32)          null,
   legal_person_name    VARCHAR(45)          null,
   legal_person_id_number VARCHAR(45)          null,
   legal_person_id_front VARCHAR(200)         null,
   legal_person_id_back VARCHAR(200)         null,
   constraint PK_T_ORGANIZATION primary key (id)
);

comment on table t_organization is
'实体对象
组织机构';

/*==============================================================*/
/* Table: t_people                                              */
/*==============================================================*/
create table t_people (
   id                   VARCHAR(32)          not null,
   phone                VARCHAR(11)          null,
   constraint PK_T_PEOPLE primary key (id)
);

comment on table t_people is
'实体对象   
人
';

/*==============================================================*/
/* Table: t_privilege                                           */
/*==============================================================*/
create table t_privilege (
   id                   VARCHAR(32)          not null,
   master_type          VARCHAR(45)          null,
   maser_id             VARCHAR(32)          null,
   access_type          VARCHAR(45)          null,
   access_id            VARCHAR(32)          null,
   is_operatation       BOOL                 null,
   app_id               VARCHAR(32)          null,
   constraint PK_T_PRIVILEGE primary key (id)
);

comment on table t_privilege is
'实体对象
权限管理表';

comment on column t_privilege.master_type is
'权限主体 1 角色 2 用户 ';

comment on column t_privilege.maser_id is
'主题ID';

comment on column t_privilege.access_type is
'权限访问类型 1 菜单 2 按钮 3 模块';

comment on column t_privilege.access_id is
'权限访问id menu_id或者button_id或者module_id';

comment on column t_privilege.is_operatation is
'禁止使用 默认false';

comment on column t_privilege.app_id is
'应用ID';

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role (
   id                   VARCHAR(20)          not null,
   name                 VARCHAR(45)          null,
   "desc"               VARCHAR(200)         null,
   constraint PK_T_ROLE primary key (id)
);

comment on table t_role is
'实体对象
角色';

