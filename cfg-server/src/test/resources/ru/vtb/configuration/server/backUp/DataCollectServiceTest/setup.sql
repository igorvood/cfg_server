create table test_1(
    id varchar(15) primary key,
    const_val varchar(256) generated always as ('topic') stored,
    default_val integer default 15,
    num numeric
)
/
comment on table test_1 is 'test_1.'
/
comment on column test_1.ID is 'ID.'
/
comment on column test_1.const_val is 'ID.'
/
comment on column test_1.default_val is 'ID.'
/
comment on column test_1.num is 'ID.'
/
create table test_1_1(
   id varchar(15) primary key,
   constraint adsd foreign key (id) references test_1(id)
)
/
comment on table test_1_1 is 'test_1_1.'
    /
comment on column test_1_1.ID is 'id.'
    /
