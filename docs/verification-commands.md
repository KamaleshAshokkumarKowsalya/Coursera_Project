# Verification Commands

## SQL

```sql
SHOW TABLES;
SELECT * FROM patients LIMIT 5;
CALL GetDailyAppointmentReportByDoctor('2025-05-22');
CALL GetDoctorWithMostPatientsByMonth(2025, 5);
CALL GetDoctorWithMostPatientsByYear(2025);
```

## Curl

```bash
curl http://localhost:8081/api/doctors
curl "http://localhost:8081/api/doctors?specialization=Cardiologist&time=09:00"
curl http://localhost:8081/api/appointments/patient/1
```

## Submission Notes

- The public issue link must be created in GitHub after pushing the repository.
- The screenshot deliverables should be captured from the role-specific frontend pages in `frontend/`.