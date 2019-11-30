package com.kfirfer.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * Category
 */

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-30T10:42:46.771587-01:00[Atlantic/Azores]")


public class Category {

    @JsonProperty("id")

    private Long id;


    @JsonProperty("name")

    private String name;


    public Category id(Long id) {
        this.id = id;
        return this;
    }


    /**
     * Get id
     *
     * @return id
     */
    @Schema(example = "1", description = "")


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Category name(String name) {
        this.name = name;
        return this;
    }


    /**
     * Get name
     *
     * @return name
     */
    @Schema(example = "Dogs", description = "")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(this.id, category.id) &&
                Objects.equals(this.name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Category {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

