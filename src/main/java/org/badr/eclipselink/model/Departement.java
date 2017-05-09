/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.eclipselink.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author oussama
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@SqlResultSetMappings({
    @SqlResultSetMapping(
            name = "DepEmpMapping",
            classes
            = @ConstructorResult(targetClass = DepartementDTO.class,
                    columns = {
                        @ColumnResult(name = "departementLocation", type = String.class),
                        @ColumnResult(name = "employeesFullName", type = String.class)
                    })
    )
})
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column
    private String Location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "departement_ID")
    private List<Employee> employees;
}
