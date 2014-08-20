package pl.homar.entity;

import javax.persistence.*;

/**
 * Created by Konrad on 8/20/2014.
 */
@Entity
@Table(name="answers")
public class Answer {

    private Long id;
    private String text;
    private Question question;

    @Id
    @GeneratedValue
    @Column(name="answer_id", unique=true, nullable=false)
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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="question_id", nullable=false)
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
