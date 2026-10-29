package ifrn.nc.sigai.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ifrn.nc.sigai.dto.FotoRequestDTO;
import ifrn.nc.sigai.dto.FotoResponseDTO;
import ifrn.nc.sigai.exception.FotoNaoEncontradaException;
import ifrn.nc.sigai.exception.ImovelNaoEncontradoException;
import ifrn.nc.sigai.model.Foto;
import ifrn.nc.sigai.model.Imovel;
import ifrn.nc.sigai.repository.FotoRepository;
import ifrn.nc.sigai.repository.ImovelRepository;

@Service
public class FotoService{

    private final FotoRepository repository;
    private final ImovelRepository imovelRepository;

    public FotoService(FotoRepository repository, ImovelRepository imovelRepository) {
        this.repository = repository;
        this.imovelRepository = imovelRepository;
    }

    public FotoResponseDTO criar(FotoRequestDTO dto){
        Foto salvo = repository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }

    public List<Foto> listar(){
        return repository.findAll();
    }

    public FotoResponseDTO buscarPorId(Long id){
        Foto foto = repository.findById(id).orElseThrow(() -> new FotoNaoEncontradaException(id));
        return toResponseDTO(foto);
    }

    public FotoResponseDTO atualizar(Long id, FotoRequestDTO dto){
        Foto foto = repository.findById(id).orElseThrow(() -> new FotoNaoEncontradaException(id));

        dto.setImovelId(dto.getImovelId());
        dto.setUrl(dto.getUrl());
        dto.setLegenda(dto.getLegenda());
        dto.setPrincipal(dto.getPrincipal());

        Foto atualizado = repository.save(foto);
        return toResponseDTO(atualizado);
    }

    public List<FotoResponseDTO> listar(Long imovelId) {
        List<Foto> fotos = repository.findAll();
        return fotos.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public void deletar(Long id){
        Foto foto = repository.findById(id).orElseThrow(() -> new FotoNaoEncontradaException(id));
        repository.deleteById(id);
    }

    private Foto toEntity(FotoRequestDTO dto){
        Imovel imovel = imovelRepository.findById(dto.getImovelId()).orElseThrow(()-> new ImovelNaoEncontradoException(dto.getImovelId()));
        return new Foto(null, imovel, dto.getUrl(), dto.getLegenda(), dto.getPrincipal());
    }

    private FotoResponseDTO toResponseDTO(Foto foto){
        Imovel imovel = foto.getImovel();
        long imovelId = imovel.getId();
        return new FotoResponseDTO(foto.getId(), imovelId, foto.getUrl(), foto.getLegenda(), foto.getPrincipal());
    }
}