create table client_account
(
    acc_num varchar(20) not null,
    client_id varchar(13) not null,
    currency varchar(256) not null,
    constraint client_account_pk primary key (acc_num),
    constraint client_account_client_id_fk foreign key (client_id) references client(id) on delete cascade

)
/
comment on table client_account is 'Справочник клиентов.'
/
comment on column client_account.acc_num is 'номер счета.'
/
comment on column client_account.client_id is 'Идентификатор клиента.'
/
comment on column client_account.currency is 'Валюта.'
/
