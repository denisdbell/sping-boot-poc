CREATE TABLE activity_delay
(
  id integer NOT NULL,
  end_date_time timestamp with time zone,
  reason character varying(255),
  start_date_time timestamp with time zone,
  PRIMARY KEY (id)
);