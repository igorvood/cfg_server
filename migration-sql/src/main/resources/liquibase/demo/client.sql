create table client
(
    passport_num varchar(6) not null,
    passport_ser varchar(6) not null,
    id varchar(13) generated always as (passport_ser||'_'||passport_num) stored,
    fio varchar(256) not null,
    client_type varchar(32) not null,
    constraint client_client_type_fk foreign key (client_type) references dict_type_client(id) on delete cascade,
    constraint client_pk primary key (id)  ,
    constraint client_uk unique (passport_num, passport_ser)
)
/
comment on table client is 'Справочник клиентов.'
/
comment on column client.passport_num is 'номер паспорта.'
/
comment on column client.passport_ser is 'серия паспорта.'
/
comment on column client.id is 'Идентификатор клиента.'
/
comment on column client.fio is 'ФИО.'
/
comment on column client.client_type is 'тип клиента.'
/

