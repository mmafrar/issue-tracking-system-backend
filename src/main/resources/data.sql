INSERT INTO developer (developer_id, name) VALUES (11, 'Developer 11');
INSERT INTO developer (developer_id, name) VALUES (12, 'Developer 12');
INSERT INTO developer (developer_id, name) VALUES (13, 'Developer 13');

INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 11, 'Story Title 11', 'Story Description 11', 1, 2, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 12, 'Story Title 12', 'Story Description 12', 1, 3, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 13, 'Story Title 13', 'Story Description 13', 1, 5, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 14, 'Story Title 14', 'Story Description 14', 1, 8, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 15, 'Story Title 15', 'Story Description 15', 1, 8, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 16, 'Story Title 16', 'Story Description 16', 1, 8, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 17, 'Story Title 17', 'Story Description 17', 1, 8, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 18, 'Story Title 18', 'Story Description 18', 1, 5, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 19, 'Story Title 19', 'Story Description 19', 1, 3, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 20, 'Story Title 20', 'Story Description 20', 1, 2, CURRENT_TIMESTAMP());

INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 21, 'Bug Title 21', 'Bug Description 21', 0, 1, 11, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 22, 'Bug Title 22', 'Bug Description 22', 0, 1, 12, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 23, 'Bug Title 23', 'Bug Description 23', 0, 1, 11, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 24, 'Bug Title 24', 'Bug Description 24', 0, 1, 12, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 25, 'Bug Title 25', 'Bug Description 25', 0, 1, 11, CURRENT_TIMESTAMP());
