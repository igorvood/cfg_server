create table dict_currency
(
  id varchar(256) not null,
  iso varchar(32)  not null,
  constraint dict_currency_pk primary key (id),
  constraint dict_currency_uk unique (iso)
)
/
comment on table dict_currency is 'Справочник Валют.'
/
comment on column dict_currency.id is 'Буквенный код валюты.'
/
comment on column dict_currency.iso is 'Числовой код валюты.'
/
