CREATE TABLE t_demo_demo_table(
  id INTEGER PRIMARY KEY auto_increment,
  key varchar(10),
  value VARCHAR(10),
  updatedAt Date,
  createdAt Date DEFAULT current_time()
);