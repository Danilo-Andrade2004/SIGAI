package ifrn.nc.sigai.controller;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ifrn.nc.sigai.dto.FotoRequestDTO;
import ifrn.nc.sigai.dto.FotoResponseDTO;
import ifrn.nc.sigai.service.FotoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    private final FotoService service;

    public FotoController(FotoService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public FotoResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<FotoResponseDTO> criar(@Valid @RequestBody FotoRequestDTO dto){
        FotoResponseDTO foto = service.criar(dto);
        URI uri = URI.create("/foto/" + foto.getId());
        return ResponseEntity.created(uri).body(foto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FotoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody FotoRequestDTO dto){
        FotoResponseDTO atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}