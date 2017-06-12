insert into activity_type values (1, 'Activity Type', true, 'Activity Name', 1, 1, true);

insert into activity_type_activity_categories values (1, 1);

insert into vessel_type values(1, 'VesselType');

insert into activity_type_vessel_types values(1, 1);

insert into activity_delay values(1, TIMESTAMP '2016-12-14 11:00:00', 'The activity was delayed', TIMESTAMP '2016-12-14 11:00:00');

insert into _user values (1, 'sevila');

insert into activity values (1, 'Activity description 01', TIMESTAMP '2016-12-14 11:00:00', TIMESTAMP '2016-12-14 11:00:00', 'Activity Value', 1, 1);

insert into activity_activity_delays values (1, 1)