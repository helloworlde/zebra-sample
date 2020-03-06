package io.github.helloworlde.zebra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * product
 *
 * @author
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private Long id;

    private String name;

    private Double price;

    private Integer amount;

    private Date addTime;
}