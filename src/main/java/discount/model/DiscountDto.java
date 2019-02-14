package discount.model;

import io.swagger.annotations.ApiModel;

/**
 * @author aleksey.kovalenko@accenture.com
 */
@ApiModel
public class DiscountDto {

    private String play;
    private Integer discount;
    private Integer points;


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
