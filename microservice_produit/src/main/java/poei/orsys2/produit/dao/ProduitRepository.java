package poei.orsys2.produit.dao;
import poei.orsys2.produit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,int> {
    List<Produit> findByTitre(String titre);
}
