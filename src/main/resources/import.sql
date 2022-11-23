INSERT INTO Role (id, roleName)
VALUES ('1', 'ADMIN');

INSERT INTO Role (id, roleName)
VALUES ('2', 'MITGLIED');

INSERT INTO Role (id, roleName)
VALUES ('3', 'BESUCHER');

INSERT INTO AppUser (id, username, password, role_id, entries)
VALUES ('1', 'tpiana', '123wert456', '1', '80');

INSERT INTO AppUser (id, username, password, role_id, entries)
VALUES ('5', 'jsingh', '876iuz543', '2', '2' '4');

INSERT INTO AppUser (id, username, password, role_id, entries)
VALUES ('10', 'jvall', 'dfgert345', '3', '');

INSERT INTO Entry (id, bookingTime, bookingText, bookingStatus)
VALUES ('4', '14:00', 'Buchung für User jsingh', 'PROCESSING');

INSERT INTO Entry (id, bookingTime, bookingText, bookingStatus)
VALUES ('80', '08:00', 'Buchung für User tpiana', 'CONFIRMED');

INSERT INTO Entry (id, bookingTime, bookingText, bookingStatus)
VALUES ('2', '17:30', 'Buchung für User jsingh', 'DENIED');