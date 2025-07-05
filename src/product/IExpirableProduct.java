package product;

import java.time.LocalDate;

public interface IExpirableProduct extends IProduct {
    LocalDate getExpiryDate();
    boolean isExpired();
}
