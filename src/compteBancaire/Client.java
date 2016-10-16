package compteBancaire;
import java.util.Scanner;
/**
 * Created by H on 16/10/2016.
 */
public class Client {
    static Scanner lire = new Scanner(System.in);
    private static int nbClient; // combien de compte existe dans la banque

    public void c_compte(Compte cp[], int nbcmp) {
        if (nbcmp == 0) {
            System.out.println("numero compte");
            lire.nextLine();
            String numero = lire.nextLine();
            System.out.println("nom");
            String nom = lire.nextLine();

            if (numero.length() >= 6) {
                cp[nbcmp] = new Compte(numero, nom);
                cp[nbcmp].setIntert((int) (1 + Math.random() * 20));
            }

            else
                System.err.print("échec de la création du compte");

        } else
            creatAuto(cp, nbcmp);

    }

    public void creatAuto(Compte[] cp, int nbcmp) {
        cp[nbcmp] = new Compte(cp[0].getNumcp(), cp[0].getNom());
        cp[nbcmp].setIntert((int) (1 + Math.random() * 20));

    }

    public static void main(String[] args) {
        // *reserver à la banque

        Client[] ct = new Client[10000]; // 10000 nombre de client
        for (int count = 0; count < ct.length; count++) {
            ct[count] = new Client();
        }
        Compte[] cp = new Compte[7];
        nbClient = 1;
        while (nbClient <= 10000) {
            System.out.print("=========");
            System.out.print("\tBienvenue");
            System.out.print("\t=========");
            boolean reponse = true;
            int nbcmp = 0;
            while (reponse) {

                System.out.println("");
                System.out.print("\n               Menu           ");
                System.out.print(" \n     -------------------------");
                System.out.print("\n       ||1) Crée un  compte ||");
                System.out.print("\n       ||2) |depot          ||");
                System.out.print("\n       ||3) |retrait        ||");
                System.out.print("\n       ||4) afficher compte ||");
                System.out.print("\n       ||5) quitté          ||");
                System.out.println(" \n      ------------------------");
                System.out.print("\n>");

                switch (lire.nextInt()) {
                    case 1:

                        ct[nbClient].c_compte(cp, nbcmp);
                        System.out.println("compte crée avec succées");
                        cp[nbcmp].afficher(nbcmp);
                        nbcmp++;
                        nbClient++; // peut etre acceder que par la banque
                        break;
                    case 2:

                        for (int count = 0; count < nbcmp; count++) {
                            System.out.println((count + 1));
                            cp[count].afficher(count);

                        }
                        System.out.println("Quel compte :");
                        System.out.println("-");

                        int choix = lire.nextInt();
                        double montant;
                        System.out.println("montant");
                        montant = lire.nextDouble();
                        cp[(choix - 1)].setSolde((montant));
                        cp[(choix - 1)].intert(cp[(choix - 1)].getIntert());
                        System.out.println("le compte " + choix
                                + "solde(avec intert)"
                                + (float) (cp[(choix - 1)].getSolde()));
                        break;
                    case 3:
                        for (int count = 0; count < nbcmp; count++) {
                            System.out.println((count + 1));
                            cp[count].afficher(count);

                        }
                        System.out.println("Quel compte :");
                        System.out.println("-");
                        int choix1 = lire.nextInt();
                        double montant1;
                        System.out.println("montant");
                        montant1 = lire.nextDouble();
                        if (montant1 <= cp[(choix1 - 1)].getSolde()) {
                            cp[(choix1 - 1)]
                                    .setSolde((cp[(choix1 - 1)].getSolde() - montant1));
                            cp[(choix1 - 1)].intert(cp[(choix1 - 1)].getIntert());
                            System.out.println("le compte " + choix1
                                    + "solde(avec intert)"
                                    + cp[(choix1 - 1)].getSolde());
                        } else
                            System.out.print("vous etre a cours de solde");
                        break;
                    case 4:
                        double totsold = 0;
                        for (int count = 0; count < nbcmp; count++) {
                            cp[count].afficher(count);
                            totsold += cp[count].getSolde();
                        }
                        System.out.println("le compte du client nommé "
                                + cp[0].getNom() + "est de " + totsold);
                        break;
                    case 5:
                        nbClient++;
                        reponse = false;
                        break;

                }

            }

        }
    }

}


