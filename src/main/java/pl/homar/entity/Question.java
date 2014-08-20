package pl.homar.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 8/20/2014.
 */
@Entity
@Table(name="questions")
public class Question {

    private Long id;

    private String text;

    private List<Answer> answers = new ArrayList<Answer>();

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
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
