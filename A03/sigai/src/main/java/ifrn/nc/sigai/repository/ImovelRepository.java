package ifrn.nc.sigai.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ifrn.nc.sigai.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>{
    List<Imovel> findByEndereco(String endereco);
    List<Imovel> findByValorAluguelLessThan(Double valor);
    List<Imovel> findByEnderecoContainingIgnoreCase(String trecho);
}