package ifrn.nc.sigai.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelResponseDTO {
    
    public ImovelResponseDTO() {
    }
    
    public ImovelResponseDTO(Long id, String endereco, Double valorAluguel) {
        this.id = id;
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
    }

    private Long id;
    private String endereco;
    private Double valorAluguel;
}