INSERT INTO doctors (id, full_name, email, specialization, phone_number) VALUES
(1, 'Dr. Emily Adams', 'dr.adams@example.com', 'Cardiologist', '555-1001'),
(2, 'Dr. Mark Johnson', 'dr.johnson@example.com', 'Neurologist', '555-1002'),
(3, 'Dr. Sarah Lee', 'dr.lee@example.com', 'Orthopedist', '555-1003');

INSERT INTO doctor_available_times (doctor_id, available_time) VALUES
(1, '09:00'),
(1, '10:00'),
(1, '11:00'),
(2, '10:00'),
(2, '11:00'),
(3, '09:00'),
(3, '14:00');

INSERT INTO patients (id, full_name, email, gender, date_of_birth) VALUES
(1, 'John Smith', 'john.smith@example.com', '555-2001', 'Male', '1990-04-12'),
(2, 'Ava Green', 'ava.green@example.com', '555-2002', 'Female', '1988-09-22'),
(3, 'Noah Brown', 'noah.brown@example.com', '555-2003', 'Male', '1992-12-15'),
(4, 'Mia White', 'mia.white@example.com', '555-2004', 'Female', '1995-07-01'),
(5, 'Lucas Gray', 'lucas.gray@example.com', '555-2005', 'Male', '1989-03-20');

INSERT INTO users (id, username, password, email, role, enabled, created_at) VALUES
(1, 'admin', 'admin123456', 'admin@smartclinic.com', 'ADMIN', true, CURRENT_TIMESTAMP()),
(2, 'dr.adams', 'doctor123456', 'dr.adams@example.com', 'DOCTOR', true, CURRENT_TIMESTAMP()),
(3, 'john.smith', 'patient123456', 'john.smith@example.com', 'PATIENT', true, CURRENT_TIMESTAMP());

INSERT INTO appointments (id, doctor_id, patient_id, appointment_date, appointment_time, status) VALUES
(1, 1, 1, '2025-05-22', '2025-05-22 09:00:00', 'SCHEDULED'),
(2, 2, 1, '2025-05-23', '2025-05-23 10:00:00', 'COMPLETED'),
(3, 1, 2, '2025-05-24', '2025-05-24 11:00:00', 'SCHEDULED');