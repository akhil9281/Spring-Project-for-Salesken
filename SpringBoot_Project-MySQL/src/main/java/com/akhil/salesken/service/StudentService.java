package com.akhil.salesken.service;

import com.akhil.salesken.entity.Student;
import com.akhil.salesken.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public Student getStudent(Long id) {
        return repo.getReferenceById(id);
    }
    public Student updateStudent(Student student) {
        return repo.save(student);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public List<Float> averageMarks() {
        float ans1 = 0, ans2 = 0, count1 = 0, count2 = 0;
        int sem = 1;
        List<Student> list= repo.findAll();
        for (Student student : list) {
            if (student.getSemester() == sem) {
                ans1 = ans1+ student.getEnglishMarks() + student.getMathMarks() +
                        student.getScienceMarks();
                count1++;
            }
        }
        ans1 /= count1;
        sem++;
        for (Student student : list) {
            if (student.getSemester() == sem) {
                ans2 = ans2+ student.getEnglishMarks() + student.getMathMarks() +
                        student.getScienceMarks();
                count2++;
            }
        }
        ans1 /= count2;
        List<Float> ans = new ArrayList<>();
        ans.add(ans1/3);
        ans.add(ans2/3);
        return ans;
    }

    /*
    public float studentAvgMarks(Long id) {
        Optional<Student> student = repo.findById(id);
        int ans = student.get().getEnglishMarks() +
                student.get().getScienceMarks() + student.get().getMathMarks();
        return ans/3;
    }*/

}