CREATE TABLE USER_DETAILS  (    "UD_ID" NUMBER(10,0) NOT NULL ENABLE,   
    "UD_NAME" VARCHAR2(255 CHAR),   
    "UD_FIRSTNAME" CHAR(60CHAR),
    "UD_MOBILE" CHAR(60CHAR), 
     PRIMARY KEY ("UD_ID") ENABLE  
   )
   
CREATE SEQUENCE UD_SEQ

CREATE OR REPLACE TRIGGER UD_SEQ_ID 
BEFORE INSERT ON USER_DETAILS 
FOR EACH ROW

BEGIN
  SELECT UD_SEQ.NEXTVAL
  INTO   :new.UD_ID
  FROM   dual;
END;   