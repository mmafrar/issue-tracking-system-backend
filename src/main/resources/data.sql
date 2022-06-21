INSERT INTO developer (developer_id, name) VALUES (1, 'Developer 1');
INSERT INTO developer (developer_id, name) VALUES (2, 'Developer 2');
INSERT INTO developer (developer_id, name) VALUES (3, 'Developer 3');

INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 1, 'Story Title 1', 'Story Description 1', 0, 2, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 2, 'Story Title 2', 'Story Description 2', 0, 3, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 3, 'Story Title 3', 'Story Description 3', 0, 5, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 4, 'Story Title 4', 'Story Description 4', 0, 8, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 5, 'Story Title 5', 'Story Description 5', 0, 8, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 6, 'Story Title 6', 'Story Description 6', 0, 8, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 7, 'Story Title 7', 'Story Description 7', 0, 8, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 8, 'Story Title 8', 'Story Description 8', 0, 5, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 9, 'Story Title 9', 'Story Description 9', 0, 3, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, estimated_point_value, created_date) VALUES ('Story', 10, 'Story Title 10', 'Story Description 10', 0, 2, CURRENT_TIMESTAMP());

INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 11, 'Bug Title 1', 'Bug Description 1', 0, 1, 1, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 12, 'Bug Title 2', 'Bug Description 2', 0, 1, 2, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 13, 'Bug Title 3', 'Bug Description 3', 0, 1, 3, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 14, 'Bug Title 4', 'Bug Description 4', 0, 1, 2, CURRENT_TIMESTAMP());
INSERT INTO issue (dtype, issue_id, title, description, status, priority, assignee_developer_id, created_date) VALUES ('Bug', 15, 'Bug Title 5', 'Bug Description 5', 0, 1, 1, CURRENT_TIMESTAMP());
