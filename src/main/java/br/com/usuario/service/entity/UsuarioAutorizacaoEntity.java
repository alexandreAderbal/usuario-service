package br.com.usuario.service.entity;

import br.com.lib.custom.auditoria.AuditorEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "USUARIO_AUTORIZACAO")
@AuditTable(value = "USUARIO_AUTORIZACAO_AUDITORIA")
@Audited
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioAutorizacaoEntity extends AuditorEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERMISSAO", referencedColumnName = "ID")
    private PermissaoEntity permissao;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PREVILEGIO", referencedColumnName = "ID")
    private PrevilegioEntity previlegio;
}
