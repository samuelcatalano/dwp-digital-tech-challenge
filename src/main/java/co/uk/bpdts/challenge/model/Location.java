package co.uk.bpdts.challenge.model;

import co.uk.bpdts.challenge.model.base.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Samuel Catalano
 * @since Jul 10, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location extends BaseBean {

    private Double latitude;
    private Double longitude;
}