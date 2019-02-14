package discount.controller;

import java.util.List;

import discount.model.DiscountDto;
import discount.model.DiscountsDto;
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
    public DiscountsDto getDisocunts(@RequestParam(value = "belowPoints", required = false) Integer belowPoints) {
        List<DiscountDto> discountDtos = belowPoints == null ? service.getDiscounts() : service.getDiscountsByPointsBelow(belowPoints);
        return new DiscountsDto(discountDtos.size(), discountDtos);
    }
}
