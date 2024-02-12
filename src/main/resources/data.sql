INSERT INTO meal_entity (id, title, intro_text, ingredients_as_json, description) VALUES ('eebff519-597e-4c00-afc5-c7f1f4f79de1', 'Nasi Goreng', 'A classic dish. Add in any chopped veggies or some tofu.', '[]', 'description')
INSERT INTO meal_entity (id, title, intro_text, ingredients_as_json, description) VALUES ('eebff519-597e-4c00-afc5-c7f1f4f79de2', 'Gado Gado', 'Beautifully sweet. Vegetables made with peanut sauce - an all time classic dish.', '[]', 'description')
INSERT INTO meal_entity (id, title, intro_text, ingredients_as_json, description) VALUES ('eebff519-597e-4c00-afc5-c7f1f4f79de3', 'Risotto', 'When rice meets vegetables and flavors.', '[]', 'description')

INSERT INTO photo_camera_motive_entity (id, type, jpg_small, jpg_medium, jpg_large) VALUES ('eebff519-597e-4c00-afc5-c7f1f4f79de5', 'title', FILE_READ('classpath:static/img/example300x200.jpg'), FILE_READ('classpath:static/img/example600x400.jpg'), FILE_READ('classpath:static/img/example1200x800.jpg'))

INSERT INTO meal_to_photo_motive_im (photo_id, meal_id) VALUES('eebff519-597e-4c00-afc5-c7f1f4f79de5', 'eebff519-597e-4c00-afc5-c7f1f4f79de1')
INSERT INTO meal_to_photo_motive_im (photo_id, meal_id) VALUES('eebff519-597e-4c00-afc5-c7f1f4f79de5', 'eebff519-597e-4c00-afc5-c7f1f4f79de2')
INSERT INTO meal_to_photo_motive_im (photo_id, meal_id) VALUES('eebff519-597e-4c00-afc5-c7f1f4f79de5', 'eebff519-597e-4c00-afc5-c7f1f4f79de3')
