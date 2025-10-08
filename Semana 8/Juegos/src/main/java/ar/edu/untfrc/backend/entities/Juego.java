package ar.edu.untfrc.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "JUEGOS")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JUEGO_ID")
    private Integer id;

    @Column(name = "TITULO", nullable = false, length = 255)
    private String titulo;

    @Column(name = "FECHA_LANZAMIENTO")
    private Integer fechaLanzamiento;  // Cambiado a Integer

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GENERO_ID", referencedColumnName = "GEN_ID")
    private Genero genero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DESARROLLADOR_ID", referencedColumnName = "DESA_ID")
    private Desarrollador desarrollador;

    @Enumerated(EnumType.STRING)
    @Column(name = "CLASIFICACION_ESRB", length = 4)
    private ClasificacionEsrb clasificacionESRB;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PLATAFORMA_ID", referencedColumnName = "PLAT_ID")
    private Plataforma plataforma;

    @Column(name = "RATING")
    private Double rating;  // Cambiado a Double

    @Column(name = "JUEGOS_FINALIZADOS")
    private Integer juegosFinalizados;  // Cambiado a Integer

    @Column(name = "JUGANDO")
    private Integer jugando;  // Cambiado a Integer

    @Lob
    @Column(name = "RESUMEN", nullable = false)
    private String resumen;
}
