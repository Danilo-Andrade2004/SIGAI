package ifrn.nc.sigai.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ifrn.nc.sigai.dto.ImovelRequestDTO;
import ifrn.nc.sigai.dto.ImovelResponseDTO;
import ifrn.nc.sigai.exception.ImovelNaoEncontradoException;
import ifrn.nc.sigai.model.Imovel;
import ifrn.nc.sigai.repository.ImovelRepository;

@Service
public class ImovelService {

    public ImovelService(ImovelRepository repository) {
        this.repository = repository;
    }

    private final ImovelRepository repository;

    public ImovelResponseDTO criar(ImovelRequestDTO dto){
        Imovel salvo = repository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }

    public List<ImovelResponseDTO> listar(String endereco, Double valorAluguel){
        List<Imovel> imoveis = repository.findAll();
        return imoveis.stream().map(this::toResponseDTO).toList();
    }

    public ImovelResponseDTO buscarPorId(Long id){
        Imovel imovel = repository.findById(id).orElseThrow(() -> new ImovelNaoEncontradoException(id));
        return toResponseDTO(imovel);
    }

    public ImovelResponseDTO atualizar(Long id, ImovelRequestDTO dto){
        Imovel imovel = repository.findById(id).orElseThrow(() -> new ImovelNaoEncontradoException(id));

        imovel.setEndereco(dto.getEndereco());
        imovel.setValorAluguel(dto.getValorAluguel());
        imovel.setDescricao(dto.getDescricao());

        Imovel atualizado = repository.save(imovel);
        return toResponseDTO(atualizado);
    }

    public void deletar(Long id){
        Imovel imovel = repository.findById(id).orElseThrow(() -> new ImovelNaoEncontradoException(id));
        repository.deleteById(id);
    }

    private Imovel toEntity(ImovelRequestDTO dto){
        return new Imovel(null, dto.getEndereco(), dto.getValorAluguel(), dto.getDescricao());
    }

    private ImovelResponseDTO toResponseDTO(Imovel imovel){
        return new ImovelResponseDTO(imovel.getId(), imovel.getEndereco(), imovel.getValorAluguel());
    }
}