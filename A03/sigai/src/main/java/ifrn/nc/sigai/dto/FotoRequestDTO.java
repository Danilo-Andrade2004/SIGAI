package ifrn.nc.sigai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class FotoRequestDTO {

    public FotoRequestDTO() {
    }

    public FotoRequestDTO(Long imovelId, String url, String legenda, Boolean principal) {
        this.imovelId = imovelId;
        this.url = url;
        this.legenda = legenda;
        this.principal = principal;
    }

    @NotBlank(message = "imóvel inexistente")
    private Long imovelId;

    @NotNull(message = "A URL não pode ser nula")
    private String url;

    @Size(max = 200, message = "A legenda deve ter no máximo 200 caracteres")
    private String legenda;
    private Boolean principal;
}