package com.gudias.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Produto", description = "Produto")
public class Product {

  @Id
  @Schema(description = "Identificador único")
  private String id;

  @NotNull
  @Size(min = 1, max = 50)
  @Schema(description = "Nome", minLength = 1, maxLength = 50, nullable = false)
  private String name;

  @NotNull
  @Schema(description = "Marca", nullable = false)
  private String brand;

}
