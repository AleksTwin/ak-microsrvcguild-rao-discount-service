package discount.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author aleksey.kovalenko@accenture.com
 */
@Entity(name = "Discount")
public class DiscountDomain {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String play;
    private Integer discount;
    private Integer points;

    public DiscountDomain() {
    }

    public DiscountDomain(String play, Integer discount, Integer points) {
        this.play = play;
        this.discount = discount;
        this.points = points;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
