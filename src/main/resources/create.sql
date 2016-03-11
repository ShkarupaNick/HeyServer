CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS public.message_log;
DROP TABLE IF EXISTS public.message;

CREATE  TABLE   public.message
(
   message_id uuid NOT NULL DEFAULT uuid_generate_v1() PRIMARY KEY,
   message_content text, 
   message_type text
) 
WITH (
  OIDS = FALSE
)
;

CREATE TABLE  public.message_log
(

   uuid uuid NOT NULL DEFAULT uuid_generate_v1() PRIMARY KEY,
   message_id uuid references message(message_id),
   sender_phone_number text, 
   recipient_phone_number text,
   sending_date date NOT NULL DEFAULT CURRENT_DATE,
   delivering_status text
   ) 
WITH (
  OIDS = FALSE
)
;