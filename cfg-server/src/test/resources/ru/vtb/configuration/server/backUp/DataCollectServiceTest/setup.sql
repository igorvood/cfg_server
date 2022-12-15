create table test_1(
    id varchar(15) primary key,
    const_val varchar(256) generated always as ('topic') stored,
    default_val integer default 15,
    num numeric
)
/
create table test_1_1(
   id varchar(15) primary key,
   constraint adsd foreign key (id) references test_1(id)
)
/
