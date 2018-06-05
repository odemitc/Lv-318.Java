INSERT INTO public.category (type, id, name, next_level_category_id) VALUES ('EXTENDABLE', 18, 'Public Transport', null);
INSERT INTO public.category (type, id, name, next_level_category_id) VALUES ('EXTENDABLE', 17, 'Lviv', 18);
INSERT INTO public.category (type, id, name, next_level_category_id) VALUES ('EXTENDABLE', 15, 'Kyiv', 18);
INSERT INTO public.category (type, id, name, next_level_category_id) VALUES ('NON_EXTENDABLE', 16, 'Tram', 17);
INSERT INTO public.category (type, id, name, next_level_category_id) VALUES ('NON_EXTENDABLE', 19, 'Trolleybus', 17);
INSERT INTO public.category (type, id, name, next_level_category_id) VALUES ('NON_EXTENDABLE', 24, 'Bus', 17);
INSERT INTO public.category (type, id, name, next_level_category_id) VALUES ('NON_EXTENDABLE', 25, 'Marshrutka', 17);

--users
INSERT INTO public.users (id, email, first_name, last_name, password) VALUES (1, 'name1@gmail.com', 'Name1', 'Lastname1', '1111');
INSERT INTO public.users (id, email, first_name, last_name, password) VALUES (2, 'name2@gmail.com', 'Name2', 'Lastname2', '2222');
INSERT INTO public.users (id, email, first_name, last_name, password) VALUES (3, 'name3@gmail.com', 'Name3', 'Lastname3', '3333');

INSERT INTO public.stop (id, street) VALUES (1, '"Залізничний Вокзал"');
INSERT INTO public.stop (id, street) VALUES (2, '"Приміський Вокзал"');
INSERT INTO public.stop (id, street) VALUES (3, '"Бандери"');
INSERT INTO public.stop (id, street) VALUES (4, '"Сахарова"');
INSERT INTO public.stop (id, street) VALUES (5, '"Парк культури"');
INSERT INTO public.stop (id, street) VALUES (6, '"Шухевича"');
INSERT INTO public.stop (id, street) VALUES (7, '"Руська"');
INSERT INTO public.stop (id, street) VALUES (8, '"Дорошенка"');
INSERT INTO public.stop (id, street) VALUES (9, '"Кропивницького"');
INSERT INTO public.stop (id, street) VALUES (10, '"Університет"');
INSERT INTO public.stop (id, street) VALUES (11, '"Собор Св. Юра"');
INSERT INTO public.stop (id, street) VALUES (12, '"Смаль-Стоцького"');
INSERT INTO public.stop (id, street) VALUES (13, '"Кульпарківська"');
INSERT INTO public.stop (id, street) VALUES (14, '"Наукова"');
INSERT INTO public.stop (id, street) VALUES (15, '"Центр зайнятості"');
INSERT INTO public.stop (id, street) VALUES (16, '"Тролейбусна"');
INSERT INTO public.stop (id, street) VALUES (17, '"Victoria Gardens"');
INSERT INTO public.stop (id, street) VALUES (18, '"Аквапарк"');
INSERT INTO public.stop (id, street) VALUES (19, '"Скнилівок"');
INSERT INTO public.stop (id, street) VALUES (20, '"Будинок Меблів"');
INSERT INTO public.stop (id, street) VALUES (21, '"Окружна"');
INSERT INTO public.stop (id, street) VALUES (22, '"Цирк"');
INSERT INTO public.stop (id, street) VALUES (23, '"Магнус"');
INSERT INTO public.stop (id, street) VALUES (24, '"Хімічна"');
INSERT INTO public.stop (id, street) VALUES (25, '"Мазепи"');
INSERT INTO public.stop (id, street) VALUES (26, '"Галицьке перехрестя"');


