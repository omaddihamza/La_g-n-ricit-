package org.sid.service;

import org.sid.gestionproduits.Produit;

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    List<Produit> produits = new ArrayList<>();
    @Override
    public void add(Produit o) {
        produits.add(o);
        System.out.println("Produit ajouté ");
    }

    @Override
    public List<Produit> getAll() {
        return  produits;
    }

    @Override
    public Produit findById(long id) {
        for(Produit p : produits) {
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Produit produit = findById(id);
        if (produit != null) {
            produits.remove(produit);
            System.out.println("Produit supprimé : " + produit);
        } else {
            System.out.println("Produit introuvable avec l'ID : " + id);
        }
    }


}
