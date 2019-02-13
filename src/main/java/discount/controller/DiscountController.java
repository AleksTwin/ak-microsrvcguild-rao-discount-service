package discount.controller;

import java.util.List;

import discount.model.DiscountDTO;
import discount.service.DiscountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public List<DiscountDTO> getDisocunts(@RequestParam(value = "belowPoints", required = false) Integer belowPoints) {
        return service.getDiscounts(belowPoints);
    }
}
