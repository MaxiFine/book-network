package com.alibou.book.book;

import com.alibou.book.feedback.Feedback;
import com.alibou.book.history.BookTransactionHistory;
import com.alibou.book.user.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Setter
@Getter
@SuperBuilder  // to build from parent class
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@EntityListeners(AuditingEntityListener.class)
public class Book extends BaseEntity{

    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean shareable;

    // mapping btn user and book
    @ManyToOne
    @JoinColumn(name = "owner_id")  // mapping for book and user
    private User owner;

    // mapping btn feedback and book
    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    // association mapping btn bookHistory
    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

    // THE USER ID WILL BE USED TO DETERMINE WHO DID WHAT AND
    // WHO DID THAT.

    // THIS METHOD ENABLES THE CALCULATION OF RATINGS FROM USERS
    @Transient
    public double getRate(){
        if (feedbacks == null || feedbacks.isEmpty()){
            return 0.0;
        }
        var rate = this.feedbacks.stream()
                .mapToDouble(Feedback::getNote)
                .average()
                .orElse(0.0);
        double roundedRate;
        roundedRate = Math.round(rate * 10.0) / 10.0;
        return roundedRate;
    }


}
