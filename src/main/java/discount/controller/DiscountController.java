package discount.controller;

import java.util.List;

import discount.model.DiscountDTO;
import discount.service.DiscountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aleksey.kovalenko@accenture.com
 */
@RestController
@RequestMapping("/v1/discounts")
@Api(tags = "Discount")
public class DiscountController {

    @Autowired
    private DiscountService service;


    @GetMapping(produces = "application/json")
    public Discounts getDisocunts(@RequestParam(value = "belowPoints", required = false) Integer belowPoints) {
        List<DiscountDTO> discountDTOS = belowPoints == null || belowPoints == 0 ? service.getDiscounts() : service.getDiscountsByPointsBelow(belowPoints);
        return new Discounts(discountDTOS.size(), discountDTOS);
    }

    private class Discounts {
        private Integer availableDiscounts;
        private List<DiscountDTO> discountDTOS;

        Discounts(Integer availableDiscounts, List<DiscountDTO> discountDTOS) {
            this.availableDiscounts = availableDiscounts;
            this.discountDTOS = discountDTOS;
        }

        public Integer getAvailableDiscounts() {
            return availableDiscounts;
        }

        public List<DiscountDTO> getDiscountDTOS() {
            return discountDTOS;
        }
    }
}
