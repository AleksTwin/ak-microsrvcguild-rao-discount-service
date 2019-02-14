package discount.model;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * @author aleksey.kovalenko@accenture.com
 */
@ApiModel
public class DiscountsDto {

    private Integer availableDiscounts;
    private List<DiscountDto> discounts;

    public DiscountsDto() {
    }

    public DiscountsDto(Integer availableDiscounts, List<DiscountDto> discounts) {
        this.availableDiscounts = availableDiscounts;
        this.discounts = discounts;
    }

    public Integer getAvailableDiscounts() {
        return availableDiscounts;
    }

    public List<DiscountDto> getDiscounts() {
        return discounts;
    }
}
