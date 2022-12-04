package com.akhil.salesken.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String name;
    @Column(name = "englishmarks")
    private int englishMarks;
    @Column(name = "sciencemarks")
    private int scienceMarks;
    @Column(name = "mathmarks")
    private int mathMarks;
    @Column(name = "semester")
    private int semester;

    public Student() {
    }

    public Student(String name, int englishMarks, int scienceMarks, int mathMarks, int semester) {
        this.id = id;
        this.name = name;
        this.englishMarks = englishMarks;
        this.scienceMarks = scienceMarks;
        this.mathMarks = mathMarks;
        this.semester = semester;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(int englishMarks) {
        this.englishMarks = englishMarks;
    }

    public int getScienceMarks() {
        return scienceMarks;
    }

    public void setScienceMarks(int scienceMarks) {
        this.scienceMarks = scienceMarks;
    }

    public int getMathMarks() {
        return mathMarks;
    }

    public void setMathMarks(int mathMarks) {
        this.mathMarks = mathMarks;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
