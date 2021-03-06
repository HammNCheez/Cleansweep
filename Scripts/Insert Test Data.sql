use cleansweep;
INSERT INTO tasks (id, task_name, description, cost, duration) VALUES (1, 'Take out trash', 'Gather all trash from the house. Put it into the kitchen trashbag. Take trash bag to outside trash can. Replace trash bag in kitchen and put all trash cans back throughout the house.', 0.25, 10);
INSERT INTO tasks (id, task_name, description, cost, duration) VALUES (2, 'Clean Dishes', 'Collect all of the dirty dishes that are not already in the sink. Put the dirty dishes into the dishwasher. If dishwasher is full run it.', 0.33, 15);
INSERT INTO tasks (id, task_name, description, cost, duration) VALUES (3, 'Empty Dishwasher', 'Empty clean dishes from dishwasher and put them where they belong.', 0.25, 10);
INSERT INTO tasks (id, task_name, description, cost, duration) VALUES (4, 'Vacuum bedrooms', 'Vacuum the 3 bedrooms.', 0.5, 20);
INSERT INTO tasks (id, task_name, description, cost, duration) VALUES (5, 'Mop Kitchen', 'Fill sink with water and floor cleaner. Use mop to clean the kitchen floor.', 0.5, 20);
INSERT INTO tasks (id, task_name, description, cost, duration) VALUES (6, 'Clean Baseboads', 'Use a wet rag and wipe down all of the baseboards.', 0.33, 10);
INSERT INTO tasks (id, task_name, description, cost, duration) VALUES (7, 'Change Air Filter', 'Unscrew grate and replace filter with a new one.', 0.25, 5);

INSERT INTO reoccurring_tasks (id, task_id, frequency, day_number, task_interval, week_number, start_date, end_date, occurrances) VALUES (1, 1, 'D', 1, 3, NULL, '2014-01-01', '2014-12-31', NULL);
INSERT INTO reoccurring_tasks (id, task_id, frequency, day_number, task_interval, week_number, start_date, end_date, occurrances) VALUES (2, 2, 'D', 1, 1, NULL, '2014-01-01', '2014-12-31', NULL);
INSERT INTO reoccurring_tasks (id, task_id, frequency, day_number, task_interval, week_number, start_date, end_date, occurrances) VALUES (3, 3, 'D', 1, 1, NULL, '2014-01-01', '2014-12-31', NULL);
INSERT INTO reoccurring_tasks (id, task_id, frequency, day_number, task_interval, week_number, start_date, end_date, occurrances) VALUES (4, 4, 'W', 4, 1, NULL, '2014-01-01', '2014-12-31', NULL);
INSERT INTO reoccurring_tasks (id, task_id, frequency, day_number, task_interval, week_number, start_date, end_date, occurrances) VALUES (5, 5, 'W', 6, 1, NULL, '2014-01-01', '2014-12-31', NULL);
INSERT INTO reoccurring_tasks (id, task_id, frequency, day_number, task_interval, week_number, start_date, end_date, occurrances) VALUES (6, 6, 'Q', 6, 2, 3, '2014-01-01', '2014-12-31', NULL);
INSERT INTO reoccurring_tasks (id, task_id, frequency, day_number, task_interval, week_number, start_date, end_date, occurrances) VALUES (7, 7, 'Q', 1, 1, NULL, '2014-01-01', '2014-12-31', NULL);

commit;