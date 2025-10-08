package ar.edu.untfrc.backend.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GENEROS")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GEN_ID")
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 255)
    private String nombre;

    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
    private Set<Juego> juegos = new HashSet<>();

    public void addJuego(Juego juego) {
        this.juegos.add(juego);
        juego.setGenero(this);
    }
}

