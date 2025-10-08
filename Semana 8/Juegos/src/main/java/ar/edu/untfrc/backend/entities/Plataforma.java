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
@Table(name = "PLATAFORMAS")
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAT_ID")
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 255)
    private String nombre;

    @OneToMany(mappedBy = "plataforma", fetch = FetchType.LAZY)
    private Set<Juego> juegos = new HashSet<>();

    public void addJuego(Juego juego) {
        this.juegos.add(juego);
        juego.setPlataforma(this);
    }
}