INSERT INTO public.transit (id, name, category_id) VALUES (4, '#51', 25);
INSERT INTO public.transit (id, name, category_id) VALUES (1, '#9', 16);
INSERT INTO public.transit (id, name, category_id) VALUES (2, '#2', 19);
INSERT INTO public.transit (id, name, category_id) VALUES (6, '#7', 16);
INSERT INTO public.transit (id, name, category_id) VALUES (3, '#3А', 24);
INSERT INTO public.transit (id, name, category_id) VALUES (7, '#6', 16);


INSERT INTO public.feedback_criteria (criteria_type, id, group_id, question, type, weight, category_id) VALUES ('RATING_CRITERIA', 11, 1, 'якість проїзду', 'RATING', 2, 16);
INSERT INTO public.feedback_criteria (criteria_type, id, group_id, question, type, weight, category_id) VALUES ('FEEDBACK_CRITERIA', 2, 1, 'о котрій годині виїхали?', 'BUSY_HOURS', null, 16);
INSERT INTO public.feedback_criteria (criteria_type, id, group_id, question, type, weight, category_id) VALUES ('FEEDBACK_CRITERIA', 3, 2, 'Чи доїхали до місця призначення?', 'RATING', null, 16);
INSERT INTO public.feedback_criteria (criteria_type, id, group_id, question, type, weight, category_id) VALUES ('FEEDBACK_CRITERIA', 4, 1, 'о котрій годині виїхали?', 'BUSY_HOURS', null, 25);
INSERT INTO public.feedback_criteria (criteria_type, id, group_id, question, type, weight, category_id) VALUES ('RATING_CRITERIA', 5, 1, 'якість проїзду', 'RATING', 2, 25);
INSERT INTO public.feedback_criteria (criteria_type, id, group_id, question, type, weight, category_id) VALUES ('FEEDBACK_CRITERIA', 6, 2, 'Чи доїхали до місця призначення?', 'RATING', null, 25);
INSERT INTO public.feedback_criteria (criteria_type, id, group_id, question, type, weight, category_id) VALUES ('FEEDBACK_CRITERIA', 7, 1, 'о котрій годині виїхали?', 'BUSY_HOURS', null, 24);
INSERT INTO public.feedback_criteria (criteria_type, id, group_id, question, type, weight, category_id) VALUES ('RATING_CRITERIA', 8, 1, 'якість проїзду', 'RATING', 2, 24);
INSERT INTO public.feedback_criteria (criteria_type, id, group_id, question, type, weight, category_id) VALUES ('FEEDBACK_CRITERIA', 9, 2, 'Чи доїхали до місця призначення?', 'RATING', null, 24);


INSERT INTO public.feedback (id, answer, criteria_id, transit_id, user_id) VALUES (2, '345', 2, 4, 1);
INSERT INTO public.feedback (id, answer, criteria_id, transit_id, user_id) VALUES (1, '5', 2, 4, 1);
INSERT INTO public.feedback (id, answer, criteria_id, transit_id, user_id) VALUES (3, 'Так', 3, 1, 2);
INSERT INTO public.feedback (id, answer, criteria_id, transit_id, user_id) VALUES (4, '10', 5, 4, 2);
INSERT INTO public.feedback (id, answer, criteria_id, transit_id, user_id) VALUES (5, '12', 8, 3, 3);
INSERT INTO public.feedback (id, answer, criteria_id, transit_id, user_id) VALUES (6, 'Так', 9, 3, 3);

INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (1, 1, 1);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (1, 2, 2);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (1, 3, 3);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (1, 4, 4);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (1, 5, 5);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (1, 6, 6);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (1, 7, 7);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (1, 8, 8);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (1, 9, 9);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (2, 10, 1);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (2, 11, 2);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (2, 3, 3);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (2, 12, 4);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (2, 13, 5);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (2, 14, 6);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (2, 15, 7);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (2, 16, 8);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 17, 1);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 14, 2);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 15, 3);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 18, 4);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 19, 5);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 20, 6);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 21, 7);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 13, 8);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 2, 9);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 22, 10);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 23, 11);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 24, 12);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 25, 13);
INSERT INTO public.transit_stop (transit_id, stop_id, stop_index) VALUES (4, 26, 14);


