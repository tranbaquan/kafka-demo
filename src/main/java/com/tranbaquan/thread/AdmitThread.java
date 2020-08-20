package com.tranbaquan.thread;

import com.tranbaquan.model.Student;
import com.tranbaquan.producer.Admission;

import java.util.Scanner;

public class AdmitThread extends Thread {

    @Override
    public void run() {
        Admission admission = new Admission();

        Scanner scanner = new Scanner(System.in);

        String input, name;
        int age;
        Student student;
        while (true) {
            System.out.print("Type 'Q' to end program or any other character to admit student: ");
            input = scanner.nextLine();

            if ("Q".equalsIgnoreCase(input)) {
                break;
            }

            System.out.print("Enter student name: ");
            name = scanner.nextLine();
            System.out.print("Enter student age: ");
            age = scanner.nextInt();
            student = new Student(name, age);

            admission.admitStudent(student);
            System.out.println("----------------------DONE----------------------");
        }

        admission.stopAdmit();
        System.exit(0);
    }
}
