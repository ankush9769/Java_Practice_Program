create database flightBookingsystem;
use flightBookingsystem;

INSERT INTO flight_tickets (flightno, passangername, traveldate) VALUES
('AI101', 'Rahul Sharma', '2026-09-10'),
('6E202', 'Priya Patel', '2026-09-15'),
('UK303', 'Amit Kumar', '2026-09-20'),
('SG404', 'Sneha Singh', '2026-09-25'),
('AI505', 'Vikram Mehta', '2026-10-01');

show tables;
select * from flight_tickets;