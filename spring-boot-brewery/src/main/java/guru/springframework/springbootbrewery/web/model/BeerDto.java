package guru.springframework.springbootbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private BeerStyleEnum beerStyle;

    @Positive
    private Long upc;

    @Positive
    @NotBlank
    private BigDecimal price;

    @Positive
    @NotBlank
    private Integer qtyInHand;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModified;
}
