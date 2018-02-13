/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investigating;

/**
 *
 * @author LapasovFG.VCRP
 */
public class Department {
    
    private String namedepartment;

    /**
     * Get the value of namedepartment
     *
     * @return the value of namedepartment
     */
    public String getNamedepartment() {
        return namedepartment;
    }

    /**
     * Set the value of namedepartment
     *
     * @param namedepartment new value of namedepartment
     */
    public void setNamedepartment(String namedepartment) {
        this.namedepartment = namedepartment;
    }

    private Integer id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
