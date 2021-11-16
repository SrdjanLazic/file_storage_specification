package rs.edu.raf.storage.enums;

/**
 * Privilegije koje korisnici mogu imati (od kojih superuser poseduje sve)
 * VIEW - pregled svih fajlova sa skladista (i mogucnost listanja istih)
 * DOWNLOAD - mogucnost preuzimanja fajlova sa skladista
 * CREATE - mogucnost snimanja, kreiranja i pomeranja fajlova unutar skladista
 * DELETE - mogucnost brisanja fajlova sa skladista
 * Jedino superuser moze imati privilegije za postavljanje konfiguracije skladista i korisnicke administracije
 */
public enum Privileges {
    DELETE, CREATE, DOWNLOAD, VIEW

    // User 2 = {DELETE, CREATE, DOWNLOAD, VIEW}
    // folder2 = {DOWNLOAD, VIEW}



}
