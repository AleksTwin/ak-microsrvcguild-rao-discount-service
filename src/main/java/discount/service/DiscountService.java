package discount.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import discount.model.DiscountDTO;
import discount.repository.DiscountRepository;
import discount.repository.domain.DiscountDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author aleksey.kovalenko@accenture.com
 */
@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;


    public void initialize() {
        discountRepository.save(new DiscountDomain("Theater Play 1", 10,50));
        discountRepository.save(new DiscountDomain("Theater Play 1", 20,80));

        discountRepository.save(new DiscountDomain("Theater Play 2", 10,100));
        discountRepository.save(new DiscountDomain("Theater Play 2", 20,150));
    }

    public List<DiscountDTO> getDiscounts(Integer belowPoints) {
//        Optional<DiscountDomain> ld = Optional.ofNullable(discountRepository.findAllBelowPoints(belowPoints));
        Optional<Iterable<DiscountDomain>> all = Optional.of(discountRepository.findAll());

        ArrayList<DiscountDTO> arrayList = Lists.newArrayList();
        all.ifPresent((list) -> list.forEach((domain -> {
            DiscountDTO discountDTO = new DiscountDTO();
            discountDTO.setPlay(domain.getPlay());
            discountDTO.setDiscount(domain.getDiscount());
            discountDTO.setPoints(domain.getPoints());
            arrayList.add(discountDTO);
        })));

        return arrayList;
    }
}
