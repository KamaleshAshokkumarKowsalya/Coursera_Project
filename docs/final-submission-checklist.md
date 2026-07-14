# Final Submission Checklist

## GitHub links to provide

- Issues with Admin, Doctor, and Patient user stories: create GitHub issues from `docs/issues.md`
- `schema-design.md`: root file in this repository
- `backend/src/main/java/com/smartclinic/entity/Doctor.java`
- `backend/src/main/java/com/smartclinic/entity/Appointment.java`
- `backend/src/main/java/com/smartclinic/web/DoctorController.java`
- `backend/src/main/java/com/smartclinic/service/AppointmentService.java`
- `backend/src/main/java/com/smartclinic/web/PrescriptionController.java`
- `backend/src/main/java/com/smartclinic/repository/PatientRepository.java`
- `backend/src/main/java/com/smartclinic/service/TokenService.java`
- `backend/src/main/java/com/smartclinic/service/DoctorService.java`
- `Dockerfile`
- `.github/workflows/ci.yml`

## Screenshot pages

- Admin login: `frontend/admin-login.html`
- Doctor login: `frontend/doctor-login.html`
- Patient login: `frontend/patient-login.html`
- Admin adding doctor: `frontend/admin-add-doctor.html`
- Patient searching doctor: `frontend/patient-search-doctor.html`
- Doctor viewing appointments: `frontend/doctor-appointments.html`

## Notes

- Run the backend on port 8081 if port 8080 is already taken.
- Seed data is loaded from `backend/src/main/resources/data.sql`.