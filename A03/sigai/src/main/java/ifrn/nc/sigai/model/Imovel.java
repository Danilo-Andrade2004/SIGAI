package ifrn.nc.sigai.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "imoveis")
public class Imovel {

    public Imovel(Long id, String endereco, Double valorAluguel, String descricao) {
        this.id = id;
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;
    private Double valorAluguel;
    private String descricao;

    @OneToMany(mappedBy = "imovel")
    private List<Foto> fotos = new ArrayList<>();
}