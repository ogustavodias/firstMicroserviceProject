package com.gudias.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Cliente", description = "Cliente")
public class Customer {

  @Id
  @Schema(description = "Identificador único")
  private String id;

  @NotNull
  @Size(min = 1, max = 50)
  @Schema(description = "Nome", minLength = 1, maxLength = 50, nullable = false)
  private String name;

  @NotNull
  @Indexed(unique = true, background = true)
  @Schema(description = "CPF", nullable = false)
  private String cpf;

  @NotNull
  @Schema(description = "Telefone", nullable = false)
  private String tel;

  @NotNull
  @Schema(description = "E-mail", nullable = false)
  private String email;

}
