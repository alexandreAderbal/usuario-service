package br.com.usuario.service.entity;

import br.com.lib.custom.auditoria.AuditorEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.Collection;

@Entity
@Table(name = "PERMISSAO")
@AuditTable(value = "PERMISSAO_AUDITORIA")
@Audited
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermissaoEntity extends AuditorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @NotAudited
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name = "PERMISSAO_PREVILEGIO",
        joinColumns = @JoinColumn(name = "ID_PERMISSAO", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn( name = "ID_PREVILEGIO", referencedColumnName = "ID"))
    private Collection<PrevilegioEntity> previlegios;
}
