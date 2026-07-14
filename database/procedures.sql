DELIMITER $$

CREATE PROCEDURE GetDailyAppointmentReportByDoctor(IN report_date DATE)
BEGIN
    SELECT d.full_name AS doctor_name,
           a.appointment_date,
           COUNT(*) AS total_appointments
    FROM appointments a
    JOIN doctors d ON d.id = a.doctor_id
    WHERE a.appointment_date = report_date
    GROUP BY d.full_name, a.appointment_date
    ORDER BY d.full_name;
END$$

CREATE PROCEDURE GetDoctorWithMostPatientsByMonth(IN report_year INT, IN report_month INT)
BEGIN
    SELECT d.full_name AS doctor_name,
           COUNT(DISTINCT a.patient_id) AS patient_count
    FROM appointments a
    JOIN doctors d ON d.id = a.doctor_id
    WHERE YEAR(a.appointment_date) = report_year
      AND MONTH(a.appointment_date) = report_month
    GROUP BY d.full_name
    ORDER BY patient_count DESC
    LIMIT 1;
END$$

CREATE PROCEDURE GetDoctorWithMostPatientsByYear(IN report_year INT)
BEGIN
    SELECT d.full_name AS doctor_name,
           COUNT(DISTINCT a.patient_id) AS patient_count
    FROM appointments a
    JOIN doctors d ON d.id = a.doctor_id
    WHERE YEAR(a.appointment_date) = report_year
    GROUP BY d.full_name
    ORDER BY patient_count DESC
    LIMIT 1;
END$$

DELIMITER ;