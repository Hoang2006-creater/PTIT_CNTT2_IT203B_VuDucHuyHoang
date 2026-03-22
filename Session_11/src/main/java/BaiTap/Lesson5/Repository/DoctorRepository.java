package BaiTap.Lesson5.Repository;

import BaiTap.Lesson5.Entity.Doctor;

import java.util.List;

public interface DoctorRepository {
    List<Doctor> getAll();
    boolean addDoctor(Doctor doctor);
    void countBySpecialty();
}