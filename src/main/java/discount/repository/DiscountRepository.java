package discount.repository;

import java.util.List;

import discount.repository.domain.DiscountDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author aleksey.kovalenko@accenture.com
 */
@Repository
public interface DiscountRepository extends CrudRepository<DiscountDomain, Long> {

    @Query(
            value = "SELECT * FROM Discount d WHERE d.points < ?1 ORDER BY points ASC LIMIT 10",
            nativeQuery = true
    )
    List<DiscountDomain> findAllByPointsBelowLowest10(Integer pointsBelow);
}
