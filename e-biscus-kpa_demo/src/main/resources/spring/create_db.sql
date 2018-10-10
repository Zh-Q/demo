-- Create Company table
create table Company
(
  c_id           varchar2(36) not null,
  c_name         nvarchar2(300) not null,
  c_remark       nvarchar2(1000),
  c_expire_date  date not null,
  c_create_date  date not null,
  c_legal_person varchar2(36) not null
)
;
-- Add comments to the table 
comment on table Company
  is 'Create by Zhang Qi for SpringBoot & mybatis tests demo';
-- Add comments to the columns 
comment on column Company.c_id
  is 'company id';
comment on column Company.c_name
  is 'company name';
comment on column Company.c_remark
  is 'company remark';
comment on column Company.c_expire_date
  is 'the expire date of this company';
comment on column Company.c_create_date
  is 'the create date of this company';
comment on column Company.c_legal_person
  is 'the legal person of this company';
-- Create/Recreate primary, unique and foreign key constraints 
alter table Company
  add constraint SPRINGBOOT_MYBATIS_PK_CMP_ID primary key (C_ID);

-- Create Product table
create table Product
(
  p_id              varchar2(36) not null,
  p_name            nvarchar2(200) not null,
  p_c_id            varchar2(36) not null,
  p_place_of_origin nvarchar2(100),
  p_auth_date       date not null,
  p_remark          nvarchar2(1000)
)
;
-- Add comments to the table 
comment on table Product
  is 'Created by Zhang Qi for SpringBoot & mybatis test demo';
-- Add comments to the columns 
comment on column Product.p_id
  is 'product id';
comment on column Product.p_name
  is 'product name';
comment on column Product.p_c_id
  is 'the company of the product belongs to';
comment on column Product.p_place_of_origin
  is 'the place of origin of this product';
comment on column Product.p_auth_date
  is 'the authorization date of this product';
comment on column Product.p_remark
  is 'remark';
-- Create/Recreate primary, unique and foreign key constraints 
alter table Product
  add constraint SpringBoot_MyBatis_PK_P_ID primary key (P_ID);
alter table Product
  add constraint SpringBoot_MyBatis_FK_P_ID foreign key (P_C_ID)
  references company (C_ID);
