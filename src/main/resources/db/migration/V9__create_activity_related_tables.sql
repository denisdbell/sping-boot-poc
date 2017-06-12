CREATE TABLE activity
(
  id integer NOT NULL,
  description character varying(255),
  end_date_time timestamp without time zone,
  start_date_time timestamp without time zone,
  value character varying(255),
  activity_type_id integer,
  user_id integer,
  PRIMARY KEY (id),
  FOREIGN KEY (activity_type_id)
      REFERENCES activity_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  FOREIGN KEY (user_id)
      REFERENCES _user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE activity_activity_delays
(
  activity_id integer NOT NULL,
  activity_delays_id integer NOT NULL,
  FOREIGN KEY (activity_delays_id)
      REFERENCES activity_delay (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  FOREIGN KEY (activity_id)
      REFERENCES activity (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  UNIQUE (activity_delays_id)
);