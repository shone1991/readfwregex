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
public class Employee {
    
    private Department department;

    /**
     * Get the value of department
     *
     * @return the value of department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Set the value of department
     *
     * @param department new value of department
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    private String surname;

    /**
     * Get the value of namedepartment
     *
     * @return the value of namedepartment
     */
    public String getName() {
        return surname;
    }

    /**
     * Set the value of namedepartment
     *
     * @param name new value of namedepartment
     */
    public void setName(String name) {
        this.surname = name;
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
