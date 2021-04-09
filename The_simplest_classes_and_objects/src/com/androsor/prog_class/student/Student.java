package com.androsor.prog_class.student;

import java.util.Arrays;
import java.util.Objects;

public class Student {

    private String fullName;
    private int group;
    private int[] progress;

    public Student(String fullName, int group, int[] progress) {
        this.fullName = fullName;
        this.group = group;
        this.progress = progress;
    }

    public String getFullName() {
        return fullName;
    }

    public int getGroup() {
        return group;
    }

    public int[] getProgress() {
        return progress;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setProgress(int[] progress) {
        this.progress = progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return group == student.group && Objects.equals(fullName, student.fullName) && Arrays.equals(progress, student.progress);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fullName, group);
        result = 31 * result + Arrays.hashCode(progress);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Студент ");
        stringBuilder.append(fullName).append(" ");
        stringBuilder.append("группа ").append(group).append("; ");
        stringBuilder.append("успеваемость ").append(Arrays.toString(progress));
        return stringBuilder.toString();
    }
}
