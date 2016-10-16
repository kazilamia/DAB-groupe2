package compteBancaire;

import java.util.Scanner;
/**
 * Created by H on 16/10/2016.
 */
public class Compte {

        private double solde;
        private String nom;
        private String numcp;
        private double intert;

        public Compte(String numcp, String nom) {
            this.numcp = numcp;
            this.nom = nom;

        }

        public void afficher(int count) {
            System.out.println("le compte " + (count + 1)
                    + " son taux intert est de " + intert + "%");

        }

        public void intert(double intert) {

            solde = solde + (solde * intert / 100) / 12;

        }

        public double getSolde() {
            return solde;
        }

        public void setSolde(double solde) {
            this.solde = solde;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public double getIntert() {
            return intert;
        }

        public void setIntert(double intert) {
            this.intert = intert;
        }

        public String getNumcp() {
            return numcp;
        }

        public void setNumcp(String numcp) {
            this.numcp = numcp;
        }

    }

