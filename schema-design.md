# Schema Design

## MySQL Relational Design

### users

- `id` bigint primary key auto increment
- `username` varchar(80) unique not null
- `password` varchar(120) not null
- `email` varchar(120) unique not null
- `role` enum-like varchar column with `ADMIN`, `DOCTOR`, `PATIENT`
- `enabled` boolean not null
- `created_at` datetime not null

### doctors

- `id` bigint primary key auto increment
- `full_name` varchar(120) not null
- `email` varchar(120) unique not null
- `specialization` varchar(120) not null
- `phone_number` varchar(25)

### patients

- `id` bigint primary key auto increment
- `full_name` varchar(120) not null
- `email` varchar(120) not null
- `gender` varchar(20) not null
- `date_of_birth` date not null

### appointments

- `id` bigint primary key auto increment
- `doctor_id` foreign key to doctors.id
- `patient_id` foreign key to patients.id
- `appointment_date` date not null
- `appointment_time` time not null
- `status` varchar(30) not null

## MongoDB Document Design

### prescriptions collection

- `_id` object id
- `patientId` long
- `doctorId` long
- `medicineNames` array of strings
- `dosageInstructions` string
- `additionalNotes` string
- `createdAt` datetime

## Notes

- The backend uses JPA for relational entities and Spring Data MongoDB for prescriptions.
- Seed data is loaded from `backend/src/main/resources/data.sql` for local demos and API verification.