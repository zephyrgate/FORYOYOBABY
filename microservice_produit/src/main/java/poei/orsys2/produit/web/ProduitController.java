package poei.orsys2.produit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import poei.orsys2.produit.dao.ProduitRepository;
import poei.orsys2.produit.entities.Produit;

import java.util.List;

@Controller
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;

    ///get all produits
    @RequestMapping(value={"/produits","/"},method = RequestMethod.GET)
    public String  getProduit(Model model) {
        List<Produit> listProduits=produitRepository.findAll();
        model.addAttribute("listPrd",listProduits);
        model.addAttribute("produit", new Produit());
        return "produits";
    }
    @RequestMapping(value="/produits/edit",method =RequestMethod.GET)
    public String editProduit(Model model,@RequestParam int id) {
        // Produit prd = produitRepository.findById(id);
//        System.out.print(prd);
//        model.addAttribute("prd", prd);
        return "produits";
    }

    //add a new enterprise
    @RequestMapping(value="/produits/create",method =RequestMethod.POST)
    public String  newProduit(Model model,Produit prd) {

            produitRepository.save(prd);
            System.err.println("the product has been added");
            return "redirect:/produits";
        }

    @RequestMapping(value="/produits/update",method =RequestMethod.POST)
    public String  updateProduit(@ModelAttribute(value="prd") Produit prd) {
        produitRepository.save(prd);
        return "redirect:/produits";
    }
    @RequestMapping(value="/produits/delete",method =RequestMethod.GET)
    public String  deleteProduit(@RequestParam int id) {
        produitRepository.deleteById(id);
        return "redirect:/produits";
    }
    @RequestMapping(value="/produits/search",method = RequestMethod.GET)
    public String searchProducts(@RequestParam String keyword, Model model){
        //produitRepository
        System.err.println(keyword);
        List<Produit> produits = produitRepository.searchProduit(keyword);
        System.out.println(produits);
        model.addAttribute("listPrd", produits);
        model.addAttribute("produit", new Produit());
        model.addAttribute("keyword", keyword);
        return "produits";
    }

}
