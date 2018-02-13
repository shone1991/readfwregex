/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investigating;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author LapasovFG.VCRP
 */
public class TestSorting {

    public static void main(String[] args) {
        Department d1 = new Department();
        d1.setId(4523);
        d1.setNamedepartment("IVC");
        Department d2=new Department();
        d2.setId(7887);
        d2.setNamedepartment("NOK");
        Department d3=new Department();
        d3.setId(2342);
        d3.setNamedepartment("V");
        
        Employee e1=new Employee();
        e1.setId(33333);
        e1.setDepartment(d1);
        e1.setName("AAAAAAAA");
        
        Employee e2=new Employee();
        e2.setId(44444);
        e2.setName("BBBBBBB");
        e2.setDepartment(d1);
        
        Employee e3=new Employee();
        e3.setId(345345);
        e3.setName("VVVVVVV");
        e3.setDepartment(d2);
        
        Employee e4=new Employee();
        e4.setId(65756);
        e4.setName("BBBBBBB");
        e4.setDepartment(d3);
        
        List<Employee> listemp=new ArrayList();
        listemp.add(e1);
        listemp.add(e2);
        listemp.add(e3);
        listemp.add(e4);
        
        Map<Department, List<Employee>> byDept = listemp.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        for(Employee e: byDept.get(d1)){
            System.out.println("emp: "+e.getName()+", Dep: "+d1.getNamedepartment());
        }
        System.out.println("res"+byDept.get(d1));
        
    }
}
