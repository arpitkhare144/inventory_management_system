INSERT INTO material_category (category_id, category_name) VALUES ('C001', 'Thread');
INSERT INTO material_category (category_id, category_name) VALUES ('C002', 'Cloth');
INSERT INTO material_category (category_id, category_name) VALUES ('C003', 'Button');

insert into material_type (type_id , type_name , category_id) values('T001','Silk', 'C001');
insert into material_type (type_id , type_name , category_id) values('T002','Silk', 'C002');
insert into material_type (type_id , type_name , category_id) values('T003','Linen', 'C001');
insert into material_type (type_id , type_name , category_id) values('T004','Linen', 'C002');
insert into material_type (type_id , type_name , category_id) values('T005','Silk Cotton', 'C003');	
insert into material_type (type_id , type_name , category_id) values('T006','Suit', 'C003');
insert into material_type (type_id , type_name , category_id) values('T007','Silk Cotton', 'C003');

insert into unit (unit_id , unit_name , category_id) values('U001','Metres','C001');
insert into unit (unit_id , unit_name , category_id) values('U002','Metres','C002');
insert into unit (unit_id , unit_name , category_id) values('U003','Yards','C001');
insert into unit (unit_id , unit_name , category_id) values('U004','Yards','C002');
insert into unit (unit_id , unit_name , category_id) values('U005','Kilograms','C003');