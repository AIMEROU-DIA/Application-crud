package sn.aimerou.crid_springboot.entity;

import jakarta.persistence.*;
import lombok.Data; // Importez l'annotation Data de Lombok
import lombok.NoArgsConstructor; // (Optionnel) Ajoute un constructeur sans arguments
import lombok.AllArgsConstructor; // (Optionnel) Ajoute un constructeur avec tous les arguments

@Entity
@Table(name= "personnes")
@Data // Cette annotation génère les getters et setters, equals, hashCode et toString
@NoArgsConstructor // Lombok génère un constructeur par défaut (sans arguments)
@AllArgsConstructor // Lombok génère un constructeur avec tous les champs comme arguments
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    private String city;

    private String numero;
}