
ALTER TABLE USERS ALTER Email SET DATA TYPE VARCHAR(60)
ALTER TABLE XXX DROP COLUMN XXX;

CREATE TABLE USERS (   
   "USER_ID"INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   "FIRST_NAME" VARCHAR(120),
   "LAST_NAME" VARCHAR(120),
   "EMAIL" VARCHAR(120) ,
   "PHONE_NUMBER" VARCHAR(12) ,
   "ADDRESS" VARCHAR(120) ,
   "ROLE_ID" INTEGER NOT NULL DEFAULT 1,
   "LOGIN_ID" INTEGER NOT  NULL,
    CONSTRAINT primary_key_user PRIMARY KEY (USER_ID)
);


CREATE TABLE LOGIN (   
   "LOGIN_ID"INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),   
   "EMAIL" VARCHAR(120) UNIQUE,
   "PASSWORD" VARCHAR(60) ,
   "USER_KEY" VARCHAR(60), 
    CONSTRAINT primary_key_login PRIMARY KEY (LOGIN_ID)
);


ALTER TABLE USERS ADD CONSTRAINT LOGIN_ID_FK
Foreign Key (LOGIN_ID) REFERENCES LOGIN (LOGIN_ID);

CREATE TABLE ROLES (   
   "ROLE_ID"INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   "ROLE_TYPE" VARCHAR(60) NOT NULL UNIQUE ,
    CONSTRAINT primary_key_role PRIMARY KEY (ROLE_ID)
);

ALTER TABLE USERS ADD CONSTRAINT ROLE_ID_FK
Foreign Key (ROLE_ID) REFERENCES ROLES (ROLE_ID);

CREATE TABLE GENRES (   
   "GENRE_ID"INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   "GENRE" VARCHAR(80) NOT NULL UNIQUE ,
    CONSTRAINT primary_key_role PRIMARY KEY (GENRE_ID)
);

CREATE TABLE MOVIES (   
   "MOVIE_ID"INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   "MOVIE_TITLE" VARCHAR(80) NOT NULL UNIQUE ,
    "GENRE_ID" INTEGER NOT NULL,
    "RELEASE_YEAR" INTEGER,
    "DESCRIPTION" VARCHAR(500),
    "ACTIVE" VARCHAR(1) DEFAULT 'T',
    CONSTRAINT primary_key_movies PRIMARY KEY (MOVIE_ID)
);

CREATE TABLE MOVIES_TYPE (   
   "MOVIE_TYPE_ID"INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   "TYPE" VARCHAR(80) NOT NULL UNIQUE ,
    "PRICE" DOUBLE NOT NULL,
    "STOCK" INTEGER,
    "MOVIE_ID" INTEGER,
    "ACTIVE" VARCHAR(1) DEFAULT 'T',
    CONSTRAINT primary_key_movies_type PRIMARY KEY (MOVIE_TYPE_ID),
    Foreign Key (MOVIE_ID) REFERENCES MOVIES (MOVIE_ID)
);

