package pl.homar.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Konrad on 8/20/2014.
 */
@Entity
@Table(name="questions")
public class Question {

    private Long id;

    private String text;

    private Set<Answer> answers = new HashSet<Answer>();

    private Set<Test> tests = new HashSet<Test>();

    @Id
    @GeneratedValue
    @Column(name="question_id", unique=true, nullable=false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="text",nullable=false)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="question")
    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    @ManyToMany(fetch=FetchType.EAGER, mappedBy="questions")
    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!id.equals(question.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
