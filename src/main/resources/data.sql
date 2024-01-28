-- Insert sample data for testing
-- INSERT INTO pet (petName, species, age, details, image, available, breed, color, gender, size, weight, ownerName, ownerContact, vaccinated, medicalHistory, dateAdded)
-- VALUES
-- ('Fluffy', 'Cat', 2, 'Adorable and friendly', NULL	, true, 'Persian', 'White', 'Female', 'Small', 3.5, 'John Doe', 'john@example.com', true, 'Up-to-date on vaccinations', '2024-01-26 12:00:00'),
-- ('Buddy', 'Dog', 3, 'Loves to play fetch', NULL, true, 'Golden Retriever', 'Golden', 'Male', 'Large', 25.0, 'Jane Smith', 'jane@example.com', false, 'No known medical issues', '2024-01-27 10:30:00');



INSERT INTO Donor ( donorName, donateAmount, donorEmail, donorNumber, address)
VALUES
    ('John Doe', 100.00, 'john@example.com', '1234567890', '123 Main St'),
    ('Jane Smith', 50.00, 'jane@example.com', '9876543210', '456 Oak St');


-- Insert sample data into the event table
INSERT INTO event (eventName, eventDate, eventTime, location, participantName, email, phone)
VALUES
    ('Pet Palooza', '2022-05-01', '15:30:00', 'Toronto', 'John Doe', 'john@example.com', '123-456-7890'),
    ('Furry Friends Fiesta', '2022-06-15', '18:00:00', 'Brampton', 'Jane Smith', 'jane@example.com', '987-654-3210'),
    ('Paws in the Park', '2022-07-20', '12:45:00', 'Ottawa', 'Mike Johnson', 'mike@example.com', '456-789-0123');



-- Inserting users with email parameter
INSERT INTO SEC_User (userName, encryptedPassword, ENABLED, email)
VALUES ('Jon', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1, 'jon@example.com');

INSERT INTO SEC_User (userName, encryptedPassword, ENABLED, email)
VALUES ('Rahul', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1, 'rahul@example.com');

INSERT INTO SEC_User (userName, encryptedPassword, ENABLED, email)
VALUES ('Shammu', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1, 'shammu@example.com');

-- Inserting multiple users in a single query
INSERT INTO SEC_USER (userName, encryptedPassword, ENABLED, email)
VALUES
('Rohit', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1, 'rohit@example.com'),
('Sahil', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1, 'sahil@example.com'),
('Lallu', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1, 'lallu@example.com');



 
insert into sec_role (roleName)
values ('ROLE_GUEST');

insert into sec_role (roleName)
values ('ROLE_ADMIN');
 
insert into user_role (userId, roleId)
values (1, 2);--VENDER

insert into user_role(userId,roleId)
 values (2,1);--guest

insert into user_role (userId, roleId)
values (3, 1);--guEST

insert into user_role (userId, roleId)
values (4, 1);--guEST

insert into user_role (userId, roleId)
values (5, 1);--guEST
