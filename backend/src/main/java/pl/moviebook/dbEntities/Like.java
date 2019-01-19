package pl.moviebook.dbEntities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`29209262_bd2`.`Like`")
public class Like implements Serializable {

    private static final long serialVersionUID = 110120191L;

	@Id
    @Column(name="Review_idReview")
    private int Review_idReview;

    @Id
    @Column(name="User_login")
    private String User_login;
    
    @Column(name="date")
    private Date date;

    /**
     * @return the review_idReview
     */
    public int getReview_idReview() {
        return Review_idReview;
    }

    /**
     * @param review_idReview the review_idReview to set
     */
    public void setReview_idReview(int review_idReview) {
        Review_idReview = review_idReview;
    }

    /**
     * @return the user_login
     */
    public String getUser_login() {
        return User_login;
    }

    /**
     * @param user_login the user_login to set
     */
    public void setUser_login(String user_login) {
        User_login = user_login;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
