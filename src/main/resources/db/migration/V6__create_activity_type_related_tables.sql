CREATE TABLE activity_type
(
  id integer NOT NULL,
  description character varying(255),
  mandatory boolean NOT NULL,
  name character varying(255),
  occurrences integer,
  _order integer,
  ranged_activity_indicator boolean,
  PRIMARY KEY (id)
);
CREATE TABLE activity_type_activity_categories
(
  activity_type_id integer NOT NULL,
  activity_categories_id integer NOT NULL,
  FOREIGN KEY (activity_type_id)
      REFERENCES activity_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  FOREIGN KEY (activity_categories_id)
      REFERENCES activity_category (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE activity_type_vessel_types
(
  activity_type_id integer NOT NULL,
  vessel_types_id integer NOT NULL,
  FOREIGN KEY (activity_type_id)
      REFERENCES activity_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  FOREIGN KEY (vessel_types_id)
      REFERENCES vessel_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);