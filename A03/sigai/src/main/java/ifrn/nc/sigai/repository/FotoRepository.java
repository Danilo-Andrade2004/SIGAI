package ifrn.nc.sigai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ifrn.nc.sigai.model.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
}