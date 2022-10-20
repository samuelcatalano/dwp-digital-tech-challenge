package co.uk.bpdts.challenge.model;

import co.uk.bpdts.challenge.model.base.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class User extends BaseBean {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;
}