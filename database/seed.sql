INSERT INTO doctors (full_name, email, specialization, phone_number) VALUES
('Dr. Emily Adams', 'dr.adams@example.com', 'Cardiologist', '555-1001'),
('Dr. Mark Johnson', 'dr.johnson@example.com', 'Neurologist', '555-1002'),
('Dr. Sarah Lee', 'dr.lee@example.com', 'Orthopedist', '555-1003');

INSERT INTO patients (full_name, email, gender, date_of_birth) VALUES
('John Smith', 'john.smith@example.com', 'Male', '1990-04-12'),
('Ava Green', 'ava.green@example.com', 'Female', '1988-09-22');

INSERT INTO appointments (doctor_id, patient_id, appointment_date, appointment_time, status) VALUES
(1, 1, '2025-05-22', '09:00:00', 'SCHEDULED'),
(2, 1, '2025-05-23', '10:00:00', 'COMPLETED');