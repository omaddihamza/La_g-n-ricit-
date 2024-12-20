package org.sid;

import org.sid.gestionproduits.Produit;
import org.sid.service.MetierProduitImpl;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;
        MetierProduitImpl m = new MetierProduitImpl();
        while (continuer) {
            System.out.println("********* Menu ***********");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");
            System.out.print("Choisissez une option: ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                  System.out.println("Liste des produits: \n"+ m.getAll());
                    break;
                case 2:
                    System.out.println("Entrez l'ID du produit :");
                    int idProduit = scanner.nextInt();
                     Produit p = m.findById(idProduit);
                     System.out.println(p);
                    break;
                case 3:
                    System.out.println("Entrez le nom :");
                    String nom = scanner.next();
                    System.out.println("Entrez la marque :");
                    String marque = scanner.next();
                    System.out.println("Entrez le prix :");
                    double prix = scanner.nextDouble();
                    System.out.println("Entrez la description :");
                    String description = scanner.next();
                    System.out.println("Entrez le nombre en stock :");
                    int stock = scanner.nextInt();


                    m.add(new Produit( nom, marque, prix, description,stock ));
                    break;
                case 4:
                    System.out.println("Entrez l'ID du produit :");
                    idProduit = scanner.nextInt();
                    m.delete(idProduit);

                    break;
                case 5:
                    continuer = false;
                    System.out.println("good bye");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir entre 1 et 5.");
            }
        }

        scanner.close();
    }

}