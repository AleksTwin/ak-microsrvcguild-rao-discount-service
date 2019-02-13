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
        discountRepository.save(new DiscountDomain("Theater Play 1", 20,35));
        discountRepository.save(new DiscountDomain("Theater Play 1", 15,22));
        discountRepository.save(new DiscountDomain("Theater Play 1", 10,10));

        discountRepository.save(new DiscountDomain("Theater Play 2", 20,40));
        discountRepository.save(new DiscountDomain("Theater Play 2", 15,25));
        discountRepository.save(new DiscountDomain("Theater Play 2", 10,12));

        discountRepository.save(new DiscountDomain("Theater Play 3", 20,50));
        discountRepository.save(new DiscountDomain("Theater Play 3", 15,35));
        discountRepository.save(new DiscountDomain("Theater Play 3", 10,23));

        discountRepository.save(new DiscountDomain("Theater Play 4", 20,30));
        discountRepository.save(new DiscountDomain("Theater Play 4", 15,17));
        discountRepository.save(new DiscountDomain("Theater Play 4", 10,9));

        discountRepository.save(new DiscountDomain("Theater Play 5", 20,60));
        discountRepository.save(new DiscountDomain("Theater Play 5", 15,35));
        discountRepository.save(new DiscountDomain("Theater Play 5", 10,20));
    }

    public List<DiscountDTO> getDiscountsByPointsBelow(Integer pointsBelow) {
        return mapQueryResult(discountRepository.findAllByPointsBelowLowest10(pointsBelow));
    }

    public List<DiscountDTO> getDiscounts() {
        return mapQueryResult(Optional.of(discountRepository.findAll()).get());
    }

    private List<DiscountDTO> mapQueryResult(Iterable<DiscountDomain> queryResult) {
        ArrayList<DiscountDTO> arrayList = Lists.newArrayList();
        queryResult.forEach((domain -> {
            DiscountDTO discountDTO = new DiscountDTO();
            discountDTO.setPlay(domain.getPlay());
            discountDTO.setDiscount(domain.getDiscount());
            discountDTO.setPoints(domain.getPoints());
            arrayList.add(discountDTO);
        }));

        return arrayList;
    }
}
