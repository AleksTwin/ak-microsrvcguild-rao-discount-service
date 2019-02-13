package discount.repository;

import discount.repository.domain.DiscountDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author aleksey.kovalenko@accenture.com
 */
@Repository
public interface DiscountRepository extends CrudRepository<DiscountDomain, Long> {

//    DiscountDomain findAllBelowPoints(Integer points);
}
