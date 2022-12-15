insert into test_1(id, default_val, num)
SELECT 'id_1', -1, 45 from  dual
/
insert into test_1(id, num)
SELECT 'id_2', 45 from  dual
/
insert into test_1_1(id)
SELECT 'id_2' from  dual union
SELECT 'id_1' from  dual
/
create table test_1_back as select * from test_1
/
create table test_1_1_back as select * from test_1_1
/