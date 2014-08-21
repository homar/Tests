package pl.homar.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Konrad on 8/21/2014.
 */
@Entity
@Table(name="tests")
public class Test {
    private Long id;
    private Set<Question> questions = new HashSet<Question>();

    @Id
    @GeneratedValue
    @Column(name="test_id", nullable=false, unique=true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="tests_questions", joinColumns={
            @JoinColumn(name="test_id", nullable=false, updatable=false)},
            inverseJoinColumns={ @JoinColumn(name="question_id",
            nullable=false, updatable=false)
    })
    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
