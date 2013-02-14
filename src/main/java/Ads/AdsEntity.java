package Ads;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kibromk
 * Date: 2/13/13
 * Time: 6:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "ads", schema = "", catalog = "projectpartner")
@Entity
public class AdsEntity {
    private int userId;
    public AdsEntity(){

    }
    public AdsEntity(String cnt)
    {
        this.content = cnt ;
        this.postDate=new Date(System.currentTimeMillis());

    }

    @Column(name = "UserID")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private Date postDate;

    @Column(name = "PostDate")
    @Basic
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate =  postDate;
    }

    private String content;

    @Column(name = "Content")
    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdsEntity adsEntity = (AdsEntity) o;

        if (userId != adsEntity.userId) return false;
        if (content != null ? !content.equals(adsEntity.content) : adsEntity.content != null) return false;
        if (postDate != null ? !postDate.equals(adsEntity.postDate) : adsEntity.postDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (postDate != null ? postDate.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
