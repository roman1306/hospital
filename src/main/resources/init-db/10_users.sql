--liquibase formatted sql
-- changeset roman1306:init_users context:demo dbms:postgresql
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('Oleg228', 'NoThanks', 'Олег', 'Алексеев', '01-01-1965');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('FOX', 'Qwerty', 'Светлана', 'Гурьева', '01-01-2000');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('Flower', 'SUN', 'Надежда', 'Васильева', '01-01-1976');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('Pashket', 'Role333','Роман','Панченко','01-01-1966');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('Fisher', 'Asdfgh','Петр', 'Козлов', '01-01-1997');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('Angela', 'Gelik', 'Анжелика', 'Кривобогатова', '01-01-1998');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('Allushka', 'Topor789','Алена', 'Воробьева', '01-01-1990');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('Mitya', 'IceCream', 'Дмитрий', 'Кривошея', '01-01-1992');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('Lermontov', 'Koshka', 'Ольга', 'Колотушкина', '01-01-1996');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('Singer', 'Lolita', 'Афанасий', 'Рогов', '01-01-1997');
INSERT INTO public.users (username, password, name, surname, birth_date) VALUES ('PoliceWoman', 'HeadShot', 'Ксения', 'Куева', '01-01-1985');