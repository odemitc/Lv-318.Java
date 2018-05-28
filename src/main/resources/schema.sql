create table category
(
  type                   varchar(31) not null,
  id                     integer     not null
    constraint category_pkey
    primary key,
  name                   varchar(255),
  next_level_category_id integer
    constraint fk689kxbrdmkn664pf60tbyi26g
    references category
);

create table feedback_criteria
(
  id          integer not null
    constraint feedback_criteria_pkey
    primary key,
  question    varchar(255),
  type        varchar(255),
  category_id integer
    constraint fkmjwr3x39m4wtsganrkkiswtvu
    references category,
  group_id    integer
);

create table transit
(
  id          integer not null
    constraint transit_pkey
    primary key,
  name        varchar(255),
  category_id integer
    constraint fkq0p89f1d1ue64ete2nrpe2gaa
    references category
);

create table stop
(
  id       integer not null
    constraint stop_pkey
    primary key,
  building varchar(255),
  street   varchar(255),
  stop_id  integer
    constraint fk46chxuk0q5477snlgr4tek0mk
    references transit
);

create table feedback
(
  id          integer not null
    constraint feedback_pkey
    primary key,
  answer      varchar(255),
  user_id     integer not null,
  criteria_id integer
    constraint fkt3d5bwbhaiiwp7x83bqvshhgv
    references feedback_criteria,
  transit_id  integer
    constraint fk8lxp0isnr3dgtl791ycap66xb
    references transit
);

