package br.com.usuario.service.entity;

import br.com.lib.custom.auditoria.AuditorEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.Collection;

@Entity
@Table(name = "PREVILEGIO")
@AuditTable(value = "PREVILEGIO_AUDITORIA")
@Audited
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrevilegioEntity extends AuditorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @NotAudited
    @ManyToMany(mappedBy = "previlegios")
    private Collection<PermissaoEntity> permissoes;
}
