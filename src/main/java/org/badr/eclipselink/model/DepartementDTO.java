/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.eclipselink.model;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author oussama
 */
@Getter @AllArgsConstructor
public class DepartementDTO {

    private String departementLocation;

    private String employeesFullName;

    @Override
    public String toString() {
        return departementLocation + " " + employeesFullName;// + " [" + employeesFullName.stream().collect(Collectors.joining(", ")) + "]";
    }


}
