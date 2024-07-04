create table dict_type_client
(
    id varchar(32) not null,
    description varchar(256) not null,
    constraint dict_type_account_pk primary key (id)
)
/
comment on table dict_type_client is 'Справочник типов клиента.'
/
comment on column dict_type_client.id is 'идентификатор типа.'
/
comment on column dict_type_client.description is 'Описание.'
/
