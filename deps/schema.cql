CREATE keyspace triggerise with replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE triggerise.product(code text, name text, price double, PRIMARY KEY(code));

INSERT INTO triggerise.product(code, name, price) VALUES ('TICKET', 'Triggerise Ticket ', 5.00);
INSERT INTO triggerise.product(code, name, price) VALUES ('HOODIE', 'Triggerise Hoodie ', 20.00);
INSERT INTO triggerise.product(code, name, price) VALUES ('HAT', 'Triggierse Hat', 7.50);
