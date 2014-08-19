package pl.homar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Konrad on 8/19/2014.
 */
@Entity
@Table(name="tests")
public class Test {
    private Long id;

    @Id
    @GeneratedValue
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}
