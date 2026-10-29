package ifrn.nc.sigai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import jakarta.validation.constraints.Positive;

@Data
@Getter
public class ImovelRequestDTO {
    
    public ImovelRequestDTO() {
    }

    public ImovelRequestDTO(@NotBlank(message = "endereço inválido") String endereco,
            @NotNull @Positive Double valorAluguel, @Size(max = 500) String descricao) {
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
        this.descricao = descricao;
    }

    @NotBlank(message = "endereço inválido")
    private String endereco;
    
    @NotNull @Positive
    private Double valorAluguel;

    @Size(max = 500)
    private String descricao;
}