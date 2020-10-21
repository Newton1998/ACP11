package artcode.springcollegedocker.model;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Proxy(lazy = false)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private double gpa;
    private String program;

}
