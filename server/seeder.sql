DELETE from LOCATION_UPDATE;
DELETE from RIDE;
DELETE from TRIP_USERS;
DELETE from TRIP;
DELETE from USERS;

INSERT into USERS (USERNAME) values ('hlib');
INSERT into USERS (USERNAME) values ('michele');

insert into trip (destination) values ('Paris');

insert into trip_users (user_id, trip_id) values (
    (select id from users where username = 'hlib'),
    (select id from trip where destination = 'Paris')
);

insert into trip_users (user_id, trip_id) values (
    (select id from users where username = 'michele'),
    (select id from trip where destination = 'Paris')
);

insert into ride (trip_id, is_active, start_location_lng, start_location_lat,
                    start_timestamp, waiting_time)
values (
    (select id from trip where destination = 'Paris'),
    TRUE,
    7.6249481,
    46.4997755,
    to_timestamp('16-05-2011 15:36:38', 'dd-mm-yyyy hh24:mi:ss'),
    0
);