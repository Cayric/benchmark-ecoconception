package fr.memoire.benchmark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name="synopsis", columnDefinition="MEDIUMBLOB")
    private String synopsis;

    @ManyToOne
    private Author author;

}
