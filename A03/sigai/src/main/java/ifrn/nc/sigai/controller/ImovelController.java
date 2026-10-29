package ifrn.nc.sigai.controller;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ifrn.nc.sigai.dto.ImovelRequestDTO;
import ifrn.nc.sigai.dto.ImovelResponseDTO;
import ifrn.nc.sigai.service.ImovelService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/imoveis")
public class ImovelController{

    private final ImovelService service;

    public ImovelController(ImovelService service){
        this.service = service;
    }

    @GetMapping("/listar")
    public List<ImovelResponseDTO> listar(@RequestParam (required = false) String endereco, @RequestParam(required = false) Double valorAluguel){
        return service.listar(endereco, valorAluguel);
    }

    @GetMapping("/{id}")
    public ImovelResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<ImovelResponseDTO> criar(@Valid @RequestBody ImovelRequestDTO dto){
        ImovelResponseDTO imovel = service.criar(dto);
        URI uri = URI.create("/imoveis/" + imovel.getId());
        return ResponseEntity.created(uri).body(imovel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImovelResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ImovelRequestDTO dto){
        ImovelResponseDTO atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}