package org.terrakube.api.rs.team;

import com.yahoo.elide.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.terrakube.api.rs.IdConverter;
import org.terrakube.api.rs.Organization;
import org.hibernate.annotations.Type;

import jakarta.persistence.*;

import java.sql.Types;
import java.util.UUID;

@CreatePermission(expression = "user is a superuser")
@UpdatePermission(expression = "user is a superuser")
@DeletePermission(expression = "user is a superuser")
@Include(rootLevel = false)
@Getter
@Setter
@Entity(name = "team")
public class Team {

    @Id
    @JdbcTypeCode(Types.VARCHAR)
    @Convert(converter = IdConverter.class)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "manage_workspace")
    private boolean manageWorkspace;

    @Column(name = "manage_module")
    private boolean manageModule;

    @Column(name = "manage_provider")
    private boolean manageProvider;

    @Column(name = "manage_vcs")
    private boolean manageVcs;

    @Column(name = "manage_template")
    private boolean manageTemplate;

    @ManyToOne
    private Organization organization;
}
