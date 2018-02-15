CREATE TABLE IF NOT EXISTS USERS (
    ID               SERIAL                  PRIMARY KEY NOT NULL,
    USERNAME         VARCHAR(50)             UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS TRIP (
    ID               SERIAL                  PRIMARY KEY NOT NULL,
    DESTINATION      VARCHAR(50)             NOT NULL
);

CREATE TABLE IF NOT EXISTS TRIP_USERS (
    ID               SERIAL                  PRIMARY KEY NOT NULL,
    USER_ID          INTEGER                 NOT NULL,
    TRIP_ID          INTEGER                 NOT NULL,

    CONSTRAINT user_id_fk FOREIGN KEY (USER_ID) REFERENCES USERS (ID),
    CONSTRAINT trip_id_fk FOREIGN KEY (TRIP_ID) REFERENCES TRIP (ID)
);

CREATE TABLE IF NOT EXISTS RIDE (
    ID                    SERIAL             PRIMARY KEY NOT NULL,
    TRIP_ID               INTEGER            NOT NULL,
    IS_ACTIVE             BOOLEAN            NOT NULL,
    START_LOCATION_LNG    DECIMAL(9,6)       NOT NULL,
    START_LOCATION_LAT    DECIMAL(9,6)       NOT NULL,
    START_TIMESTAMP       TIMESTAMP          NOT NULL,
    WAITING_TIME          INTEGER            NOT NULL,
    END_LOCATION_LNG      DECIMAL(9,6)       ,
    END_LOCATION_LAT      DECIMAL(9,6)       ,
    END_TIMESTAMP         TIMESTAMP          ,
    DISTANCE              INTEGER            ,
    POLYLINE              TEXT               ,

    CONSTRAINT ride_trip_id_fk FOREIGN KEY (TRIP_ID) REFERENCES TRIP (ID)
);

CREATE TABLE IF NOT EXISTS LOCATION_UPDATE (
    ID                    SERIAL            PRIMARY KEY NOT NULL,
    USER_ID               INTEGER           NOT NULL,
    RIDE_ID               INTEGER           NOT NULL,
    LNG                   DECIMAL(9,6)      NOT NULL,
    LAT                   DECIMAL(9,6)      NOT NULL,
    TIME_STAMP            TIMESTAMP         NOT NULL,

    CONSTRAINT locationupdate_user_id_fk FOREIGN KEY (USER_ID) REFERENCES USERS (ID),
    CONSTRAINT ride_id_fk FOREIGN KEY (RIDE_ID) REFERENCES RIDE (ID)
);