package poei.orsys2.produit.dao;
import poei.orsys2.produit.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
