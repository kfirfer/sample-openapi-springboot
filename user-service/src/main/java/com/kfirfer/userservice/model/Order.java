package com.kfirfer.userservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

/**
 * Order
 */

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-30T10:42:46.771587-01:00[Atlantic/Azores]")


public class Order {

    @JsonProperty("id")

    private Long id;


    @JsonProperty("petId")

    private Long petId;


    @JsonProperty("quantity")

    private Integer quantity;


    @JsonProperty("shipDate")

    private Date shipDate;

    /**
     * Order Status
     */
    public enum StatusEnum {
        PLACED("placed"),

        APPROVED("approved"),

        DELIVERED("delivered");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }


    @JsonProperty("status")

    private StatusEnum status;


    @JsonProperty("complete")

    private Boolean complete;


    public Order id(Long id) {
        this.id = id;
        return this;
    }


    /**
     * Get id
     *
     * @return id
     */
    @Schema(example = "10", description = "")


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Order petId(Long petId) {
        this.petId = petId;
        return this;
    }


    /**
     * Get petId
     *
     * @return petId
     */
    @Schema(example = "198772", description = "")


    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }


    public Order quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }


    /**
     * Get quantity
     *
     * @return quantity
     */
    @Schema(example = "7", description = "")


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Order shipDate(Date shipDate) {
        this.shipDate = shipDate;
        return this;
    }


    /**
     * Get shipDate
     *
     * @return shipDate
     */
    @Schema(description = "")

    @Valid

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }


    public Order status(StatusEnum status) {
        this.status = status;
        return this;
    }


    /**
     * Order Status
     *
     * @return status
     */
    @Schema(example = "approved", description = "Order Status")


    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }


    public Order complete(Boolean complete) {
        this.complete = complete;
        return this;
    }


    /**
     * Get complete
     *
     * @return complete
     */
    @Schema(description = "")


    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(this.id, order.id) &&
                Objects.equals(this.petId, order.petId) &&
                Objects.equals(this.quantity, order.quantity) &&
                Objects.equals(this.shipDate, order.shipDate) &&
                Objects.equals(this.status, order.status) &&
                Objects.equals(this.complete, order.complete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, petId, quantity, shipDate, status, complete);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Order {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    petId: ").append(toIndentedString(petId)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    shipDate: ").append(toIndentedString(shipDate)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

