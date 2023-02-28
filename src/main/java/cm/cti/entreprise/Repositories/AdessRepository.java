package cm.cti.entreprise.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cm.cti.entreprise.models.Adress;
@Repository
@RepositoryRestResource(exported= false)
public interface AdessRepository  extends JpaRepository<Adress, Long>{

}
