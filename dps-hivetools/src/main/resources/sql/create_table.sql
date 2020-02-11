use odm;
drop table if exitsts odm. o_ldm_dsr_${hiveconf:yyyymmdd};
ceate external table if not exists odm. o_ldm_dsr_${hiveconf:yyyymmdd}(
Dsrbh string COMMENT '当事人编号'
,dsrlxdm string COMMENT '当事人类型代码'
cif2khh string COMMENT 'CIF2客户号',
ecifh string COMMENT 'ECIF号',
zkhbz string COMMENT '主客户标志',
sxrq date COMMENT '生效日期',
sxrq date COMMENT '失效日期',
)
row format delimited
fields by '/001'
file_format TEXTFILE
LOCATION '/user/hive/data/etl/${hiveconf:yyyymmdd}/o_ldm_dsr/'
COMMENT '当事人';

use PDM;
drop table if exitsts PDM.O_LDM_DSR_20200209;
ceate external table if not exists PDM.O_LDM_DSR_20200209(
Party_Id VARCHAR(60) COMMENT '当事人编号'
,Party_Type_Cd VARCHAR(30) COMMENT '当事人类型代码'
,Party_No VARCHAR(30) COMMENT 'CIF2客户号'
,Ecif_No VARCHAR(30) COMMENT 'ECIF号'
,Master_Ind CHAR(2) COMMENT '主客户标志'
,Eff_Dt DATE COMMENT '生效日期'
,Close_Dt DATE COMMENT '失效日期'
,Create_Dt DATE COMMENT '创建日期'
,Create_Tm INT COMMENT '创建时间'
,Update_Dt DATE COMMENT '更新日期'
,Update_Tm INT COMMENT '更新时间'
,Tx_Dt DATE COMMENT '数据日期'
)
row format delimited
fields by ','
file_format TEXTFILE
LOCATION '/user/hive/data/etl/'
COMMENT '当事人';

