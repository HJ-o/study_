CREATE TABLE guestbook (
  id NUMBER(11) NOT NULL,
  name VARCHAR(255) NOT NULL,
  content VARCHAR2(1000) NOT NULL,
  regdate DATE DEFAULT NULL, 
  constraint pk PRIMARY KEY(id)
);

COMMENT ON COLUMN guestbook.id is 'guestbook id';
COMMENT ON COLUMN guestbook.name is 'user name';
COMMENT ON COLUMN guestbook.content is 'guestbook content';
COMMENT ON COLUMN guestbook.regdate is '�����';


CREATE SEQUENCE tmp_seq START WITH 1 INCREMENT BY 1 NOCACHE;

select parameter, value
from nls_database_parameters
where parameter like '%CHAR%';
select parameter, value
from nls_database_parameters
where parameter like 'NLS%';
--update sys.props$ set value$='AL32UTF8' where name='NLS_CHARACTERSET';
--update sys.props$ set value$='AL32UTF8' where name='NLS_NCHAR_CHARACTERSET';
--update sys.props$ set value$='KOREAN_KOREA.UTF8' where name='NLS_LANGUAGE';
--commit;
--근데 이거 하고 DB 재시작해줘도 왜 적용이 안되는지 모르겠음... 한글 다깨짐...